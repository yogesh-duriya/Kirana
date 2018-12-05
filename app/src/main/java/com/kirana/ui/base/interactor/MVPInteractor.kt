package com.kirana.ui.base.interactor

interface MVPInteractor {

    fun isUserLoggedIn(): Boolean

    fun isFirstTime(): String

    fun performUserLogout()

    fun performFirstTime()

    fun getUserId() : String?
}