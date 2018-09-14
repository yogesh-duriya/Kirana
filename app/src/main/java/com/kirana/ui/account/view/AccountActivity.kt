package com.kirana.ui.account.view

import android.os.Bundle
import com.kirana.R
import com.kirana.ui.account.interactor.AccountMVPInteractor
import com.kirana.ui.account.presenter.AccountMVPPresenter
import com.kirana.ui.base.view.BaseActivity
import kotlinx.android.synthetic.main.activity_account.*
import javax.inject.Inject
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.kirana.ui.login.view.LoginActivity
import kotlinx.android.synthetic.main.activity_your_favourites.*


class AccountActivity : BaseActivity(), AccountMVPView {

    @Inject
    internal lateinit var presenter: AccountMVPPresenter<AccountMVPView, AccountMVPInteractor>

    lateinit var menu: Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        setToolbar("Account")
        presenter.onAttach(this)
        setOnClickListeners()

        presenter.getUserFromPref()

    }

    private fun setOnClickListeners() {
        tv_signout.setOnClickListener {
            presenter.UserLogOut()
            val i = Intent(this, LoginActivity::class.java)
            // set the new task and clear flags
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(i)
        }
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun openEditAccountActivity() {

    }

    override fun setUserInfo(userInfo: HashMap<Int, String>) {
        println("user prefs are : " + userInfo.get(R.string.KEY_FIRST_NAME))
        tie_first_name.setText(userInfo.get(R.string.KEY_FIRST_NAME))
        tie_surname.setText(userInfo.get(R.string.KEY_LAST_NAME))
        tie_email.setText(userInfo.get(R.string.KEY_EMAIL))
        tie_mobile.setText(userInfo.get(R.string.KEY_MOBILE))
    }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            getMenuInflater().inflate(R.menu.main_menu, menu);
            this.menu = menu!!;
            return true
        }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.getItemId()

        //noinspection SimplifiableIfStatement
        return if (id == R.id.action_edit) {
            val editMenuItem = menu.findItem(R.id.action_edit)
            showToast("Edit Profile")
            true
        } else super.onOptionsItemSelected(item)
    }

}
