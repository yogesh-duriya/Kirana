package com.kirana.ui.otp.view

import com.kirana.ui.base.view.MVPView

interface OtpMVPView  : MVPView {

    fun showValidationMessage(errorCode: Int)
    fun openMainActivity()

}