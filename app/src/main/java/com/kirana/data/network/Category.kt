package com.kirana.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Category(@Expose
                    @SerializedName("category_name")
                    var categoryName: String? = null,

                    @Expose
                    @SerializedName("category_id")
                    var categoryId: String? = null,

                    @Expose
                    @SerializedName("category_image")
                    var categoryImage: Int )
