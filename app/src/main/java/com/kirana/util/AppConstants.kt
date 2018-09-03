package com.kirana.util

object AppConstants {

    internal val APP_DB_NAME = "pixyrs.db"
    internal val PREF_NAME = "pixyrs_pref"
    internal val SEED_DATABASE_QUESTIONS = "seed/questions.json"
    internal val SEED_DATABASE_OPTIONS = "seed/options.json"
    internal val EMPTY_EMAIL_ERROR = 1001
    internal val INVALID_EMAIL_ERROR = 1002
    internal val EMPTY_PASSWORD_ERROR = 1003
    internal val LOGIN_FAILURE = 1004
    internal val EMPTY_FIRST_NAME_ERROR = 1005
    internal val EMPTY_SURNAME_ERROR = 1006
    internal val EMPTY_MOBILE_ERROR = 1007
    internal val REGISTER_FAILURE = 1008
    internal val NULL_INDEX = -1L

    enum class LoggedInMode constructor(val type: Int){
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3)
    }
}