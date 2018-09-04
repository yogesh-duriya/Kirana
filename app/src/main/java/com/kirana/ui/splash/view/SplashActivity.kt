package com.kirana.ui.splash.view

import android.content.Intent
import android.os.Bundle
import android.view.Window
import com.kirana.R
import com.kirana.ui.base.view.BaseActivity
import com.kirana.ui.login.view.LoginActivity
import com.kirana.ui.main.view.MainActivity
import com.kirana.ui.splash.interactor.SplashMVPInteractor
import com.kirana.ui.splash.presenter.SplashMVPPresenter
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashMVPView {

    @Inject
    lateinit var presenter: SplashMVPPresenter<SplashMVPView, SplashMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash)
        presenter.onAttach(this)
    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }

    override fun showSuccessToast() {

    }

    override fun showErrorToast() {

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

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}
