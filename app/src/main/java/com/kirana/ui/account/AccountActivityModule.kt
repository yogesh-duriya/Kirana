package com.kirana.ui.account

import com.kirana.ui.account.interactor.AccountInteractor
import com.kirana.ui.account.interactor.AccountMVPInteractor
import com.kirana.ui.account.presenter.AccountMVPPresenter
import com.kirana.ui.account.presenter.AccountPresenter
import com.kirana.ui.account.view.AccountMVPView
import dagger.Module
import dagger.Provides

@Module
class AccountActivityModule {

    @Provides
    internal fun provideAccountInteractor(interactor: AccountInteractor): AccountMVPInteractor = interactor

    @Provides
    internal fun provideAccountPresenter(presenter: AccountPresenter<AccountMVPView, AccountMVPInteractor>)
            : AccountMVPPresenter<AccountMVPView, AccountMVPInteractor> = presenter
}