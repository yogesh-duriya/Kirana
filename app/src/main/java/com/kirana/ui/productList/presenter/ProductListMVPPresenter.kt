package com.kirana.ui.productList.presenter

import com.kirana.ui.base.presenter.MVPPresenter
import com.kirana.ui.productList.interactor.ProductListMVPInteractor
import com.kirana.ui.productList.view.ProductListMVPView

interface ProductListMVPPresenter <V: ProductListMVPView, I : ProductListMVPInteractor> : MVPPresenter<V, I> {

    fun onViewPrepared(method: String, category: String)

}