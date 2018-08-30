package com.kirana.ui.splash

import com.kirana.ui.splash.interactor.SplashInteractor
import com.kirana.ui.splash.interactor.SplashMVPInteractor
import com.kirana.ui.splash.presenter.SplashMVPPresenter
import com.kirana.ui.splash.presenter.SplashPresenter
import com.kirana.ui.splash.view.SplashMVPView
import dagger.Module
import dagger.Provides

@Module
class SplashActivityModule {

    @Provides
    internal fun provideSplashInteractor(splashInteractor: SplashInteractor) : SplashMVPInteractor = splashInteractor

    @Provides
    internal fun provideSplashPresenter(splashPresenter: SplashPresenter<SplashMVPView, SplashMVPInteractor>)
            : SplashMVPPresenter<SplashMVPView, SplashMVPInteractor> = splashPresenter

}