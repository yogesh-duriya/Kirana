package com.kirana.ui.base.interactor

import com.kirana.data.network.ApiHelper
import com.kirana.data.preferences.PreferenceHelper
import com.kirana.util.AppConstants

open class BaseInteractor() : MVPInteractor {

    protected lateinit var preferenceHelper: PreferenceHelper
    protected lateinit var apiHelper: ApiHelper

    constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : this() {
        this.preferenceHelper = preferenceHelper
        this.apiHelper = apiHelper
    }

    override fun isUserLoggedIn() = this.preferenceHelper.getCurrentUserLoggedInMode() != AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type

    override fun isFirstTime() = this.preferenceHelper.getFirstTime()

    override fun performUserLogout() = preferenceHelper.let {
        it.setCurrentUserId(null)
        it.setAccessToken(null)
        it.setCurrentUserEmail(null)
        it.setCurrentUserLoggedInMode(AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT)
    }


}