package com.kirana.ui.main.home.view

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kirana.R
import com.kirana.data.network.Shop
import com.kirana.ui.base.view.BaseFragment
import com.kirana.ui.main.home.interactor.HomeMVPInteractor
import com.kirana.ui.main.home.presenter.HomeMVPPresenter
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment(), HomeMVPView {

    companion object {
        //@JvmStatic
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    @Inject
    internal lateinit var shopAdapter: ShopAdapter

    @Inject
    internal lateinit var layoutManager: LinearLayoutManager

    @Inject
    internal lateinit var presenter: HomeMVPPresenter<HomeMVPView, HomeMVPInteractor>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
        = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() {
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        shop_recycler_view.layoutManager = layoutManager
        shop_recycler_view.itemAnimator = DefaultItemAnimator()
        shop_recycler_view.adapter = shopAdapter
        presenter.onViewPrepared()
    }

    override fun displayShopList(shops: List<Shop>?) = shops?.let {
        shopAdapter.addShopsToList(it)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

}
