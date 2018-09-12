package com.kirana.ui.shop

import android.support.v7.widget.LinearLayoutManager
import com.kirana.ui.shop.interactor.ShopInteractor
import com.kirana.ui.shop.interactor.ShopMVPInteractor
import com.kirana.ui.shop.presenter.ShopMVPPresenter
import com.kirana.ui.shop.presenter.ShopPresenter
import com.kirana.ui.shop.view.ProductAdapter
import com.kirana.ui.shop.view.ShopActivity
import com.kirana.ui.shop.view.ShopMVPView
import dagger.Module
import dagger.Provides

@Module
class ShopActivityModule {

    @Provides
    internal fun provideProductListInteractor(interactor: ShopInteractor): ShopMVPInteractor = interactor

    @Provides
    internal fun provideProductListPresenter(presenter: ShopPresenter<ShopMVPView, ShopMVPInteractor>)
            : ShopMVPPresenter<ShopMVPView, ShopMVPInteractor> = presenter

    @Provides
    internal fun provideProductAdapter(): ProductAdapter = ProductAdapter(ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(fragment: ShopActivity): LinearLayoutManager = LinearLayoutManager(fragment)


}