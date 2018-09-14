package com.kirana.ui.main.orders.viewReceipt.presenter

import com.kirana.ui.base.presenter.MVPPresenter
import com.kirana.ui.main.orders.viewReceipt.interactor.ViewReceiptMVPInterator
import com.kirana.ui.main.orders.viewReceipt.view.ViewRecieptDialogMVPView


interface ViewReceiptMVPPresenter<V : ViewRecieptDialogMVPView, I : ViewReceiptMVPInterator> : MVPPresenter<V, I> {

    fun onLaterOptionClicked() : Unit?
    fun onSubmitOptionClicked() : Unit?

}