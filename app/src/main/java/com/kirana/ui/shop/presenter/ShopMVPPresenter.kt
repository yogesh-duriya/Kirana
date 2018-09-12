package com.kirana.ui.shop.presenter

import com.kirana.ui.base.presenter.MVPPresenter
import com.kirana.ui.productList.interactor.ProductListMVPInteractor
import com.kirana.ui.productList.view.ProductListMVPView
import com.kirana.ui.shop.interactor.ShopMVPInteractor
import com.kirana.ui.shop.view.ShopMVPView

interface ShopMVPPresenter <V: ShopMVPView, I : ShopMVPInteractor> : MVPPresenter<V, I> {

    fun onViewPrepared(method: String, category: String)

}