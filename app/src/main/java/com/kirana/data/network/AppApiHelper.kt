package com.kirana.data.network

import com.kirana.R.string.otp
import com.kirana.R.string.surname
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import javax.inject.Inject

class AppApiHelper @Inject constructor(private val apiHeader: ApiHeader) : ApiHelper {

    val requestInterface = ApiClient.getClient().create(RequestInterface::class.java)

    override fun performServerLogin(method: String, email: String, password: String, MAC_ID: String): Observable<LoginResponse>{
        //val requestInterface = ApiClient.getClient().create(RequestInterface::class.java)
       return requestInterface.agentLogin(method, email, password, MAC_ID)
    } /*=
            Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
                    .addHeaders(apiHeader.publicApiHeader)
                    .addBodyParameter(request)
                    .build()
                    .getObjectObservable(LoginResponse::class.java)*/

    override fun performRegister(method: String, firstName: String, surname: String, email: String, mobile: String, password: String): Observable<LoginResponse> {

        //val requestInterface = ApiClient.getClient().create(RequestInterface::class.java)
        return requestInterface.register(method, firstName, surname, email, mobile, password)

    }

    override fun getShopApiCall(): Observable<ShopResponse> {
        //val requestInterface = ApiClient.getClient().create(RequestInterface::class.java)
        return requestInterface.getShops("getShops")
    }

    override fun performAddToCart(method: String, user_id: String, product_id: String): Observable<LoginResponse> {
        //val requestInterface = ApiClient.getClient().create(RequestInterface::class.java)
        return requestInterface.agentLogin(method,"","","")
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

    override fun performOtp(method: String, otp: String, userId: String?): Observable<LoginResponse> {
        //val requestInterface = ApiClient.getClient().create(RequestInterface::class.java)
        return requestInterface.submitOtp("SubmitOTP", otp, userId)
    }

    override fun getOtp(method: String, userId: String?): Observable<OtpResponse> {
        return requestInterface.getOtp("GetOTP", userId)
    }


}