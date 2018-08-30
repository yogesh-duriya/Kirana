package com.kirana.ui.base.presenter

import com.kirana.ui.base.interactor.MVPInteractor
import com.kirana.ui.base.view.MVPView

interface MVPPresenter<V : MVPView, I : MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?
}