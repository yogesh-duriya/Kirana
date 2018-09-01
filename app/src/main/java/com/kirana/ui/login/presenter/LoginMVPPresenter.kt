package com.kirana.ui.login.presenter

import com.kirana.ui.base.presenter.MVPPresenter
import com.kirana.ui.login.interactor.LoginMVPInteractor
import com.kirana.ui.login.view.LoginMVPView

interface LoginMVPPresenter<V : LoginMVPView, I : LoginMVPInteractor> : MVPPresenter<V, I> {

    fun onServerLoginClicked(method: String, email: String, password: String, MAC_ID: String)

}