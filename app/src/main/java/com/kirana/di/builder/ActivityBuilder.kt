package com.kirana.di.builder

import com.kirana.ui.ProductDetail.ProductDetailActivityModule
import com.kirana.ui.ProductDetail.view.ProductDetailActivity
import com.kirana.ui.Register.RegisterActivityModule
import com.kirana.ui.Register.view.RegisterActivity
import com.kirana.ui.account.AccountActivityModule
import com.kirana.ui.account.view.AccountActivity
import com.kirana.ui.cart.CartActivityModule
import com.kirana.ui.cart.view.CartActivity
import com.kirana.ui.login.LoginActivityModule
import com.kirana.ui.login.view.LoginActivity
import com.kirana.ui.main.category.CategoryFragmentProvider
import com.kirana.ui.main.home.HomeFragmentProvider
import com.kirana.ui.main.orders.pastOrders.PastOrderFragmentProvider
import com.kirana.ui.main.orders.viewReceipt.ViewReceiptDialogFragmentProvider
import com.kirana.ui.main.view.MainActivity
import com.kirana.ui.productList.ProductListActivityModule
import com.kirana.ui.productList.view.ProductListActivity
import com.kirana.ui.shop.ShopActivityModule
import com.kirana.ui.shop.view.ShopActivity
import com.kirana.ui.splash.SplashActivityModule
import com.kirana.ui.splash.view.SplashActivity
import com.kirana.ui.welcome.WelcomeActivityModule
import com.kirana.ui.welcome.view.WelcomeActivity
import com.kirana.ui.yourFavourites.YourFavouritesActivityModule
import com.kirana.ui.yourFavourites.view.YourFavouritesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(SplashActivityModule::class)])
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [(LoginActivityModule::class)])
    abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [(RegisterActivityModule::class)])
    abstract fun bindRegisterActivity(): RegisterActivity

    @ContributesAndroidInjector(modules = [(WelcomeActivityModule::class)])
    abstract fun bindWelcomeActivity(): WelcomeActivity

    @ContributesAndroidInjector(modules = [(HomeFragmentProvider::class), (CategoryFragmentProvider::class), (PastOrderFragmentProvider::class), (ViewReceiptDialogFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(ProductListActivityModule::class)])
    abstract fun bindProductListActivity(): ProductListActivity

    @ContributesAndroidInjector(modules = [(ShopActivityModule::class)])
    abstract fun bindShopActivity(): ShopActivity

    @ContributesAndroidInjector(modules = [(YourFavouritesActivityModule::class)])
    abstract fun bindYourFavouritesActivity(): YourFavouritesActivity

    @ContributesAndroidInjector(modules = [(AccountActivityModule::class)])
    abstract fun bindAccountActivity(): AccountActivity

    @ContributesAndroidInjector(modules = [(ProductDetailActivityModule::class)])
    abstract fun bindProductDetailActivity(): ProductDetailActivity

    @ContributesAndroidInjector(modules = [(CartActivityModule::class)])
    abstract fun bindCartActivity(): CartActivity

}