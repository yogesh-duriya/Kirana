package com.kirana.ui.otp.presenter

import android.util.Log
import com.kirana.R.string.surname
import com.kirana.data.network.LoginResponse
import com.kirana.data.network.OtpResponse
import com.kirana.ui.base.presenter.BasePresenter
import com.kirana.ui.otp.interactor.OtpMVPInteractor
import com.kirana.ui.otp.view.OtpMVPView
import com.kirana.util.AppConstants
import com.kirana.util.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class OtpPresenter<V : OtpMVPView,
        I : OtpMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable ) : BasePresenter<V, I>(interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), OtpMVPPresenter<V, I>{

    override fun onSubmitClicked(method: String, otp: String) {
        when {
            otp.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_MOBILE_ERROR)
            else -> {
                getView()?.showProgress()
                interactor?.let {
                    compositeDisposable.add(it.doSubmitOtpApiCall(method, otp)
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

    override fun onResendClicked(method: String ) {
        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(it.getOtpApiCall(method)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                            { otpResponse ->
                                getView()?.hideProgress()
                                /*if (otpResponse.Status.equals("1")) {
                                    getView()?.openMainActivity()
                                } else {
                                    getView()?.showToast(otpResponse.Message)
                                }*/
                                getView()?.showToast(otpResponse.Message)
                                Log.d("login response :", otpResponse.Status)

                            }, { err ->
                        getView()?.hideProgress()
                        println(err)
                    }))
        }
    }

    fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode) =
            interactor?.updateUserInSharedPref(loginResponse, loggedInMode)


}