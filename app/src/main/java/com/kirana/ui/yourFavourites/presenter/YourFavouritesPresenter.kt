package com.kirana.ui.yourFavourites.presenter

import com.kirana.ui.base.presenter.BasePresenter
import com.kirana.ui.productList.interactor.ProductListMVPInteractor
import com.kirana.ui.productList.presenter.ProductListMVPPresenter
import com.kirana.ui.productList.view.ProductListMVPView
import com.kirana.ui.yourFavourites.interactor.YourFavouritesMVPInteractor
import com.kirana.ui.yourFavourites.view.YourFavouritesMVPView
import com.kirana.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class YourFavouritesPresenter<V : YourFavouritesMVPView, I : YourFavouritesMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable =  compositeDisposable), YourFavouritesMVPPresenter<V, I> {

    override fun onViewPrepared() {
        getView()?.showProgress()
        interactor?.let {
            it.getProductList()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe{
                        shopResponse ->
                        getView()?.let {
                            it.hideProgress()
                            it.displayFavouriteList(shopResponse.data)
                        }
                    }
        }
    }

}