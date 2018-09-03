package com.kirana.ui.Register.presenter

import com.kirana.ui.Register.interactor.RegisterMVPInteractor
import com.kirana.ui.Register.view.RegisterMVPView
import com.kirana.ui.base.presenter.MVPPresenter

interface RegisterMVPPresenter<V : RegisterMVPView, I : RegisterMVPInteractor> : MVPPresenter<V, I> {

    fun onRegisterClicked(method: String, firstName: String, lastName: String, email: String, mobile: String, password: String )

}