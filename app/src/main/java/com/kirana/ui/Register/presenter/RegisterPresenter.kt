package com.kirana.ui.Register.presenter

import android.util.Log
import com.kirana.data.network.LoginResponse
import com.kirana.ui.Register.interactor.RegisterMVPInteractor
import com.kirana.ui.Register.view.RegisterMVPView
import com.kirana.ui.base.presenter.BasePresenter
import com.kirana.util.AppConstants
import com.kirana.util.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RegisterPresenter<V : RegisterMVPView,
        I : RegisterMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), RegisterMVPPresenter<V, I> {
    override fun onRegisterClicked(method: String, firstName: String, surname: String, email: String, mobile: String, password: String) {
        when {
            firstName.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_FIRST_NAME_ERROR)
            surname.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_SURNAME_ERROR)
            email.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_EMAIL_ERROR)
            mobile.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_MOBILE_ERROR)
            password.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_PASSWORD_ERROR)
            else -> {
                getView()?.showProgress()
                interactor?.let {
                    compositeDisposable.add(it.doRegisterApiCall(method, firstName, surname, email, mobile, password)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe(
                                    { loginResponse ->
                                        getView()?.hideProgress()
                                        if (loginResponse.Status.equals("1")) {
                                            updateUserInSharedPref(loginResponse = loginResponse,
                                                    loggedInMode = AppConstants.LoggedInMode.LOGGED_IN_MODE_SERVER)
                                            getView()?.openMainActivity()
                                        } else {
                                            getView()?.showToast(loginResponse.Message)
                                        }
                                        Log.d("login response :", loginResponse.Status)

                                    }, { err ->
                                            getView()?.hideProgress()
                                            println(err)
                            }))
                }

            }

        }
    }

    private fun updateUserInSharedPref(loginResponse: LoginResponse,
                                       loggedInMode: AppConstants.LoggedInMode) =
            interactor?.updateUserInSharedPref(loginResponse, loggedInMode)


}