package com.kirana.ui.welcome.presenter

import com.kirana.ui.base.presenter.MVPPresenter
import com.kirana.ui.splash.view.SplashMVPView
import com.kirana.ui.welcome.interactor.WelcomeMVPInteractor

interface WelcomeMVPPresenter<V : SplashMVPView, I : WelcomeMVPInteractor> : MVPPresenter<V, I> {

    fun decideActivityToOpen()

}