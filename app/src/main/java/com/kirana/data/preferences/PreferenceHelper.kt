package com.kirana.data.preferences

import com.kirana.util.AppConstants

interface PreferenceHelper {

    fun getCurrentUserLoggedInMode(): Int

    fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode)

    fun getCurrentUserId(): String?

    fun setCurrentUserId(userId: String?)

    fun getCurrentUserName(): String

    fun setCurrentUserName(userName: String?)

    fun getCurrentUserEmail(): String?

    fun setCurrentUserEmail(email: String?)

    fun getAccessToken(): String?

    fun setAccessToken(accessToken: String?)

    fun getFirstTime(): String

    fun setFirstTime(userName: String?)

    fun getFirstName(): String

    fun setFirstName(userName: String?)

    fun getLastName(): String

    fun setLastName(userName: String?)

    fun getMobileNo(): String

    fun setMobileNo(userName: String?)

    fun getUserInfo(): HashMap<Int, String>


}