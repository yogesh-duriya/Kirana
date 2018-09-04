package com.kirana.ui.main.home.interactor

import com.kirana.data.network.ShopResponse
import com.kirana.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface HomeMVPInteractor : MVPInteractor {

    fun getShopList(): Observable<ShopResponse>

}