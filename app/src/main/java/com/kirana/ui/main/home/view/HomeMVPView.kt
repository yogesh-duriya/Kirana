package com.kirana.ui.main.home.view

import com.kirana.data.network.Shop
import com.kirana.ui.base.view.MVPView

interface HomeMVPView : MVPView {

    fun displayShopList(list: List<Shop>?) : Unit?

}