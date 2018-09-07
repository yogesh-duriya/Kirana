package com.kirana.ui.login.presenter

import android.util.Log
import com.kirana.data.network.LoginResponse
import com.kirana.ui.base.presenter.BasePresenter
import com.kirana.ui.login.interactor.LoginMVPInteractor
import com.kirana.ui.login.view.LoginMVPView
import com.kirana.util.AppConstants
import com.kirana.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers


class LoginPresenter<V : LoginMVPView,
        I : LoginMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), LoginMVPPresenter<V, I> {

    override fun onServerLoginClicked(method: String, email: String, password: String, MAC_ID: String) {
        when {
            email.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_EMAIL_ERROR)
            password.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_PASSWORD_ERROR)
            else -> {
                getView()?.showProgress()
                interactor?.let {
                    /*compositeDisposable.add(it.doServerLoginApiCall(method, email, password, MAC_ID)
                            .compose(schedulerProvider.ioToMainObservableScheduler())
                            .subscribe({ loginResponse ->
                                updateUserInSharedPref(loginResponse = loginResponse,
                                        loggedInMode = AppConstants.LoggedInMode.LOGGED_IN_MODE_SERVER)
                                Log.d("login response :" , loginResponse.Status)
                                getView()?.openMainActivity()
                            }, { err -> println(err) }))*/

                    compositeDisposable.add(it.doServerLoginApiCall(method, email, password, MAC_ID)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe(
                                    { loginResponse ->
                                        getView()?.hideProgress()
                                        if (loginResponse.Status.equals("1")) {
                                            updateUserInSharedPref(loginResponse = loginResponse,
                                                    loggedInMode = AppConstants.LoggedInMode.LOGGED_IN_MODE_SERVER)
                                            getView()?.openMainActivity()
                                        }else{
                                            getView()?.hideProgress()
                                            getView()?.showToast(loginResponse.Message)
                                        }
                                        Log.d("login response :" , loginResponse.Status)

                                    }, { err -> println(err) }))
                }

            }
        }
    }

    private fun updateUserInSharedPref(loginResponse: LoginResponse,
                                       loggedInMode: AppConstants.LoggedInMode) =
            interactor?.updateUserInSharedPref(loginResponse, loggedInMode)


}