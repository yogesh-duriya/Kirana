package com.kirana.ui.Register.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.kirana.R
import com.kirana.ui.Register.interactor.RegisterMVPInteractor
import com.kirana.ui.Register.presenter.RegisterMVPPresenter
import com.kirana.ui.base.view.BaseActivity
import com.kirana.util.AppConstants
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity : BaseActivity(), RegisterMVPView {

    @Inject
    internal lateinit var presenter: RegisterMVPPresenter<RegisterMVPView, RegisterMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        presenter.onAttach(this)

        setToolbar("Register")

        setOnClickListeners()

    }

    private fun setOnClickListeners() {
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
        showToast("Register successfull")
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

}
