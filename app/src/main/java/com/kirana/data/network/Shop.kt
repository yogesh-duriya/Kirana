package com.kirana.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Shop(@Expose
                 @SerializedName("shop_name")
                 var shopName: String? = null,

                @Expose
                 @SerializedName("shop_id")
                 var shopId: String? = null,

                @Expose
                 @SerializedName("shop_image")
                 var shopImage: String? = null,

                @Expose
                 @SerializedName("shop_rating")
                 var shopRating: String? = null,

                @Expose
                 @SerializedName("delivery_time")
                 var deliveryTime: String? = null,

                @Expose
                 @SerializedName("no_raters")
                 var noRaters: String? = null,

                @Expose
                 @SerializedName("categories")
                 var Categories: String? = null,

                @Expose
                @SerializedName("promo")
                var promo: String? = null
)