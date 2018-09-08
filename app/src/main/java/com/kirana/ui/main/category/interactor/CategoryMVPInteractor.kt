package com.kirana.ui.main.category.interactor

import com.kirana.data.network.CategoryResponse
import com.kirana.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface CategoryMVPInteractor : MVPInteractor{

    fun getCategoryList() : Observable<CategoryResponse>

}