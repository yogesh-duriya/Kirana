package com.kirana.ui.Register.interactor

import com.kirana.data.network.ApiHelper
import com.kirana.data.network.LoginResponse
import com.kirana.data.preferences.PreferenceHelper
import com.kirana.ui.base.interactor.BaseInteractor
import com.kirana.util.AppConstants
import io.reactivex.Observable
import javax.inject.Inject

class RegisterInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), RegisterMVPInteractor{

    override fun doRegisterApiCall(method: String, firstName: String, surname: String, email: String, mobile: String, password: String): Observable<LoginResponse> =
        apiHelper.performRegister(method, firstName, surname, email, mobile, password)


    override fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode) {
        preferenceHelper.let {
            it.setCurrentUserId(loginResponse.AgentMainID)
            it.setAccessToken(loginResponse.accessToken)
            it.setCurrentUserLoggedInMode(loggedInMode)
        }
    }

}