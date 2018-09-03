package com.kirana.ui.Register.interactor

import com.kirana.data.network.LoginResponse
import com.kirana.ui.base.interactor.MVPInteractor
import com.kirana.util.AppConstants
import io.reactivex.Observable

interface RegisterMVPInteractor : MVPInteractor {

    fun doRegisterApiCall(method: String, firstName: String, surname: String, email: String, mobile: String, password: String): Observable<LoginResponse>

    fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode)
}