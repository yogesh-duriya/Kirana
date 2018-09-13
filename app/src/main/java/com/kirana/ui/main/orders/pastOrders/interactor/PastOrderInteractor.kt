package com.kirana.ui.main.orders.pastOrders.interactor

import com.kirana.data.network.*
import com.kirana.data.preferences.PreferenceHelper
import com.kirana.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

class PastOrderInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper : ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), PastOrderMVPInteractor {

    override fun getOrderList(): Observable<PastOrderResponse> = orders()

    private fun orders() : Observable<PastOrderResponse> {
        return Observable.just(PastOrderResponse("1", "Successfull", data = OrderList()))
    }

    private fun OrderList(): MutableList<Orders> {
        var orderList : MutableList<Orders> =
                mutableListOf(Orders("Chhabra's Pure Veg- Nirman Nagar", "1", "", "#132456", "5", "25 Aug 2018, 12:51", "Harish", "120.00", orderItems(),"10.00", "200.00", "10.00", "100"),
                        Orders("Chhabra's Pure Veg- Nirman Nagar", "2", "", "#78910", "4", "25 Aug 2018, 12:51", "Harish", "120.00", orderItems(),"10.00", "200.00", "10.00", "100"))
        return orderList
    }

    private fun orderItems(): List<OrderItem>? {
        var orderItem : MutableList<OrderItem>  =
                mutableListOf(OrderItem("Dal Fry", "2", "500Gms", "110.00", "1"),
                        OrderItem("kadai Paneer", "5", "250Gms", "90.00", "1"))

        return orderItem
    }

}