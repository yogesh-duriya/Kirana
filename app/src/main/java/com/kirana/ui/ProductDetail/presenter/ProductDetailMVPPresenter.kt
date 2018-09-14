package com.kirana.ui.ProductDetail.presenter

import com.kirana.ui.ProductDetail.interactor.ProductDetailMVPInteractor
import com.kirana.ui.ProductDetail.view.ProductDetailMVPView
import com.kirana.ui.base.presenter.MVPPresenter

interface ProductDetailMVPPresenter<V : ProductDetailMVPView, I : ProductDetailMVPInteractor> : MVPPresenter<V, I> {

    fun onAddToCartClicked(method: String, product_id : String)

}