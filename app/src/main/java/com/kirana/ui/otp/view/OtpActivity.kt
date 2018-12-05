package com.kirana.ui.otp.view

import android.os.Bundle
import com.kirana.R
import com.kirana.ui.base.view.BaseActivity
import com.kirana.ui.otp.interactor.OtpMVPInteractor
import com.kirana.ui.otp.presenter.OtpMVPPresenter
import kotlinx.android.synthetic.main.activity_otp.*
import javax.inject.Inject

class OtpActivity : BaseActivity(), OtpMVPView  {

    @Inject
    internal lateinit var presenter: OtpMVPPresenter<OtpMVPView, OtpMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        presenter.onAttach(this)

        setToolbar("OTP")

        setClickListeners()

    }

    private fun setClickListeners() {
        tv_resend_otp.setOnClickListener { presenter.onResendClicked("ResendOtp") }

        btn_submit.setOnClickListener {  }
    }

    override fun onFragmentAttached() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentDetached(tag: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showValidationMessage(errorCode: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openMainActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}
