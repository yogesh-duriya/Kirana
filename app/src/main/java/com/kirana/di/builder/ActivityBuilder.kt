package com.kirana.di.builder

import com.kirana.ui.login.LoginActivityModule
import com.kirana.ui.login.view.LoginActivity
import com.kirana.ui.splash.SplashActivityModule
import com.kirana.ui.splash.view.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(SplashActivityModule::class)])
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [(LoginActivityModule::class)])
    abstract fun bindLoginActivity(): LoginActivity


}