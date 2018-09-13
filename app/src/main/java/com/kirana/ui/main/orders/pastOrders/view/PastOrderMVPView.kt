package com.kirana.ui.main.orders.pastOrders.view

import com.kirana.data.network.Category
import com.kirana.data.network.Orders
import com.kirana.ui.base.view.MVPView

interface PastOrderMVPView : MVPView {

    fun displayOrders(list: List<Orders>?) : Unit?

}