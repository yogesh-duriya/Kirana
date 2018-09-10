package com.kirana.ui.productList.presenter

import com.kirana.ui.base.presenter.BasePresenter
import com.kirana.ui.productList.interactor.ProductListMVPInteractor
import com.kirana.ui.productList.view.ProductListMVPView
import com.kirana.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ProductListPresenter<V : ProductListMVPView, I : ProductListMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable =  compositeDisposable), ProductListMVPPresenter<V, I> {

    override fun onViewPrepared(method: String, category: String) {
        getView()?.showProgress()
        interactor?.let {
            it.getProductList()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe{
                        shopResponse ->
                        getView()?.let {
                            it.hideProgress()
                            it.displayProductList(shopResponse.data)
                        }
                    }
        }
    }

}