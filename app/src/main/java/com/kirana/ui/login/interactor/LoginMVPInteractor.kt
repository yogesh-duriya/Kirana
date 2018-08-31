package com.kirana.ui.login.interactor

import com.kirana.data.network.LoginResponse
import com.kirana.ui.base.interactor.MVPInteractor
import com.kirana.util.AppConstants
import io.reactivex.Observable

interface LoginMVPInteractor : MVPInteractor {

    fun doServerLoginApiCall(email: String, password: String): Observable<LoginResponse>

    fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode)

}