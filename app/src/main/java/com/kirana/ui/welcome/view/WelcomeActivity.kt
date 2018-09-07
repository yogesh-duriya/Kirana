package com.kirana.ui.welcome.view

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import com.kirana.R
import com.kirana.ui.login.view.LoginActivity
import com.kirana.ui.main.view.MainActivity
import com.kirana.ui.splash.view.SplashMVPView
import com.kirana.ui.welcome.interactor.WelcomeMVPInteractor
import com.kirana.ui.welcome.presenter.WelcomeMVPPresenter
import kotlinx.android.synthetic.main.activity_welcome.*
import javax.inject.Inject

class WelcomeActivity : AppCompatActivity(), SplashMVPView {

    @Inject
    lateinit var presenter: WelcomeMVPPresenter<SplashMVPView, WelcomeMVPInteractor>

    lateinit var layouts : IntArray

    lateinit var dots : Array<TextView?>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

        setContentView(R.layout.activity_welcome)

        presenter.onAttach(this)

        setViewPager()
    }

    private fun setViewPager() {
        layouts = intArrayOf(R.layout.welcome_slide1,
                                    R.layout.welcome_slide2,
                                    R.layout.welcome_slide3,
                                    R.layout.welcome_slide4)

        // adding bottom dots
        addBottomDots(0)

        // making notification bar transparent
        changeStatusBarColor()

        val myViewPagerAdapter = MyViewPagerAdapter()
        view_pager.setAdapter(myViewPagerAdapter)
        view_pager.addOnPageChangeListener(viewPagerPageChangeListener)

        btn_skip.setOnClickListener { openLoginActivity() }

        btn_next.setOnClickListener {
            // checking for last page
            // if last page home screen will be launched
            val current = getItem(+1)
            if (current < layouts.size) {
                // move to next screen
                view_pager.setCurrentItem(current)
            } else {
                openLoginActivity()
            }
        }
    }

    private fun getItem(i: Int): Int {
        return view_pager.getCurrentItem() + i
    }

    private fun addBottomDots(currentPage: Int) {
        dots = arrayOfNulls<TextView>(layouts.size)

        val colorsActive = resources.getIntArray(R.array.array_dot_active)
        val colorsInactive = resources.getIntArray(R.array.array_dot_inactive)

        layout_dots.removeAllViews()
        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i]!!.setText(Html.fromHtml("&#8226;"))
            dots[i]!!.setTextSize(35f)
            dots[i]!!.setTextColor(colorsInactive[currentPage])
            layout_dots.addView(dots[i])
        }

        if (dots.size > 0)
            dots[currentPage]!!.setTextColor(colorsActive[currentPage])
    }

    /**
     * Making notification bar transparent
     */
    private fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }


    internal var viewPagerPageChangeListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {

        override fun onPageSelected(position: Int) {
            addBottomDots(position)

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.size - 1) {
                // last page. make button text to GOT IT
                btn_next.setText(getString(R.string.start))
                btn_skip.setVisibility(View.GONE)
            } else {
                // still pages are left
                btn_next.setText(getString(R.string.next))
                btn_skip.setVisibility(View.VISIBLE)
            }
        }

        override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {

        }

        override fun onPageScrollStateChanged(arg0: Int) {

        }
    }

    override fun showSuccessToast() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorToast() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun openLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showToast(message: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openWelcomeActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    /**
     * View pager adapter
     */
    inner class MyViewPagerAdapter : PagerAdapter() {
        private var layoutInflater: LayoutInflater? = null

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            val view = layoutInflater!!.inflate(layouts[position], container, false)
            container.addView(view)

            return view
        }

        override fun getCount(): Int {
            return layouts.size
        }

        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view === obj
        }


        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            val view = `object` as View
            container.removeView(view)
        }
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}
