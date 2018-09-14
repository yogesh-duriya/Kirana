package com.kirana.ui.cart.presenter

import com.kirana.ui.base.presenter.BasePresenter
import com.kirana.ui.cart.interactor.CartMVPInteractor
import com.kirana.ui.cart.view.CartMVPView
import com.kirana.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CartPresenter<V : CartMVPView, I : CartMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable =  compositeDisposable), CartMVPPresenter<V, I> {

    override fun onViewPrepared(method: String, category: String) {
        getView()?.showProgress()
        interactor?.let {
            it.getCartList()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe{
                        shopResponse ->
                        getView()?.let {
                            it.hideProgress()
                            it.displayCartList(shopResponse.data)
                        }
                    }
        }
    }

}