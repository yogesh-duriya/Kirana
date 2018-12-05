package com.kirana.ui.otp.interactor

import com.kirana.data.network.ApiHelper
import com.kirana.data.network.LoginResponse
import com.kirana.data.network.OtpResponse
import com.kirana.data.preferences.PreferenceHelper
import com.kirana.ui.base.interactor.BaseInteractor
import com.kirana.util.AppConstants
import io.reactivex.Observable
import javax.inject.Inject

class OtpInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), OtpMVPInteractor {

    override fun doSubmitOtpApiCall(method: String, otp: String): Observable<LoginResponse> =
            apiHelper.performOtp(method, otp, preferenceHelper.getCurrentUserId())

    override fun getOtpApiCall(method: String) : Observable<OtpResponse> =
            apiHelper.getOtp(method, preferenceHelper.getCurrentUserId())

    override fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode) {
        preferenceHelper.let {
            it.setCurrentUserId(loginResponse.AgentMainID)
            it.setAccessToken(loginResponse.accessToken)
            it.setCurrentUserLoggedInMode(loggedInMode)
        }
    }

}