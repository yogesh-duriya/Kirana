package com.kirana.ui.cart.interactor

import com.kirana.data.network.ShopResponse
import com.kirana.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface CartMVPInteractor : MVPInteractor {

    fun getCartList(): Observable<ShopResponse>

}