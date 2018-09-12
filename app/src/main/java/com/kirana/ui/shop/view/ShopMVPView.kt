package com.kirana.ui.shop.view

import com.kirana.data.network.Product
import com.kirana.ui.base.view.MVPView

interface ShopMVPView : MVPView {

    fun displayProductList(list: List<Product>?) : Unit?

}