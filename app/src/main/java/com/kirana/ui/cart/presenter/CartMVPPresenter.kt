package com.kirana.ui.cart.presenter

import com.kirana.ui.base.presenter.MVPPresenter
import com.kirana.ui.cart.interactor.CartMVPInteractor
import com.kirana.ui.cart.view.CartMVPView
interface CartMVPPresenter<V: CartMVPView, I : CartMVPInteractor> : MVPPresenter<V, I> {

    fun onViewPrepared(method: String, category: String)

}