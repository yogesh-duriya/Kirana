package com.kirana.ui.main.home

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.kirana.R
import android.support.v4.view.ViewPager

class SliderPagerAdapter(private val context: Context) : PagerAdapter() {

    private var layoutInflater : LayoutInflater? = null
    val images =  arrayOf<Int>(R.drawable.shop_banner, R.drawable.shop_banner, R.drawable.shop_banner)

    
    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.slider_image, null)
        val imageView = view.findViewById(R.id.imageView) as ImageView
        imageView.setImageResource(images[position])


        val vp = container as ViewPager
        vp.addView(view, 0)
        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)

    }

}
