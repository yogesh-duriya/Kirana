package com.kirana.ui.yourFavourites.view

import com.kirana.data.network.Shop
import com.kirana.ui.base.view.MVPView

interface YourFavouritesMVPView : MVPView {

    fun displayFavouriteList(list: List<Shop>?) : Unit?

}