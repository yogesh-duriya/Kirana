package com.kirana.ui.main.orders.viewReceipt.presenter

import com.kirana.ui.base.presenter.BasePresenter
import com.kirana.ui.main.orders.viewReceipt.interactor.RateUsMVPInterator
import com.kirana.ui.main.orders.viewReceipt.view.ViewRecieptDialogMVPView
import com.kirana.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class RateUsPresenter<V : ViewRecieptDialogMVPView, I : RateUsMVPInterator> @Inject internal constructor(interator: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interator, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), RateUsMVPPresenter<V, I> {

    override fun onLaterOptionClicked() = getView()?.let { it.dismissDialog() }

    override fun onSubmitOptionClicked() = interactor?.let {
        it.submitRating()
        getView()?.let {
            it.showRatingSubmissionSuccessMessage()
            it.dismissDialog()
        }
    }
}
