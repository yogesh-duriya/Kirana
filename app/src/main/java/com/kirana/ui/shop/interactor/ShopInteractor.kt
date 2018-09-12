package com.kirana.ui.shop.interactor

import com.kirana.data.network.*
import com.kirana.data.preferences.PreferenceHelper
import com.kirana.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

class ShopInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), ShopMVPInteractor {

    override fun getProductList() : Observable<ProductListResponse> = products()
    //apiHelper.getShopApiCall()

    private fun products() : Observable<ProductListResponse> {
        return Observable.just(ProductListResponse("1", "Successfull", data = ProductList()))
    }

    private fun ProductList(): MutableList<Product> {
        var productList : MutableList<Product> =
                mutableListOf(Product("Lipton pure &amp; Light Green Tea Bags", "1", "", "5.4","15-25 MIN", "(225)", "Rs. 400", "60"),
                        Product("Typhoo Pure Green Tea", "2", "", "4.2","40-55 MIN", "(500+)", "Rs. 300", "20"),
                        Product("SIDDHI ORGANICS Brown Sugar ", "3", "", "4.2","40-55 MIN", "(500+)", "Rs. 200", "40"),
                        Product("GroOrganic SUGAR brown Sugar", "4", "", "4.2","40-55 MIN", "(500+)", "Rs. 450", "50"),
                        Product("Veg E Wagon Icing Sugar", "5", "", "5.4","15-25 MIN", "(225)", "250", "15"))
        return productList
    }
}