package com.kirana.ui.main.orders.viewReceipt.presenter

import com.kirana.ui.base.presenter.MVPPresenter
import com.kirana.ui.main.orders.viewReceipt.interactor.RateUsMVPInterator
import com.kirana.ui.main.orders.viewReceipt.view.ViewRecieptDialogMVPView


interface RateUsMVPPresenter<V : ViewRecieptDialogMVPView, I : RateUsMVPInterator> : MVPPresenter<V, I> {

    fun onLaterOptionClicked() : Unit?
    fun onSubmitOptionClicked() : Unit?

}