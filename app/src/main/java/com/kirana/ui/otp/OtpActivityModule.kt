package com.kirana.ui.otp

import com.kirana.ui.otp.interactor.OtpInteractor
import com.kirana.ui.otp.interactor.OtpMVPInteractor
import com.kirana.ui.otp.presenter.OtpMVPPresenter
import com.kirana.ui.otp.presenter.OtpPresenter
import com.kirana.ui.otp.view.OtpMVPView
import dagger.Module
import dagger.Provides

@Module
class OtpActivityModule {

    @Provides
    internal fun provideOtpInteractor(interactor: OtpInteractor): OtpMVPInteractor = interactor

    @Provides
    internal fun provideOtpPresenter(presenter: OtpPresenter<OtpMVPView, OtpMVPInteractor>)
            : OtpMVPPresenter<OtpMVPView, OtpMVPInteractor> = presenter

}