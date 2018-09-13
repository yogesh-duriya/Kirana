package com.kirana.ui.main.orders.pastOrders


import com.kirana.ui.main.orders.pastOrders.view.PastOrderFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class PastOrderFragmentProvider {

    @ContributesAndroidInjector(modules = [PastOrderFragmentModule::class])
    internal abstract fun providePastOrderFragmentFactory(): PastOrderFragment

}