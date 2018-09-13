package com.kirana.ui.main.orders.pastOrders.presenter

import com.kirana.ui.base.presenter.BasePresenter
import com.kirana.ui.main.orders.pastOrders.interactor.PastOrderMVPInteractor
import com.kirana.ui.main.orders.pastOrders.view.PastOrderMVPView
import com.kirana.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PastOrderPresenter <V : PastOrderMVPView, I : PastOrderMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), PastOrderMVPPresenter<V, I> {
    override fun onViewPrepared() {
        getView()?.showProgress()
        interactor?.let {
            it.getOrderList()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe{
                        pastOrderResponse ->
                        getView()?.let {
                            it.hideProgress()
                            it.displayOrders(pastOrderResponse.data)
                        }
                    }
        }
    }

}