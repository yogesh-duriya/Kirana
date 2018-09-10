package com.kirana.ui.productList.view

import com.kirana.data.network.Shop
import com.kirana.ui.base.view.MVPView

interface ProductListMVPView : MVPView{

    fun displayProductList(list: List<Shop>?) : Unit?

}