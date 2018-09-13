package com.kirana.ui.main.orders.pastOrders

import android.support.v7.widget.LinearLayoutManager
import com.kirana.ui.main.orders.pastOrders.interactor.PastOrderInteractor
import com.kirana.ui.main.orders.pastOrders.interactor.PastOrderMVPInteractor
import com.kirana.ui.main.orders.pastOrders.presenter.PastOrderMVPPresenter
import com.kirana.ui.main.orders.pastOrders.presenter.PastOrderPresenter
import com.kirana.ui.main.orders.pastOrders.view.OrderAdapter
import com.kirana.ui.main.orders.pastOrders.view.PastOrderFragment
import com.kirana.ui.main.orders.pastOrders.view.PastOrderMVPView
import dagger.Module
import dagger.Provides

@Module
class PastOrderFragmentModule {
    @Provides
    internal fun providePastOrderInteractor(interactor: PastOrderInteractor): PastOrderMVPInteractor= interactor

    @Provides
    internal fun providePastOrderPresenter(presenter: PastOrderPresenter<PastOrderMVPView, PastOrderMVPInteractor>)
            : PastOrderMVPPresenter<PastOrderMVPView, PastOrderMVPInteractor> = presenter

    @Provides
    internal fun providePastOrderAdapter(): OrderAdapter = OrderAdapter(ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(fragment: PastOrderFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)


}