package com.kirana.ui.main.orders.pastOrders.view

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kirana.R
import com.kirana.data.network.Orders
import com.kirana.ui.base.view.BaseFragment
import com.kirana.ui.main.orders.pastOrders.interactor.PastOrderMVPInteractor
import com.kirana.ui.main.orders.pastOrders.presenter.PastOrderMVPPresenter
import kotlinx.android.synthetic.main.fragment_past_order.*
import javax.inject.Inject

class PastOrderFragment : BaseFragment(), PastOrderMVPView{

    companion object {

        fun newInstance(): PastOrderFragment {
            return PastOrderFragment()
        }
    }

    @Inject
    internal lateinit var layoutManager: LinearLayoutManager

    @Inject
    internal lateinit var presenter: PastOrderMVPPresenter<PastOrderMVPView, PastOrderMVPInteractor>

    @Inject
    internal lateinit var adapter: OrderAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_past_order, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        //ctx = (this.activity as MainActivity?)!!
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() {

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recylerView.layoutManager = layoutManager
        recylerView.itemAnimator = DefaultItemAnimator()
        recylerView.adapter = adapter

        presenter.onViewPrepared()

    }

    override fun displayOrders(list: List<Orders>?) = list.let {
        if (it != null) {
            adapter.addOrderToList(it)
        }
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

}
