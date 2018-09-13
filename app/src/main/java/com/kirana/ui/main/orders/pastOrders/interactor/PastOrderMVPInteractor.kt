package com.kirana.ui.main.orders.pastOrders.interactor

import com.kirana.data.network.PastOrderResponse
import com.kirana.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface PastOrderMVPInteractor: MVPInteractor {

    fun getOrderList() : Observable<PastOrderResponse>



}