package com.kirana.ui.welcome.interactor

import com.kirana.data.network.ApiHelper
import com.kirana.data.preferences.PreferenceHelper
import com.kirana.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class WelcomeInteractor@Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), WelcomeMVPInteractor {

}