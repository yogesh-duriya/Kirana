package com.kirana.ui.login

import com.kirana.ui.login.interactor.LoginInteractor
import com.kirana.ui.login.interactor.LoginMVPInteractor
import com.kirana.ui.login.presenter.LoginMVPPresenter
import com.kirana.ui.login.presenter.LoginPresenter
import com.kirana.ui.login.view.LoginMVPView
import dagger.Module
import dagger.Provides

@Module
class LoginActivityModule {
    @Provides
    internal fun provideLoginInteractor(interactor: LoginInteractor): LoginMVPInteractor = interactor

    @Provides
    internal fun provideLoginPresenter(presenter: LoginPresenter<LoginMVPView, LoginMVPInteractor>)
        : LoginMVPPresenter<LoginMVPView, LoginMVPInteractor> = presenter
}