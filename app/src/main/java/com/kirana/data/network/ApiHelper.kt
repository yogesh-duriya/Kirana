package com.kirana.data.network

import io.reactivex.Observable


interface ApiHelper {

    fun performServerLogin(method: String, email: String, password: String, MAC_ID: String): Observable<LoginResponse>

    fun performFBLogin(request: LoginRequest.FacebookLoginRequest): Observable<LoginResponse>

    fun performGoogleLogin(request: LoginRequest.GoogleLoginRequest): Observable<LoginResponse>

    fun performLogoutApiCall(): Observable<LogoutResponse>

    fun getBlogApiCall(): Observable<BlogResponse>

    fun getOpenSourceApiCall(): Observable<OpenSourceResponse>

    fun performRegister(method: String, firstName: String, surname: String, email: String, mobile: String, password: String): Observable<LoginResponse>

    fun getShopApiCall() : Observable<ShopResponse>

    fun performAddToCart(method: String, user_id: String, product_id: String): Observable<LoginResponse>

    fun performOtp(method: String, otp: String, userId: String?): Observable<LoginResponse>

    fun getOtp(method: String, currentUserId: String?) : Observable<OtpResponse>

}