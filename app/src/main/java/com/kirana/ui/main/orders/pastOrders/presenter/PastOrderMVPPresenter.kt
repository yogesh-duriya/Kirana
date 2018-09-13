package com.kirana.ui.main.orders.pastOrders.presenter

import com.kirana.ui.base.presenter.MVPPresenter
import com.kirana.ui.main.orders.pastOrders.interactor.PastOrderMVPInteractor
import com.kirana.ui.main.orders.pastOrders.view.PastOrderMVPView


interface PastOrderMVPPresenter<V : PastOrderMVPView, I : PastOrderMVPInteractor> : MVPPresenter<V, I> {

    fun onViewPrepared()

}
