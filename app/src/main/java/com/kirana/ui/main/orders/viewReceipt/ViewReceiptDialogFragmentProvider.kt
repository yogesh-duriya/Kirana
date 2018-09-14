package com.kirana.ui.main.orders.viewReceipt

import com.kirana.ui.main.orders.viewReceipt.view.ViewReceiptDialog
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ViewReceiptDialogFragmentProvider{

    @ContributesAndroidInjector(modules = [ViewReceiptFragmentModule::class])
    internal abstract fun provideRateUsFragment() : ViewReceiptDialog
}