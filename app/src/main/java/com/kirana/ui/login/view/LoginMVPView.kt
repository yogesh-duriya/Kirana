package com.kirana.ui.login.view

import com.kirana.ui.base.view.MVPView

interface LoginMVPView : MVPView {

    fun showValidationMessage(errorCode: Int)
    fun openMainActivity()
}