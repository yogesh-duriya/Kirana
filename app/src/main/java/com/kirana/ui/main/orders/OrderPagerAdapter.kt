package com.kirana.ui.main.orders

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.kirana.ui.main.orders.pastOrders.view.PastOrderFragment

class OrderPagerAdapter (fragmetnManager: FragmentManager) : FragmentStatePagerAdapter(fragmetnManager) {

    private var tabCount = 0

    override fun getItem(position: Int): Fragment? {
        return when (position){
            0 -> PastOrderFragment.newInstance()
            1 -> PastOrderFragment.newInstance()
            else -> null
        }
    }

    override fun getCount(): Int {
        return tabCount
    }

    internal fun setCount(count: Int){
        this.tabCount = count
    }

}