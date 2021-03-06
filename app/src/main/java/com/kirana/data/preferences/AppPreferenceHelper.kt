package com.kirana.data.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.content.edit
import com.kirana.R
import com.kirana.di.PreferenceInfo
import com.kirana.util.AppConstants
import javax.inject.Inject

class AppPreferenceHelper @Inject constructor(context: Context,
                                              @PreferenceInfo private val prefFileName: String) : PreferenceHelper {

    companion object {
        private val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"
        private val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"
        private val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
        private val PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME"
        private val PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL"
        private val PREF_KEY_FIRST_TIME = "PREF_KEY_FIRST_TIME"
        private val PREF_KEY_FIRST_NAME = "PREF_KEY_FIRST_NAME"
        private val PREF_KEY_LAST_NAME = "PREF_KEY_LAST_NAME"
        private val PREF_KEY_MOBILE_NUMBER = "PREF_KEY_MOBILE_NUMBER"
    }

    private val mPrefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun getCurrentUserLoggedInMode() = mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE, AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type)

    override fun getCurrentUserName(): String = mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, "ABC")

    override fun setCurrentUserName(userName: String?) = mPrefs.edit { putString(PREF_KEY_CURRENT_USER_NAME, userName) }

    override fun getCurrentUserEmail(): String = mPrefs.getString(PREF_KEY_CURRENT_USER_EMAIL, "abc@gmail.com")

    override fun setCurrentUserEmail(email: String?) = mPrefs.edit { putString(PREF_KEY_CURRENT_USER_EMAIL, email) }

    override fun getMobileNo(): String = mPrefs.getString(PREF_KEY_MOBILE_NUMBER, "00000000000")

    override fun setMobileNo(email: String?) = mPrefs.edit { putString(PREF_KEY_MOBILE_NUMBER, email) }

    override fun getAccessToken(): String = mPrefs.getString(PREF_KEY_ACCESS_TOKEN, "")

    override fun setAccessToken(accessToken: String?) = mPrefs.edit { putString(PREF_KEY_ACCESS_TOKEN, accessToken) }

    override fun getCurrentUserId(): String? {
        val userId = mPrefs.getString(PREF_KEY_CURRENT_USER_ID,"")
        return when (userId) {
            else -> userId
        }
    }

    override fun setCurrentUserId(userId: String?) {
        val id = userId
        mPrefs.edit { putString(PREF_KEY_CURRENT_USER_ID, id) }
    }

    override fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode) {
        mPrefs.edit { putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.type) }
    }

    override fun getFirstTime(): String = mPrefs.getString(PREF_KEY_FIRST_TIME, "0")

    override fun setFirstTime(fistTime: String?) = mPrefs.edit { putString(PREF_KEY_FIRST_TIME, fistTime) }

    override fun getFirstName(): String = mPrefs.getString(PREF_KEY_FIRST_NAME, "0")

    override fun setFirstName(fistName: String?) = mPrefs.edit { putString(PREF_KEY_FIRST_NAME, fistName) }

    override fun getLastName(): String = mPrefs.getString(PREF_KEY_LAST_NAME, "0")

    override fun setLastName(lastName: String?) = mPrefs.edit { putString(PREF_KEY_LAST_NAME, lastName) }

    override fun getUserInfo(): HashMap<Int, String> {
        val hashMap:HashMap<Int,String> = HashMap<Int,String>()
        hashMap.put(R.string.KEY_FIRST_NAME, getFirstName())
        hashMap.put(R.string.KEY_LAST_NAME, getLastName())
        hashMap.put(R.string.KEY_EMAIL, getCurrentUserEmail())
        hashMap.put(R.string.KEY_MOBILE, getMobileNo())
        return hashMap
    }

}