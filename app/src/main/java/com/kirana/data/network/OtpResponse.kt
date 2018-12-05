package com.kirana.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OtpResponse(@Expose
                   @SerializedName("Status")
                   var Status: String? = null,

                   @Expose
                   @SerializedName("Message")
                   var Message: String? = null)