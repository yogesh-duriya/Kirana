package com.kirana.data.network

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RequestInterface {

    @FormUrlEncoded
    @POST(".")
    abstract fun agentLogin(@Field("Method") method: String, @Field("userID") user_id: String, @Field("password") old_pass: String, @Field("MAC_ID") MAC_ID: String): Observable<LoginResponse>

    @FormUrlEncoded
    @POST(".")
    abstract fun register(@Field("Method") method: String, @Field("First_name") First_name: String, @Field("Surname") Surname: String, @Field("Email") Email: String, @Field("Mobile") Mobile: String, @Field("Password") Password: String): Observable<LoginResponse>

    @FormUrlEncoded
    @POST(".")
    abstract fun getShops(@Field("Method") method: String): Observable<ShopResponse>

}