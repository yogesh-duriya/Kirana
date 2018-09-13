package com.kirana.ui.account.presenter

import com.kirana.ui.account.interactor.AccountMVPInteractor
import com.kirana.ui.account.view.AccountMVPView
import com.kirana.ui.base.presenter.BasePresenter
import com.kirana.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class AccountPresenter<V : AccountMVPView,
        I : AccountMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), AccountMVPPresenter<V, I> {


    override fun getUserFromPref() {
        var abc = interactor?.getUserFromSharedPref()!!
        getView()?.setUserInfo(abc)
    }

    override fun UserLogOut() {
        interactor?.performUserLogout()
    }

}