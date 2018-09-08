package com.kirana.ui.main.view

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import com.kirana.R
import com.kirana.ui.base.view.BaseActivity
import com.kirana.ui.main.MainPagerAdapter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    internal lateinit var mainPagerAdapter: MainPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPagerAdapter = MainPagerAdapter(supportFragmentManager)
        setUpMainPagerAdapter()

    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    private fun setUpMainPagerAdapter(){
        mainPagerAdapter.count = 4
        mainViewPager.adapter = mainPagerAdapter
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_home))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_search))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_list))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_profile))
        mainViewPager.offscreenPageLimit = tabLayout.tabCount
        mainViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab) {
                mainViewPager.currentItem = tab.position

            }
        })
    }

    override fun onResume() {
        //supportFragmentInjector()
        super.onResume()
    }


}
