package com.kirana.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import com.kirana.R
import com.kirana.ui.trackOrder.view.MyCartFragment

object Util {

    private var CURRENT_TAG: String? = null
    val SHOPPING_LIST_TAG = "SHoppingListFragment"
    val HOME_FRAGMENT = "HomeFragment"

    fun switchFragmentWithAnimation(id: Int, fragment: Fragment, activity: FragmentActivity, TAG: String?, transitionStyle: AnimationType?) {

        val fragmentManager = activity.supportFragmentManager
        val fragmentTransaction = fragmentManager
                .beginTransaction()

        if (transitionStyle != null) {
            when (transitionStyle) {
                AnimationType.SLIDE_DOWN ->

                    // Exit from down
                    fragmentTransaction.setCustomAnimations(R.anim.slide_up,
                            R.anim.slide_down)

                AnimationType.SLIDE_UP ->

                    // Enter from Up
                    fragmentTransaction.setCustomAnimations(R.anim.slide_in_up,
                            R.anim.slide_out_up)

                AnimationType.SLIDE_LEFT ->

                    // Enter from left
                    fragmentTransaction.setCustomAnimations(R.anim.slide_left,
                            R.anim.slide_out_left)

                // Enter from right
                AnimationType.SLIDE_RIGHT -> fragmentTransaction.setCustomAnimations(R.anim.slide_right,
                        R.anim.slide_out_right)

                AnimationType.FADE_IN -> {
                    fragmentTransaction.setCustomAnimations(R.anim.fade_in,
                            R.anim.fade_out)
                    fragmentTransaction.setCustomAnimations(R.anim.fade_in,
                            R.anim.donot_move)
                }

                AnimationType.FADE_OUT -> fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.donot_move)

                AnimationType.SLIDE_IN_SLIDE_OUT ->

                    fragmentTransaction.setCustomAnimations(R.anim.slide_left,
                            R.anim.slide_out_left)

                else -> {
                }
            }
        }

        CURRENT_TAG = TAG

        /*getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.push_down_in, R.anim.push_up_out)
                .remove(myFragment)
                .commit();*/
        fragmentTransaction.remove(activity.getSupportFragmentManager().findFragmentById(R.id.frag_container)).commit();
        /*fragmentTransaction.replace(id, fragment)
        fragmentTransaction.addToBackStack(TAG)
        fragmentTransaction.commit()*/
    }

    fun switchContent(id: Int, TAG: String, baseActivity: FragmentActivity, transitionStyle: AnimationType?) {

        var fragmentToReplace: Fragment? = null

        val fragmentManager = baseActivity
                .supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        // If our current fragment is null, or the new fragment is different, we
        // need to change our current fragment
        if (CURRENT_TAG == null || TAG != CURRENT_TAG) {

            if (transitionStyle != null) {
                when (transitionStyle) {
                    AnimationType.SLIDE_DOWN ->
                        // Exit from down
                        transaction.setCustomAnimations(R.anim.slide_up,
                                R.anim.slide_down)
                    AnimationType.SLIDE_UP ->
                        // Enter from Up
                        transaction.setCustomAnimations(R.anim.slide_in_up,
                                R.anim.slide_out_up)
                    AnimationType.SLIDE_LEFT ->
                        // Enter from left
                        transaction.setCustomAnimations(R.anim.slide_left,
                                R.anim.slide_out_left)
                    // Enter from right
                    AnimationType.SLIDE_RIGHT -> transaction.setCustomAnimations(R.anim.slide_right,
                            R.anim.slide_out_right)
                    AnimationType.FADE_IN -> {
                        transaction.setCustomAnimations(R.anim.fade_in,
                                R.anim.fade_out)
                        transaction.setCustomAnimations(R.anim.fade_in,
                                R.anim.donot_move)
                    }
                    AnimationType.FADE_OUT -> transaction.setCustomAnimations(R.anim.fade_in, R.anim.donot_move)
                    AnimationType.SLIDE_IN_SLIDE_OUT -> transaction.setCustomAnimations(R.anim.slide_left,
                            R.anim.slide_out_left)
                    else -> {
                    }
                }
            }

            // Try to find the fragment we are switching to
            val fragment = fragmentManager.findFragmentByTag(TAG)

            // If the new fragment can't be found in the manager, create a new
            // one
            if (fragment == null) {

                if (TAG == SHOPPING_LIST_TAG) {
                    fragmentToReplace = MyCartFragment()
                }

            } else {
                if (TAG == SHOPPING_LIST_TAG) {
                    fragmentToReplace = fragment as MyCartFragment
                }
            }

            CURRENT_TAG = TAG

            // Replace our current fragment with the one we are changing to
            transaction.replace(id, fragmentToReplace, TAG)
            transaction.commit()

        } else {
            // Do nothing since we are already on the fragment being changed to
        }
    }

    enum class AnimationType {
        SLIDE_LEFT, SLIDE_RIGHT, SLIDE_UP, SLIDE_DOWN, FADE_IN, SLIDE_IN_SLIDE_OUT, FADE_OUT
    }
}