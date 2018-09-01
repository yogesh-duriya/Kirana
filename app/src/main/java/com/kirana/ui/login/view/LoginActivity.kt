package com.kirana.ui.login.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kirana.R
import com.kirana.ui.base.view.BaseActivity
import com.kirana.ui.login.interactor.LoginMVPInteractor
import com.kirana.ui.login.presenter.LoginMVPPresenter
import com.kirana.util.AppConstants
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginMVPView {

    @Inject
    internal lateinit var presenter: LoginMVPPresenter<LoginMVPView, LoginMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter.onAttach(this)
        setOnClickListeners()

    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun onFragmentDetached(tag: String){

    }

    override fun onFragmentAttached() {

    }


    override fun showValidationMessage(errorCode: Int) {
        when(errorCode){
            AppConstants.EMPTY_EMAIL_ERROR -> Toast.makeText(this, getString(R.string.empty_email_error_message), Toast.LENGTH_LONG ).show()
            AppConstants.INVALID_EMAIL_ERROR -> Toast.makeText(this, getString(R.string.invalid_email_error_message), Toast.LENGTH_LONG ).show()
            AppConstants.EMPTY_PASSWORD_ERROR -> Toast.makeText(this, getString(R.string.empty_password_error_message), Toast.LENGTH_LONG ).show()
            AppConstants.LOGIN_FAILURE -> Toast.makeText(this, getString(R.string.login_failure), Toast.LENGTH_LONG ).show()
        }
    }

    override fun openMainActivity() {
        /*val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()*/
        showToast("Login successfull")
    }


    private fun setOnClickListeners() {

        btn_server_login.setOnClickListener {presenter.onServerLoginClicked("GetLoginDetails", et_email.text.toString(), et_password.text.toString(), "AC:C1:EE:63:59:49") }

    }

}
