package com.kirana.ui.cart.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.kirana.R
import com.kirana.data.network.Shop
import com.kirana.ui.base.view.BaseActivity
import com.kirana.ui.cart.interactor.CartMVPInteractor
import com.kirana.ui.cart.presenter.CartMVPPresenter
import com.kirana.ui.trackOrder.view.TrackOrderActivity
import kotlinx.android.synthetic.main.activity_cart.*
import javax.inject.Inject

class CartActivity : BaseActivity(), CartMVPView {

    @Inject
    internal lateinit var adapter: CartAdapter

    @Inject
    internal lateinit var layoutManager: LinearLayoutManager

    @Inject
    internal lateinit var presenter: CartMVPPresenter<CartMVPView, CartMVPInteractor>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        presenter.onAttach(this)


        setToolbar("My Cart")

        setUp()

    }

    private fun setUp() {
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recylerView.layoutManager = layoutManager
        recylerView.itemAnimator = DefaultItemAnimator()
        recylerView.adapter = adapter

        presenter.onViewPrepared("getProducts", "1")

        btn_place_order.setOnClickListener { startActivity(Intent( this, TrackOrderActivity::class.java) )}
    }

    override fun onFragmentAttached() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentDetached(tag: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun displayCartList(list: List<Shop>?) = list?.let {
        adapter.addShopsToList(it)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

}
