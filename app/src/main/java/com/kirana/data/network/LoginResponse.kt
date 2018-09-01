package com.kirana.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResponse(@Expose
                    @SerializedName("Status")
                    var Status: String? = null,

                    @Expose
                    @SerializedName("user_id")
                    var userId: Long? = null,

                    @Expose
                    @SerializedName("access_token")
                    var accessToken: String? = null,

                    @Expose
                    @SerializedName("user_name")
                    var userName: String? = null,

                    @Expose
                    @SerializedName("email")
                    var userEmail: String? = null,

                    @Expose
                    @SerializedName("server_profile_pic_url")
                    var serverProfilePicUrl: String? = null,

                    @Expose
                    @SerializedName("fb_profile_pic_url")
                    var fbProfilePicUrl: String? = null,

                    @Expose
                    @SerializedName("google_profile_pic_url")
                    var googleProfilePicUrl: String? = null,

                    @Expose
                    @SerializedName("AgentMainID")
                    var AgentMainID: String? = null,

                    @Expose
                    @SerializedName("Message")
                    var Message: String? = null)
