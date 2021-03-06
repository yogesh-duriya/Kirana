package com.kirana.ui.main.orders.viewReceipt.interactor

import com.kirana.data.network.ApiHelper
import com.kirana.data.preferences.PreferenceHelper
import com.kirana.ui.base.interactor.BaseInteractor
import javax.inject.Inject


class ViewReceiptInteractor @Inject internal constructor(apiHelper: ApiHelper, preferenceHelper: PreferenceHelper) : BaseInteractor(apiHelper = apiHelper, preferenceHelper = preferenceHelper), ViewReceiptMVPInterator {

    override fun submitRating() {}
}