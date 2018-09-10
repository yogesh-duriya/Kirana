package com.kirana.ui.productList.interactor

import com.kirana.data.network.ShopResponse
import com.kirana.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface ProductListMVPInteractor : MVPInteractor {

    fun getProductList(): Observable<ShopResponse>

}