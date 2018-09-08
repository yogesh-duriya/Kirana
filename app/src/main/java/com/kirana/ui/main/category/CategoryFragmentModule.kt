package com.kirana.ui.main.category

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.kirana.ui.main.category.interactor.CategoryInteractor
import com.kirana.ui.main.category.interactor.CategoryMVPInteractor
import com.kirana.ui.main.category.presenter.CategoryMVPPresenter
import com.kirana.ui.main.category.presenter.CategoryPresenter
import com.kirana.ui.main.category.view.CategoryAdapter
import com.kirana.ui.main.category.view.CategoryFragment
import com.kirana.ui.main.category.view.CategoryMVPView
import com.kirana.ui.main.home.view.HomeFragment
import dagger.Module
import dagger.Provides

@Module
class CategoryFragmentModule {

    @Provides
    internal fun provideCategoryInteractor(interactor: CategoryInteractor): CategoryMVPInteractor = interactor

    @Provides
    internal fun provideCategoryPresenter(presenter: CategoryPresenter<CategoryMVPView, CategoryMVPInteractor>)
            : CategoryMVPPresenter<CategoryMVPView, CategoryMVPInteractor> = presenter

    @Provides
    internal fun provideCategoryAdapter(): CategoryAdapter = CategoryAdapter(ArrayList())

    @Provides
    internal fun provideGridLayoutManager(fragment: CategoryFragment): GridLayoutManager = GridLayoutManager(fragment.activity, 2)


}