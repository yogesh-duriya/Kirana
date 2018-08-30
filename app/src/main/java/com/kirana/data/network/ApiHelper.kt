package com.kirana.data.network

import io.reactivex.Observable


interface ApiHelper {

    fun performServerLogin(request: LoginRequest.ServerLoginRequest): Observable<LoginResponse>

    fun performFBLogin(request: LoginRequest.FacebookLoginRequest): Observable<LoginResponse>

    fun performGoogleLogin(request: LoginRequest.GoogleLoginRequest): Observable<LoginResponse>

    fun performLogoutApiCall(): Observable<LogoutResponse>

    fun getBlogApiCall(): io.reactivex.Observable<BlogResponse>

    fun getOpenSourceApiCall(): io.reactivex.Observable<OpenSourceResponse>

}