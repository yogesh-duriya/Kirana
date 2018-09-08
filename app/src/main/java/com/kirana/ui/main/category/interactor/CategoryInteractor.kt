package com.kirana.ui.main.category.interactor

import com.kirana.R
import com.kirana.data.network.*
import com.kirana.data.preferences.PreferenceHelper
import com.kirana.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

class CategoryInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper : ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), CategoryMVPInteractor{

    override fun getCategoryList(): Observable<CategoryResponse> = categories()

    private fun categories() : Observable<CategoryResponse> {
        return Observable.just(CategoryResponse("1", "Successfull", data = CategoryList()))
    }

    private fun CategoryList(): MutableList<Category> {
        var categoryList : MutableList<Category> =
                mutableListOf(Category("Tea", "1", R.drawable.ic_tea),
                        Category("Sweets", "2", R.drawable.ic_sweet),
                        Category("Dairy", "3", R.drawable.ic_dairy),
                        Category("Utility", "4", R.drawable.ic_utility),
                        Category("Cctv", "5", R.drawable.ic_cctv))
        return categoryList
    }

}