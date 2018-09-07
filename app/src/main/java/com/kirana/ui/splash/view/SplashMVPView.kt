package com.kirana.ui.splash.view

import com.kirana.ui.base.view.MVPView

interface SplashMVPView : MVPView {

    fun showSuccessToast()
    fun showErrorToast()
    fun openMainActivity()
    fun openLoginActivity()
    fun openWelcomeActivity()
}