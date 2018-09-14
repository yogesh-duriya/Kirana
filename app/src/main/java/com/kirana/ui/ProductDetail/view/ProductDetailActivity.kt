package com.kirana.ui.ProductDetail.view

import android.os.Bundle
import com.kirana.R
import com.kirana.ui.ProductDetail.interactor.ProductDetailMVPInteractor
import com.kirana.ui.ProductDetail.presenter.ProductDetailMVPPresenter
import com.kirana.ui.base.view.BaseActivity
import kotlinx.android.synthetic.main.activity_product_detail.*
import javax.inject.Inject

class ProductDetailActivity : BaseActivity() , ProductDetailMVPView{

    @Inject
    internal lateinit var presenter: ProductDetailMVPPresenter<ProductDetailMVPView, ProductDetailMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        setListeners()
    }

    private fun setListeners() {
        tv_add_to_cart.setOnClickListener {
            presenter.onAddToCartClicked("AddToCart", "5")
        }

        tv_buy_now.setOnClickListener {

        }
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun openBuyNowActivity() {

    }

}
