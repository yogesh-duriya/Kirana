package com.kirana.ui.yourFavourites.presenter

import com.kirana.ui.base.presenter.MVPPresenter
import com.kirana.ui.productList.interactor.ProductListMVPInteractor
import com.kirana.ui.yourFavourites.interactor.YourFavouritesMVPInteractor
import com.kirana.ui.yourFavourites.view.YourFavouritesMVPView

interface YourFavouritesMVPPresenter<V: YourFavouritesMVPView, I : YourFavouritesMVPInteractor> : MVPPresenter<V, I> {

    fun onViewPrepared()

}