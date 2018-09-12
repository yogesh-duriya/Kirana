package com.kirana.ui.yourFavourites.view

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.kirana.R
import com.kirana.data.network.Shop
import com.kirana.ui.base.view.BaseActivity
import com.kirana.ui.yourFavourites.interactor.YourFavouritesMVPInteractor
import com.kirana.ui.yourFavourites.presenter.YourFavouritesMVPPresenter
import kotlinx.android.synthetic.main.activity_your_favourites.*
import javax.inject.Inject

class YourFavouritesActivity : BaseActivity(), YourFavouritesMVPView {

    @Inject
    internal lateinit var adapter: FavouriteShopAdapter

    @Inject
    internal lateinit var layoutManager: LinearLayoutManager

    @Inject
    internal lateinit var presenter: YourFavouritesMVPPresenter<YourFavouritesMVPView, YourFavouritesMVPInteractor>

    lateinit var menu: Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_favourites)

        presenter.onAttach(this)

        setToolbar("Your Favourites")

        setUp()
    }

    private fun setUp() {
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recylerView.layoutManager = layoutManager
        recylerView.itemAnimator = DefaultItemAnimator()
        recylerView.adapter = adapter

        presenter.onViewPrepared()
    }

    override fun onFragmentAttached() { }

    override fun onFragmentDetached(tag: String) { }

    override fun displayFavouriteList(list: List<Shop>?) = list?.let {
        adapter.addShopsToList(it)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
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
            if (editMenuItem.title.equals("EDIT ")) {
                editMenuItem.setTitle("CANCEL")
                tv_remove_selected.visibility = View.VISIBLE
                adapter.editable(true)
            }else {
                editMenuItem.setTitle("EDIT ")
                tv_remove_selected.visibility = View.GONE
                adapter.editable(false)
            }
            true
        } else super.onOptionsItemSelected(item)
    }
}
