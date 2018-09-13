package com.kirana.ui.account.presenter

import com.kirana.ui.account.interactor.AccountMVPInteractor
import com.kirana.ui.account.view.AccountMVPView
import com.kirana.ui.base.presenter.MVPPresenter

interface AccountMVPPresenter<V : AccountMVPView, I : AccountMVPInteractor> : MVPPresenter<V, I> {

    fun getUserFromPref()

    fun UserLogOut()

}