package com.kirana.ui.yourFavourites.interactor

import com.kirana.data.network.ApiHelper
import com.kirana.data.network.Shop
import com.kirana.data.network.ShopResponse
import com.kirana.data.preferences.PreferenceHelper
import com.kirana.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

class YourFavouritesInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), YourFavouritesMVPInteractor {

    override fun getProductList() : Observable<ShopResponse> = shops()
    //apiHelper.getShopApiCall()

    private fun shops() : Observable<ShopResponse> {
        return Observable.just(ShopResponse("1", "Successfull", data = ShopList()))
    }

    private fun ShopList(): MutableList<com.kirana.data.network.Shop> {
        var shopList : MutableList<com.kirana.data.network.Shop> =
                mutableListOf(Shop("Natural Ice Creame - Vaishali Nagar", "1", "", "5.4","15-25 MIN", "(225)", "Cake * ice-creame * Coke", "", "2"),
                        Shop("Agarwal General Store", "2", "", "4.2","40-55 MIN", "(500+)", "Tea", "Use FF105 to get flat Ts 100 off your next 3 orders", "1"),
                        Shop("Agarwal General Store", "2", "", "4.2","40-55 MIN", "(500+)", "Tea", "", "1"),
                        Shop("Agarwal General Store", "2", "", "4.2","40-55 MIN", "(500+)", "Tea", "Use FF105 to get flat Ts 100 off your next 3 orders", "6"),
                        Shop("Natural Ice Creame - Vaishali Nagar", "1", "", "5.4","15-25 MIN", "(225)", "Cake * ice-creame * Coke", "", "8"))
        return shopList
    }
}