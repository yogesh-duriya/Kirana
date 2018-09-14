package com.kirana.ui.main.orders.viewReceipt.presenter

import com.kirana.ui.base.presenter.BasePresenter
import com.kirana.ui.main.orders.viewReceipt.interactor.ViewReceiptMVPInterator
import com.kirana.ui.main.orders.viewReceipt.view.ViewRecieptDialogMVPView
import com.kirana.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ViewReceiptPresenter<V : ViewRecieptDialogMVPView, I : ViewReceiptMVPInterator> @Inject internal constructor(interator: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interator, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), ViewReceiptMVPPresenter<V, I> {

    override fun onLaterOptionClicked() = getView()?.let { it.dismissDialog() }

    override fun onSubmitOptionClicked() = interactor?.let {
        it.submitRating()
        getView()?.let {
            it.showRatingSubmissionSuccessMessage()
            it.dismissDialog()
        }
    }
}
