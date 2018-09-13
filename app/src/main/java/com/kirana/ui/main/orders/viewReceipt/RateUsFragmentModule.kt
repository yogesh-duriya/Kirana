package com.kirana.ui.main.orders.viewReceipt

import com.kirana.ui.main.orders.viewReceipt.interactor.RateUsInteractor
import com.kirana.ui.main.orders.viewReceipt.interactor.RateUsMVPInterator
import com.kirana.ui.main.orders.viewReceipt.presenter.RateUsMVPPresenter
import com.kirana.ui.main.orders.viewReceipt.presenter.RateUsPresenter
import com.kirana.ui.main.orders.viewReceipt.view.ViewRecieptDialogMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by jyotidubey on 15/01/18.
 */
@Module
class RateUsFragmentModule {

    @Provides
    internal fun provideRateUsInteractor(interactor: RateUsInteractor): RateUsMVPInterator = interactor

    @Provides
    internal fun provideRateUsPresenter(presenter: RateUsPresenter<ViewRecieptDialogMVPView, RateUsMVPInterator>)
            : RateUsMVPPresenter<ViewRecieptDialogMVPView, RateUsMVPInterator> = presenter
}