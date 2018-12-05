package com.kirana.ui.Register.view

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.kirana.R
import com.kirana.ui.Register.interactor.RegisterMVPInteractor
import com.kirana.ui.Register.presenter.RegisterMVPPresenter
import com.kirana.ui.base.view.BaseActivity
import com.kirana.util.AppConstants
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject
import android.content.Intent
import android.text.TextUtils
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.credentials.Credential
import com.google.android.gms.auth.api.credentials.HintRequest
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.kirana.ui.otp.view.OtpActivity

class RegisterActivity : BaseActivity(), RegisterMVPView , GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private var RESOLVE_HINT = 1001
    private var apiClient: GoogleApiClient? = null

    @Inject
    internal lateinit var presenter: RegisterMVPPresenter<RegisterMVPView, RegisterMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        presenter.onAttach(this)

        setToolbar("Register")

        apiClient = GoogleApiClient.Builder(this)
                .addApi(Auth.CREDENTIALS_API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        //tie_mobile.setOnClickListener { requestHint() }
        tie_mobile.setOnFocusChangeListener { v, hasFocus ->  if (hasFocus)requestHint()}

        btn_register.setOnClickListener{ presenter.onRegisterClicked("Register",
                tie_first_name.text.toString().trim(), tie_surname.text.toString().trim(),
                tie_email.text.toString().trim(), tie_mobile.text.toString().trim(),
                tie_password.text.toString().trim()) }
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun showValidationMessage(errorCode: Int) {
        when(errorCode){
            AppConstants.EMPTY_FIRST_NAME_ERROR-> Toast.makeText(this, getString(R.string.empty_first_name_error_message), Toast.LENGTH_LONG ).show()
            AppConstants.EMPTY_SURNAME_ERROR-> Toast.makeText(this, getString(R.string.empty_surname_error_message), Toast.LENGTH_LONG ).show()
            AppConstants.EMPTY_EMAIL_ERROR-> Toast.makeText(this, getString(R.string.empty_email_error_message), Toast.LENGTH_LONG ).show()
            AppConstants.INVALID_EMAIL_ERROR -> Toast.makeText(this, getString(R.string.invalid_email_error_message), Toast.LENGTH_LONG ).show()
            AppConstants.EMPTY_MOBILE_ERROR -> Toast.makeText(this, getString(R.string.empty_mobile_error_message), Toast.LENGTH_LONG ).show()
            AppConstants.EMPTY_PASSWORD_ERROR -> Toast.makeText(this, getString(R.string.empty_password_error_message), Toast.LENGTH_LONG ).show()
            AppConstants.REGISTER_FAILURE -> Toast.makeText(this, getString(R.string.register_failure), Toast.LENGTH_LONG ).show()
        }
    }

    override fun openMainActivity() {
        /*val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()*/
        confirmOtp()
        //showToast("Register successfull")
    }

    private fun confirmOtp() {
        val intent = Intent(this, OtpActivity::class.java)
        intent.putExtra("MobileNo", tie_mobile.text.toString())
        startActivity(intent)
    }

    // Construct a request for phone numbers and show the picker
    private fun requestHint() {
        if (TextUtils.isEmpty(tie_mobile.text.toString())) {
            val hintRequest = HintRequest.Builder()
                    .setPhoneNumberIdentifierSupported(true)
                    .build()
            val intent = Auth.CredentialsApi.getHintPickerIntent(apiClient, hintRequest)
            startIntentSenderForResult(intent.getIntentSender(),
                    RESOLVE_HINT, null, 0, 0, 0)
        }
    }

    override fun onConnectionFailed(p0: ConnectionResult) {

    }

    override fun onConnected(p0: Bundle?) {

    }

    override fun onConnectionSuspended(p0: Int) {

    }


    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    // Obtain the phone number from the result
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESOLVE_HINT) {
            if (resultCode == Activity.RESULT_OK) {
                val credential = data.getParcelableExtra<Credential>(Credential.EXTRA_KEY)
                 var mobileNo = credential.getId();  // will need to process phone number string
                if (mobileNo.contains("+91"))
                    mobileNo = mobileNo.substring(3)
                tie_mobile.setText(mobileNo);
            }
        }
    }



}
