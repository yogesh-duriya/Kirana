package com.kirana.ui.main.home.presenter

import com.kirana.ui.base.presenter.MVPPresenter
import com.kirana.ui.main.home.interactor.HomeMVPInteractor
import com.kirana.ui.main.home.view.HomeMVPView

interface HomeMVPPresenter<V: HomeMVPView, I : HomeMVPInteractor> : MVPPresenter<V, I> {

    fun onViewPrepared()

}