package com.kirana.ui.main.profile.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kirana.R
import com.kirana.ui.account.view.AccountActivity
import com.kirana.ui.main.view.MainActivity
import com.kirana.ui.yourFavourites.view.YourFavouritesActivity
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {

    companion object {
        fun newInstance():ProfileFragment {
            return ProfileFragment()
        }
    }

    lateinit var ctx : MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_profile, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ctx = (this.activity as MainActivity?)!!

        setOnClickListeners()
    }

    private fun setOnClickListeners() {

        tv_fav.setOnClickListener {
            ctx.showToast("fav")
            startActivity(Intent(ctx, YourFavouritesActivity::class.java))
        }
        tv_payment.setOnClickListener {
            ctx.showToast("payment")
            //startActivity(Intent(ctx, RegisterActivity::class.java))
        }
        tv_help.setOnClickListener {
            ctx.showToast("help")
            //startActivity(Intent(ctx, RegisterActivity::class.java))
        }
        tv_tell_your_friend.setOnClickListener {
            ctx.showToast("tell your friend")
            //startActivity(Intent(ctx, RegisterActivity::class.java))
        }
        tv_promotions.setOnClickListener {
            ctx.showToast("promotion")
            //startActivity(Intent(ctx, RegisterActivity::class.java))
        }
        tv_settings.setOnClickListener {
            startActivity(Intent(ctx, AccountActivity::class.java))
        }
        tv_give_your_friend.setOnClickListener {
            ctx.showToast("give your friend")
            //startActivity(Intent(ctx, RegisterActivity::class.java))
        }
        tv_about.setOnClickListener {
            ctx.showToast("about")
            //(Intent(ctx, RegisterActivity::class.java))
        }

    }

}
