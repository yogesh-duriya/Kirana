package com.kirana.ui.account.view

import com.kirana.ui.base.view.MVPView

interface AccountMVPView : MVPView {

    //fun showValidationMessage(errorCode: Int)
    fun openEditAccountActivity()

    fun setUserInfo(userInfo : HashMap<Int, String>)

}