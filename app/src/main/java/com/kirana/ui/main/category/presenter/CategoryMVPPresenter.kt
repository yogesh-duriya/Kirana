package com.kirana.ui.main.category.presenter

import com.kirana.ui.base.presenter.MVPPresenter
import com.kirana.ui.main.category.interactor.CategoryMVPInteractor
import com.kirana.ui.main.category.view.CategoryMVPView

interface CategoryMVPPresenter<V : CategoryMVPView, I : CategoryMVPInteractor> : MVPPresenter<V, I> {

    fun onViewPrepared()

}