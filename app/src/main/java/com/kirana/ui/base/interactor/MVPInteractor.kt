package com.kirana.ui.base.interactor

interface MVPInteractor {

    fun isUserLoggedIn(): Boolean

    fun performUserLogout()
}