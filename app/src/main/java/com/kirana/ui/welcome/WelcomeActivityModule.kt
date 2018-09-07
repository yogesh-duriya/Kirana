package com.kirana.ui.welcome

import com.kirana.ui.base.interactor.BaseInteractor
import com.kirana.ui.base.interactor.MVPInteractor
import com.kirana.ui.splash.view.SplashMVPView
import com.kirana.ui.welcome.interactor.WelcomeInteractor
import com.kirana.ui.welcome.interactor.WelcomeMVPInteractor
import com.kirana.ui.welcome.presenter.WelcomeMVPPresenter
import com.kirana.ui.welcome.presenter.WelcomePresenter
import dagger.Module
import dagger.Provides

@Module
class WelcomeActivityModule {

    @Provides
    internal fun provideWelcomeInteractor(welcomeInteractor: WelcomeInteractor) : WelcomeMVPInteractor = welcomeInteractor

    @Provides
    internal fun provideWelcomePresenter(welcomePresenter: WelcomePresenter<SplashMVPView, WelcomeMVPInteractor>)
            : WelcomeMVPPresenter<SplashMVPView, WelcomeMVPInteractor> = welcomePresenter

}