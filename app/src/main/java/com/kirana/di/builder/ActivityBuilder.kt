package com.kirana.di.builder

import com.kirana.ui.Register.RegisterActivityModule
import com.kirana.ui.Register.view.RegisterActivity
import com.kirana.ui.login.LoginActivityModule
import com.kirana.ui.login.view.LoginActivity
import com.kirana.ui.main.category.CategoryFragmentProvider
import com.kirana.ui.main.home.HomeFragmentProvider
import com.kirana.ui.main.view.MainActivity
import com.kirana.ui.splash.SplashActivityModule
import com.kirana.ui.splash.view.SplashActivity
import com.kirana.ui.welcome.WelcomeActivityModule
import com.kirana.ui.welcome.view.WelcomeActivity
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

    @ContributesAndroidInjector(modules = [(HomeFragmentProvider::class), (CategoryFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity


}