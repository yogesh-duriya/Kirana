package com.kirana.ui.main.home.presenter

import com.kirana.ui.base.presenter.BasePresenter
import com.kirana.ui.main.home.interactor.HomeMVPInteractor
import com.kirana.ui.main.home.view.HomeMVPView
import com.kirana.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomePresenter<V : HomeMVPView, I : HomeMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable =  compositeDisposable), HomeMVPPresenter<V, I> {

    override fun onViewPrepared() {
        getView()?.showProgress()
        interactor?.let {
            it.getShopList()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe{
                        shopResponse ->
                        getView()?.let {
                            it.hideProgress()
                            it.displayShopList(shopResponse.data)
                        }
                    }
        }
    }

}