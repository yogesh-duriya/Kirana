package com.kirana.ui.login.interactor

import com.kirana.data.network.ApiHelper
import com.kirana.data.network.LoginRequest
import com.kirana.data.network.LoginResponse
import com.kirana.data.preferences.PreferenceHelper
import com.kirana.ui.base.interactor.BaseInteractor
import com.kirana.util.AppConstants
import io.reactivex.Observable
import javax.inject.Inject

class LoginInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), LoginMVPInteractor{

    override fun doServerLoginApiCall(method: String, email: String, password: String, MAC_ID: String): Observable<LoginResponse> =
        //apiHelper.performServerLogin(LoginRequest.ServerLoginRequest(method = method, userID = email, password = password, MAC_ID = MAC_ID))
        apiHelper.performServerLogin( method, email, password, MAC_ID)


    override fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode) =
        preferenceHelper.let {
            it.setCurrentUserId(loginResponse.AgentMainID)
            it.setAccessToken(loginResponse.accessToken)
            it.setCurrentUserLoggedInMode(loggedInMode)
        }

}