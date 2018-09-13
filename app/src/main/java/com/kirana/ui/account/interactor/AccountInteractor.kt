package com.kirana.ui.account.interactor

import com.kirana.data.network.ApiHelper
import com.kirana.data.network.LoginResponse
import com.kirana.data.preferences.PreferenceHelper
import com.kirana.ui.base.interactor.BaseInteractor
import com.kirana.util.AppConstants
import javax.inject.Inject

class AccountInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), AccountMVPInteractor {

    override fun getUserFromSharedPref()  =
            preferenceHelper.getUserInfo()

}