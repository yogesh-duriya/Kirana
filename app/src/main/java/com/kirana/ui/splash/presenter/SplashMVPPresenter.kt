package com.kirana.ui.splash.presenter

import com.kirana.ui.base.presenter.MVPPresenter
import com.kirana.ui.splash.interactor.SplashMVPInteractor
import com.kirana.ui.splash.view.SplashMVPView

interface SplashMVPPresenter<V : SplashMVPView, I : SplashMVPInteractor> : MVPPresenter<V, I>