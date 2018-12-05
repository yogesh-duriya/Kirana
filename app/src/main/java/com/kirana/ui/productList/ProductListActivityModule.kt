package com.kirana.ui.productList

import android.support.v7.widget.LinearLayoutManager
import com.kirana.ui.main.home.view.AllShopAdapter
import com.kirana.ui.productList.interactor.ProductListInteractor
import com.kirana.ui.productList.interactor.ProductListMVPInteractor
import com.kirana.ui.productList.presenter.ProductListMVPPresenter
import com.kirana.ui.productList.presenter.ProductListPresenter
import com.kirana.ui.productList.view.ProductListActivity
import com.kirana.ui.productList.view.ProductListMVPView
import dagger.Module
import dagger.Provides

@Module
class ProductListActivityModule {

    @Provides
    internal fun provideProductListInteractor(interactor: ProductListInteractor): ProductListMVPInteractor = interactor

    @Provides
    internal fun provideProductListPresenter(presenter: ProductListPresenter<ProductListMVPView, ProductListMVPInteractor>)
            : ProductListMVPPresenter<ProductListMVPView, ProductListMVPInteractor> = presenter

    @Provides
    internal fun provideProductListAdapter(): AllShopAdapter = AllShopAdapter(ArrayList())

    @Provides
    internal fun provideGridLayoutManager(context: ProductListActivity): LinearLayoutManager = LinearLayoutManager(context)



}