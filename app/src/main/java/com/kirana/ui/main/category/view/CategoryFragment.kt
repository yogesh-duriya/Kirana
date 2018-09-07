package com.kirana.ui.main.category.view

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.kirana.R
import com.kirana.data.network.Shop
import com.kirana.ui.base.view.BaseFragment
import com.kirana.ui.main.MainPagerAdapter
import com.kirana.ui.main.home.SliderPagerAdapter
import com.kirana.ui.main.home.interactor.HomeMVPInteractor
import com.kirana.ui.main.home.presenter.HomeMVPPresenter
import com.kirana.ui.main.view.MainActivity
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject
import android.widget.LinearLayout
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import com.kirana.ui.main.home.view.AllShopAdapter
import com.kirana.ui.main.home.view.HomeMVPView
import com.kirana.ui.main.home.view.ShopAdapter


class CategoryFragment : BaseFragment(), HomeMVPView {

    companion object {
        //@JvmStatic
        fun newInstance(): CategoryFragment {
            return CategoryFragment()
        }
    }

    @Inject
    internal lateinit var shopAdapter: ShopAdapter

    @Inject
    internal lateinit var allShopAdapter: AllShopAdapter

    @Inject
    internal lateinit var layoutManager: LinearLayoutManager

    @Inject
    internal lateinit var layoutManger2: LinearLayoutManager

    @Inject
    internal lateinit var layoutManger3: LinearLayoutManager

    @Inject
    internal lateinit var layoutManger4: LinearLayoutManager

    @Inject
    internal lateinit var presenter: HomeMVPPresenter<HomeMVPView, HomeMVPInteractor>

    internal lateinit var sliderPagerAdapter: SliderPagerAdapter

    lateinit var ctx : MainActivity

    private var dotscount: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
        = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        ctx = (this.activity as MainActivity?)!!
        addSlider()

        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() {

        //popular near you
        layoutManger2.orientation = LinearLayoutManager.HORIZONTAL
        popular_near_recycler_view.layoutManager = layoutManger2
        popular_near_recycler_view.itemAnimator = DefaultItemAnimator()
        popular_near_recycler_view.adapter = shopAdapter

        //under 25 minute
        layoutManger3.orientation = LinearLayoutManager.HORIZONTAL
        under_25_minute_recycler_view.layoutManager = layoutManger3
        under_25_minute_recycler_view.itemAnimator = DefaultItemAnimator()
        under_25_minute_recycler_view.adapter = shopAdapter

        //new
        layoutManger4.orientation = LinearLayoutManager.HORIZONTAL
        new_recycler_view.layoutManager = layoutManger4
        new_recycler_view.itemAnimator = DefaultItemAnimator()
        new_recycler_view.adapter = shopAdapter

        //More shops
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        shop_recycler_view.layoutManager = layoutManager
        shop_recycler_view.itemAnimator = DefaultItemAnimator()
        shop_recycler_view.adapter = allShopAdapter

        presenter.onViewPrepared()
    }

    override fun displayShopList(shops: List<Shop>?) = shops?.let {
        shopAdapter.addShopsToList(it)
        allShopAdapter.addShopsToList(it)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    private fun addSlider() {
        sliderPagerAdapter = SliderPagerAdapter(ctx)
        sliderViewPager.adapter = sliderPagerAdapter
        dotscount = sliderPagerAdapter.getCount()
        val dots = arrayOfNulls<ImageView>(5)
        for (i in 0 until dotscount) {

            dots[i] = ImageView(ctx)
            dots[i]?.setImageDrawable(ContextCompat.getDrawable(ctx, R.drawable.non_active_dot))

            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

            params.setMargins(8, 0, 8, 0)

            sliderDotspanel.addView(dots[i], params)

        }
        dots[0]?.setImageDrawable(ContextCompat.getDrawable(ctx, R.drawable.active_dot));

        sliderViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {

                for (i in 0 until dotscount) {
                    dots[i]?.setImageDrawable(ContextCompat.getDrawable(ctx, R.drawable.non_active_dot))
                }

                dots[position]?.setImageDrawable(ContextCompat.getDrawable(ctx, R.drawable.active_dot))

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

}
