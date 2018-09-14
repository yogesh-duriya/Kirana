package com.kirana.ui.ProductDetail.presenter

import android.util.Log
import com.kirana.ui.ProductDetail.interactor.ProductDetailMVPInteractor
import com.kirana.ui.ProductDetail.view.ProductDetailMVPView
import com.kirana.ui.base.presenter.BasePresenter
import com.kirana.util.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ProductDetailPresenter<V : ProductDetailMVPView,
        I : ProductDetailMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), ProductDetailMVPPresenter<V, I> {


    override fun onAddToCartClicked(method: String, productId: String) {

        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(it.addToCart(method, "user_id", productId)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                            { loginResponse ->
                                getView()?.hideProgress()
                                if (loginResponse.Status.equals("1")) {
                                    getView()?.showToast("product added to cart")
                                } else {
                                    getView()?.hideProgress()
                                    getView()?.showToast(loginResponse.Message)
                                }
                                Log.d("login response :", loginResponse.Status)

                            }, { err -> println(err) }))
        }


    }
}