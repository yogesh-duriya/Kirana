package com.kirana.ui.main.category.view

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kirana.R
import com.kirana.ui.base.view.BaseFragment
import com.kirana.ui.main.view.MainActivity
import javax.inject.Inject
import com.kirana.data.network.Category
import com.kirana.ui.main.category.interactor.CategoryMVPInteractor
import com.kirana.ui.main.category.presenter.CategoryMVPPresenter
import kotlinx.android.synthetic.main.fragment_category.*


class CategoryFragment : BaseFragment(), CategoryMVPView {

    companion object {
        //@JvmStatic
        fun newInstance(): CategoryFragment {
            return CategoryFragment()
        }
    }

    @Inject
    internal lateinit var layoutManager: GridLayoutManager

    @Inject
    internal lateinit var presenter: CategoryMVPPresenter<CategoryMVPView, CategoryMVPInteractor>

    lateinit var ctx : MainActivity

    @Inject
    internal lateinit var categoryAdapter: CategoryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
        = inflater.inflate(R.layout.fragment_category, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        ctx = (this.activity as MainActivity?)!!

        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() {

        //More shops
        layoutManager.orientation = GridLayoutManager.VERTICAL
        layoutManager.spanCount = 2
        category_recycler_view.layoutManager = layoutManager
        category_recycler_view.itemAnimator = DefaultItemAnimator()
        category_recycler_view.adapter = categoryAdapter

        presenter.onViewPrepared()
    }

    override fun displayCategories(shops: List<Category>?) = shops?.let {
        categoryAdapter.addCategoryToList(it)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

}
