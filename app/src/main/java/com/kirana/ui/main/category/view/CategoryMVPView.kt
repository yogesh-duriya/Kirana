package com.kirana.ui.main.category.view

import com.kirana.data.network.Shop
import com.kirana.ui.base.view.MVPView

interface CategoryMVPView : MVPView {

    fun displayCategories(list: List<Shop>?) : Unit?

}