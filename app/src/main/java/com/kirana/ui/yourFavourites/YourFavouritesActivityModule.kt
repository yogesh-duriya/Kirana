package com.kirana.ui.yourFavourites

import android.support.v7.widget.LinearLayoutManager
import com.kirana.ui.yourFavourites.interactor.YourFavouritesInteractor
import com.kirana.ui.yourFavourites.interactor.YourFavouritesMVPInteractor
import com.kirana.ui.yourFavourites.presenter.YourFavouritesMVPPresenter
import com.kirana.ui.yourFavourites.presenter.YourFavouritesPresenter
import com.kirana.ui.yourFavourites.view.FavouriteShopAdapter
import com.kirana.ui.yourFavourites.view.YourFavouritesActivity
import com.kirana.ui.yourFavourites.view.YourFavouritesMVPView
import dagger.Module
import dagger.Provides

@Module
class YourFavouritesActivityModule {

    @Provides
    internal fun provideYourFavouriteInteractor(interactor: YourFavouritesInteractor): YourFavouritesMVPInteractor= interactor

    @Provides
    internal fun provideYourFavouritePresenter(presenter: YourFavouritesPresenter<YourFavouritesMVPView, YourFavouritesMVPInteractor>)
            : YourFavouritesMVPPresenter<YourFavouritesMVPView, YourFavouritesMVPInteractor> = presenter

    @Provides
    internal fun provideYourFavouriteAdapter(): FavouriteShopAdapter = FavouriteShopAdapter(ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(context : YourFavouritesActivity): LinearLayoutManager = LinearLayoutManager(context)



}