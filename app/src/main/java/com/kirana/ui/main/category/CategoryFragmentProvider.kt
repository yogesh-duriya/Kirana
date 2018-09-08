package com.kirana.ui.main.category

import com.kirana.ui.main.category.view.CategoryFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class CategoryFragmentProvider {

    @ContributesAndroidInjector(modules = [CategoryFragmentModule::class])
    internal abstract fun provideCategoryFragmentFactory(): CategoryFragment
}