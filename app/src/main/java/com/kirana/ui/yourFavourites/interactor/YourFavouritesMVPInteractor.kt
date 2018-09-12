package com.kirana.ui.yourFavourites.interactor

import com.kirana.data.network.ShopResponse
import com.kirana.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface YourFavouritesMVPInteractor : MVPInteractor {

    fun getProductList(): Observable<ShopResponse>

}