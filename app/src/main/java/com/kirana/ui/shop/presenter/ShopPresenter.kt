package com.kirana.ui.shop.presenter

import com.kirana.ui.base.presenter.BasePresenter
import com.kirana.ui.shop.interactor.ShopMVPInteractor
import com.kirana.ui.shop.view.ShopMVPView
import com.kirana.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ShopPresenter<V : ShopMVPView, I : ShopMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable =  compositeDisposable), ShopMVPPresenter<V, I> {

    override fun onViewPrepared(method: String, category: String) {
        getView()?.showProgress()
        interactor?.let {
            it.getProductList()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe{
                        productListResponse ->
                        getView()?.let {
                            it.hideProgress()
                            it.displayProductList(productListResponse.data)
                        }
                    }
        }
    }

}