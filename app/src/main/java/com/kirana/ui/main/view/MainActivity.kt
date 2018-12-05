package com.kirana.ui.main.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.Menu
import com.kirana.R
import com.kirana.ui.base.view.BaseActivity
import com.kirana.ui.main.MainPagerAdapter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import com.kirana.util.CountDrawable
import android.graphics.drawable.LayerDrawable
import android.view.MenuItem
import com.kirana.ui.cart.view.CartActivity
import com.kirana.ui.deliveryDetails.view.DeliveryDetailsActivity
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper


class MainActivity : BaseActivity(), HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    internal lateinit var mainPagerAdapter: MainPagerAdapter
    internal lateinit var menu: Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setMainActivityToolbar("ASAP : Mansarover Plaza")
        mainPagerAdapter = MainPagerAdapter(supportFragmentManager)
        setUpMainPagerAdapter()
        setListener()

    }

    private fun setListener() {
        toolbar.setOnClickListener { /*startActivity(Intent(this, DeliveryDetailsActivity::class.java))*/ }
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
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                mainViewPager.currentItem = tab.position
                if (tab!!.position == 0)
                    setMainActivityToolbar("ASAP : Mansarover Plaza")
                else if (tab!!.position == 1)
                    setMainActivityToolbar("Search In Shops")
                else if (tab!!.position == 2)
                    setMainActivityToolbar("Orders")
                else if (tab!!.position == 3)
                    setMainActivityToolbar("User Name")
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.cart_menu, menu);
        this.menu = menu!!
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        setCount(this, "50");

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.getItemId()

        //noinspection SimplifiableIfStatement
        return if (id == R.id.ic_group) {
            //val editMenuItem = menu.findItem(R.id.action_edit)
            startActivity(Intent(this, CartActivity::class.java))
            true
        } else super.onOptionsItemSelected(item)
    }

    fun setCount(context: Context, count: String) {
        val menuItem = menu.findItem(R.id.ic_group)
        val icon = menuItem.getIcon() as LayerDrawable

        val badge: CountDrawable

        // Reuse drawable if possible
        val reuse = icon.findDrawableByLayerId(R.id.ic_group_count)
        if (reuse != null && reuse is CountDrawable) {
            badge = reuse
        } else {
            badge = CountDrawable(context)
        }

        badge.setCount(count)
        icon.mutate()
        icon.setDrawableByLayerId(R.id.ic_group_count, badge)
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }


}
