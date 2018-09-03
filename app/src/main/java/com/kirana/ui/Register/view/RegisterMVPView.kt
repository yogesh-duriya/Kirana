package com.kirana.ui.Register.view

import android.net.sip.SipErrorCode
import com.kirana.ui.base.view.MVPView

interface RegisterMVPView : MVPView{

    fun showValidationMessage(errorCode: Int)
    fun openMainActivity()
}