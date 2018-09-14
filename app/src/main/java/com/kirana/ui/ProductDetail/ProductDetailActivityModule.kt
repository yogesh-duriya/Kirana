package com.kirana.ui.ProductDetail

import com.kirana.ui.ProductDetail.interactor.ProductDetailInteractor
import com.kirana.ui.ProductDetail.interactor.ProductDetailMVPInteractor
import com.kirana.ui.ProductDetail.presenter.ProductDetailMVPPresenter
import com.kirana.ui.ProductDetail.presenter.ProductDetailPresenter
import com.kirana.ui.ProductDetail.view.ProductDetailMVPView
import dagger.Module
import dagger.Provides

@Module
class ProductDetailActivityModule {
    @Provides
    internal fun provideProductDetailInteractor(interactor: ProductDetailInteractor): ProductDetailMVPInteractor = interactor

    @Provides
    internal fun provideProductDetailPresenter(presenter: ProductDetailPresenter<ProductDetailMVPView, ProductDetailMVPInteractor>)
            : ProductDetailMVPPresenter<ProductDetailMVPView, ProductDetailMVPInteractor> = presenter
}