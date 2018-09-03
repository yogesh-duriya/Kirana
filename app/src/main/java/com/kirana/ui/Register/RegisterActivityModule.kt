package com.kirana.ui.Register

import com.kirana.ui.Register.interactor.RegisterInteractor
import com.kirana.ui.Register.interactor.RegisterMVPInteractor
import com.kirana.ui.Register.presenter.RegisterMVPPresenter
import com.kirana.ui.Register.presenter.RegisterPresenter
import com.kirana.ui.Register.view.RegisterMVPView
import dagger.Module
import dagger.Provides

@Module
class RegisterActivityModule {

    @Provides
    internal fun provideRegisterInteractor(interactor: RegisterInteractor): RegisterMVPInteractor = interactor

    @Provides
    internal fun provideRegisterPresenter(presenter: RegisterPresenter<RegisterMVPView, RegisterMVPInteractor>)
            : RegisterMVPPresenter<RegisterMVPView, RegisterMVPInteractor> = presenter
}