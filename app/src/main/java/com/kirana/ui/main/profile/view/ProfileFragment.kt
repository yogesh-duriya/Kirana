package com.kirana.ui.main.profile.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kirana.R
import com.kirana.ui.main.view.MainActivity


class ProfileFragment : Fragment() {

    companion object {
        fun newInstance():ProfileFragment {
            return ProfileFragment()
        }
    }

    lateinit var ctx : MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_profile, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ctx = (this.activity as MainActivity?)!!

        super.onViewCreated(view, savedInstanceState)
    }

}
