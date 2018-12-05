package com.kirana.ui.productList.view

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.kirana.R
import com.kirana.data.network.Shop
import com.kirana.ui.base.view.BaseActivity
import com.kirana.ui.main.home.view.AllShopAdapter
import com.kirana.ui.productList.interactor.ProductListMVPInteractor
import com.kirana.ui.productList.presenter.ProductListMVPPresenter
import kotlinx.android.synthetic.main.activity_product_list.*
import javax.inject.Inject


class ProductListActivity : BaseActivity(), ProductListMVPView {

    @Inject
    internal lateinit var adapter: AllShopAdapter

    @Inject
    internal lateinit var layoutManager: LinearLayoutManager

    @Inject
    internal lateinit var presenter: ProductListMVPPresenter<ProductListMVPView, ProductListMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        presenter.onAttach(this)

        var title = intent.getStringExtra("NAME")
        setToolbar(title)

        setUp()

    }

    private fun setUp() {
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recylerView.layoutManager = layoutManager
        recylerView.itemAnimator = DefaultItemAnimator()
        recylerView.adapter = adapter

        presenter.onViewPrepared("getProducts", "1")
    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }

    override fun displayProductList(list: List<Shop>?) = list?.let {
        adapter.addShopsToList(it)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

}
