package com.kirana.ui.login.presenter

import com.kirana.data.network.LoginResponse
import com.kirana.ui.base.presenter.BasePresenter
import com.kirana.ui.login.interactor.LoginMVPInteractor
import com.kirana.ui.login.view.LoginMVPView
import com.kirana.util.AppConstants
import com.kirana.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LoginPresenter<V : LoginMVPView, I : LoginMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), LoginMVPPresenter<V, I> {
    override fun onServerLoginClicked(email: String, password: String) {
        when {
            email.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_EMAIL_ERROR)
            password.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_PASSWORD_ERROR)
            else -> {
                getView()?.showProgress()
                interactor?.let {
                    compositeDisposable.add(it.doServerLoginApiCall(email, password)
                            .compose(schedulerProvider.ioToMainObservableScheduler())
                            .subscribe({ loginResponse ->
                                updateUserInSharedPref(loginResponse = loginResponse,
                                        loggedInMode = AppConstants.LoggedInMode.LOGGED_IN_MODE_SERVER)
                                getView()?.openMainActivity()
                            }, { err -> println(err) }))
                }

            }
        }
    }

    private fun updateUserInSharedPref(loginResponse: LoginResponse,
                                       loggedInMode: AppConstants.LoggedInMode) =
            interactor?.updateUserInSharedPref(loginResponse, loggedInMode)


}