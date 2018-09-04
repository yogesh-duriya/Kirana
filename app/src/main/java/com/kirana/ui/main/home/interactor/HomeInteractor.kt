package com.kirana.ui.main.home.interactor

import com.kirana.data.network.ApiHelper
import com.kirana.data.network.ShopResponse
import com.kirana.data.preferences.PreferenceHelper
import com.kirana.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

class HomeInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), HomeMVPInteractor{

    override fun getShopList() = apiHelper.getShopApiCall()

}