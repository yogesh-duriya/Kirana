package com.kirana.ui.ProductDetail.interactor

import com.kirana.data.network.ApiHelper
import com.kirana.data.network.LoginResponse
import com.kirana.data.preferences.PreferenceHelper
import com.kirana.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

class ProductDetailInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), ProductDetailMVPInteractor {


    override fun addToCart(method: String, user_id: String, product_id: String): Observable<LoginResponse> =
        apiHelper.performAddToCart( method, user_id, product_id)


}