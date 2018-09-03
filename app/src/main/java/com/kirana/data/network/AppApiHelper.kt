package com.kirana.data.network

import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import javax.inject.Inject

class AppApiHelper @Inject constructor(private val apiHeader: ApiHeader) : ApiHelper {

    override fun performServerLogin(method: String, email: String, password: String, MAC_ID: String): Observable<LoginResponse>{

        val requestInterface = ApiClient.getClient().create(RequestInterface::class.java)
       return requestInterface.agentLogin(method, email, password, MAC_ID)

    } /*=
            Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
                    .addHeaders(apiHeader.publicApiHeader)
                    .addBodyParameter(request)
                    .build()
                    .getObjectObservable(LoginResponse::class.java)*/

    override fun performRegister(method: String, firstName: String, surname: String, email: String, mobile: String, password: String): Observable<LoginResponse> {

        val requestInterface = ApiClient.getClient().create(RequestInterface::class.java)
        return requestInterface.register(method, firstName, surname, email, mobile, password)

    }

    override fun performFBLogin(request: LoginRequest.FacebookLoginRequest): Observable<LoginResponse> =
            Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_FACEBOOK_LOGIN)
                    .addHeaders(apiHeader.publicApiHeader)
                    .addBodyParameter(request)
                    .build()
                    .getObjectObservable(LoginResponse::class.java)

    override fun performGoogleLogin(request: LoginRequest.GoogleLoginRequest): Observable<LoginResponse> =
            Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_GOOGLE_LOGIN)
                    .addHeaders(apiHeader.publicApiHeader)
                    .addBodyParameter(request)
                    .build()
                    .getObjectObservable(LoginResponse::class.java)

    override fun performLogoutApiCall(): Observable<LogoutResponse> =
            Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGOUT)
                    .addHeaders(apiHeader.protectedApiHeader)
                    .build()
                    .getObjectObservable(LogoutResponse::class.java)

    override fun getBlogApiCall(): Observable<BlogResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_BLOG)
                    .addHeaders(apiHeader.protectedApiHeader)
                    .build()
                    .getObjectObservable(BlogResponse::class.java)

    override fun getOpenSourceApiCall(): Observable<OpenSourceResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_OPEN_SOURCE)
                    .addHeaders(apiHeader.protectedApiHeader)
                    .build()
                    .getObjectObservable(OpenSourceResponse::class.java)

}