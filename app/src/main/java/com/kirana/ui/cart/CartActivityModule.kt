package com.kirana.ui.cart

import android.support.v7.widget.LinearLayoutManager
import com.kirana.ui.cart.interactor.CartInteractor
import com.kirana.ui.cart.interactor.CartMVPInteractor
import com.kirana.ui.cart.presenter.CartMVPPresenter
import com.kirana.ui.cart.presenter.CartPresenter
import com.kirana.ui.cart.view.CartActivity
import com.kirana.ui.cart.view.CartAdapter
import com.kirana.ui.cart.view.CartMVPView
import dagger.Module
import dagger.Provides

@Module
class CartActivityModule {

    @Provides
    internal fun provideCartInteractor(interactor: CartInteractor): CartMVPInteractor = interactor

    @Provides
    internal fun provideCartPresenter(presenter: CartPresenter<CartMVPView, CartMVPInteractor>)
            : CartMVPPresenter<CartMVPView, CartMVPInteractor> = presenter

    @Provides
    internal fun provideCartAdapter(): CartAdapter = CartAdapter(ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(ctx : CartActivity): LinearLayoutManager = LinearLayoutManager(ctx)


}