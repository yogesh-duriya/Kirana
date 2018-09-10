package com.kirana.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Product(@Expose
                   @SerializedName("product_name")
                   var productName: String? = null,

                   @Expose
                   @SerializedName("product_id")
                   var productId: String? = null,

                   @Expose
                   @SerializedName("product_image")
                   var productImage: String? = null,

                   @Expose
                   @SerializedName("product_rating")
                   var productRating: String? = null,

                   @Expose
                   @SerializedName("delivery_time")
                   var deliveryTime: String? = null,

                   @Expose
                   @SerializedName("no_raters")
                   var noRaters: String? = null,

                   @Expose
                   @SerializedName("product_price")
                   var productPrice: String? = null,

                   @Expose
                   @SerializedName("product_offer")
                   var productOffer: String? = null)