package com.kirana.ui.main.orders.viewReceipt

import com.kirana.ui.main.orders.viewReceipt.interactor.ViewReceiptInteractor
import com.kirana.ui.main.orders.viewReceipt.interactor.ViewReceiptMVPInterator
import com.kirana.ui.main.orders.viewReceipt.presenter.ViewReceiptMVPPresenter
import com.kirana.ui.main.orders.viewReceipt.presenter.ViewReceiptPresenter
import com.kirana.ui.main.orders.viewReceipt.view.ViewRecieptDialogMVPView
import dagger.Module
import dagger.Provides


@Module
class ViewReceiptFragmentModule {

    @Provides
    internal fun provideRateUsInteractor(interactor: ViewReceiptInteractor): ViewReceiptMVPInterator = interactor

    @Provides
    internal fun provideRateUsPresenter(presenter: ViewReceiptPresenter<ViewRecieptDialogMVPView, ViewReceiptMVPInterator>)
            : ViewReceiptMVPPresenter<ViewRecieptDialogMVPView, ViewReceiptMVPInterator> = presenter
}