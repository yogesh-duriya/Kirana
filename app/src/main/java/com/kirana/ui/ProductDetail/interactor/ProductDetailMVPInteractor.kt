package com.kirana.ui.ProductDetail.interactor

import com.kirana.data.network.LoginResponse
import com.kirana.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface ProductDetailMVPInteractor : MVPInteractor {

    fun addToCart(method: String, user_id: String, product_id: String): Observable<LoginResponse>

}