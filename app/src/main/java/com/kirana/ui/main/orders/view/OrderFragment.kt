package com.kirana.ui.main.orders.view

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kirana.R
import com.kirana.ui.main.orders.OrderPagerAdapter
import kotlinx.android.synthetic.main.fragment_order.*


class OrderFragment : Fragment() {

    companion object {

        fun newInstance(): OrderFragment {
            return OrderFragment()
        }
    }


    internal lateinit var orderPagerAdapter: OrderPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_order, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        orderPagerAdapter = OrderPagerAdapter(childFragmentManager)
        setUpOrderPagerAdapter()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setUpOrderPagerAdapter(){
        orderPagerAdapter.count = 2
        orderViewPager.adapter = orderPagerAdapter
        orderTabLayout.addTab(orderTabLayout.newTab().setText("PAST ORDERS"))
        orderTabLayout.addTab(orderTabLayout.newTab().setText("UPCOMING"))
        orderViewPager.offscreenPageLimit = orderTabLayout.tabCount
        orderViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(orderTabLayout))
        orderTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                orderViewPager.currentItem = tab.position
            }
        })
    }

}
