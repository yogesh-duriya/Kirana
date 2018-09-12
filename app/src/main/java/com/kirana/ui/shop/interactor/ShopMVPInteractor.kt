package com.kirana.ui.shop.interactor

import com.kirana.data.network.ProductListResponse
import com.kirana.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface ShopMVPInteractor : MVPInteractor {

    fun getProductList(): Observable<ProductListResponse>

}