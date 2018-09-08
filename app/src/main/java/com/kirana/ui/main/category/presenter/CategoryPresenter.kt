package com.kirana.ui.main.category.presenter

import com.kirana.ui.base.presenter.BasePresenter
import com.kirana.ui.main.category.interactor.CategoryMVPInteractor
import com.kirana.ui.main.category.view.CategoryMVPView
import com.kirana.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CategoryPresenter<V : CategoryMVPView, I : CategoryMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable ) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), CategoryMVPPresenter<V, I> {
    override fun onViewPrepared() {
        getView()?.showProgress()
        interactor?.let {
            it.getCategoryList()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe{
                        categoryResponse ->
                        getView()?.let {
                            it.hideProgress()
                            it.displayCategories(categoryResponse.data)
                        }
                    }
        }
    }

}