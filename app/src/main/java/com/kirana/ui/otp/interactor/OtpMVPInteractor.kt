package com.kirana.ui.otp.interactor

import com.kirana.data.network.LoginResponse
import com.kirana.data.network.OtpResponse
import com.kirana.ui.base.interactor.MVPInteractor
import com.kirana.util.AppConstants
import io.reactivex.Observable

interface OtpMVPInteractor : MVPInteractor {

    fun doSubmitOtpApiCall(method: String, otp: String): Observable<LoginResponse>

    fun getOtpApiCall(method: String) : Observable<OtpResponse>

    fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode)

}