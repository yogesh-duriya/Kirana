package com.kirana.ui.base.view

import android.app.ProgressDialog
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.widget.Toast
import com.kirana.R
import com.kirana.util.CommonUtil
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.app_bar.*

abstract class BaseActivity : AppCompatActivity(), MVPView, BaseFragment.CallBack {

    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDI()
    }

    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel() }
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtil.showLoadingDialog(this)
    }

    override fun showToast(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG ).show()    }


    private fun performDI() = AndroidInjection.inject(this)

    fun setToolbar(title : String){
        toolbar.setNavigationIcon(R.drawable.ic_left_arrow);
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setTitle(title)
        supportActionBar?.setDisplayShowTitleEnabled(true)
    }

    fun setMainActivityToolbar(title : String){
        setSupportActionBar(toolbar)
        /*supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)*/
        supportActionBar?.setTitle(title)
        supportActionBar?.setDisplayShowTitleEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}