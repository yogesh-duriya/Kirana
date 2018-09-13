package com.kirana.ui.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.kirana.ui.main.category.view.CategoryFragment
import com.kirana.ui.main.home.view.HomeFragment
import com.kirana.ui.main.orders.view.OrderFragment
import com.kirana.ui.main.profile.view.ProfileFragment


class MainPagerAdapter(fragmetnManager: FragmentManager) : FragmentStatePagerAdapter(fragmetnManager) {

    private var tabCount = 0

    override fun getItem(position: Int): Fragment? {
            return when (position){
                0 -> HomeFragment.newInstance()
                1 -> CategoryFragment.newInstance()
                2 -> OrderFragment.newInstance()
                3 -> ProfileFragment.newInstance()
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