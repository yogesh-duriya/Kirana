package com.kirana.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CategoryResponse(@Expose
                       @SerializedName("Status")
                       var Status: String? = null,

                       @Expose
                       @SerializedName("Message")
                       var Message: String? = null,

                       @Expose
                       @SerializedName("data")
                       var data: List<Category>? = null)