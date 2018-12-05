package com.kirana.ui.otp.presenter

import com.kirana.ui.base.presenter.MVPPresenter
import com.kirana.ui.otp.interactor.OtpMVPInteractor
import com.kirana.ui.otp.view.OtpMVPView

interface OtpMVPPresenter<V : OtpMVPView, I : OtpMVPInteractor> : MVPPresenter<V, I>{

    fun onSubmitClicked(method: String, otp: String)

    fun onResendClicked(method: String)

    //fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode): Unit?

}