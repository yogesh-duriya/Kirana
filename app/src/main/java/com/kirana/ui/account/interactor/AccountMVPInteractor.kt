package com.kirana.ui.account.interactor

import com.kirana.ui.base.interactor.MVPInteractor

interface AccountMVPInteractor : MVPInteractor {

    //fun doServerLoginApiCall(method: String, email: String, password: String, MAC_ID: String): Observable<LoginResponse>

    fun getUserFromSharedPref(): HashMap<Int, String>

}