package com.kirana.ui.welcome.presenter

import com.kirana.ui.base.interactor.MVPInteractor
import com.kirana.ui.base.presenter.BasePresenter
import com.kirana.ui.splash.interactor.SplashMVPInteractor
import com.kirana.ui.splash.presenter.SplashMVPPresenter
import com.kirana.ui.splash.view.SplashMVPView
import com.kirana.ui.welcome.interactor.WelcomeMVPInteractor
import com.kirana.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class WelcomePresenter<V : SplashMVPView, I : WelcomeMVPInteractor> @Inject internal constructor(interactor : I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), WelcomeMVPPresenter<V, I> {

    override fun decideActivityToOpen()  {
        if (isUserLoggedIn())
            getView()?.openMainActivity()
        else
            getView()?.openLoginActivity()
    }

    private fun isUserLoggedIn(): Boolean {
        interactor?.let { return it.isUserLoggedIn() }
        return false
    }
}