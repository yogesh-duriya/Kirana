package com.kirana.ui.cart.view

import com.kirana.data.network.Shop
import com.kirana.ui.base.view.MVPView

interface CartMVPView : MVPView {

    fun displayCartList(list: List<Shop>?) : Unit?

}