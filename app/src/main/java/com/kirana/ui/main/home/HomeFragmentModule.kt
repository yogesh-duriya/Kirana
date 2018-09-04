package com.kirana.ui.main.home

import android.support.v7.widget.LinearLayoutManager
import com.kirana.ui.main.home.interactor.HomeInteractor
import com.kirana.ui.main.home.interactor.HomeMVPInteractor
import com.kirana.ui.main.home.presenter.HomeMVPPresenter
import com.kirana.ui.main.home.presenter.HomePresenter
import com.kirana.ui.main.home.view.HomeFragment
import com.kirana.ui.main.home.view.HomeMVPView
import com.kirana.ui.main.home.view.ShopAdapter
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule {

    @Provides
    internal fun provideHomeInteractor(interactor: HomeInteractor): HomeMVPInteractor = interactor

    @Provides
    internal fun provideHomePresenter(presenter: HomePresenter<HomeMVPView, HomeMVPInteractor>)
            : HomeMVPPresenter<HomeMVPView, HomeMVPInteractor> = presenter

    @Provides
    internal fun provideShopAdapter(): ShopAdapter = ShopAdapter(ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(fragment: HomeFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)

}