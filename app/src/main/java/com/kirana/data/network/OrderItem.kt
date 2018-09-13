package com.kirana.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class OrderItem(@Expose
                     @SerializedName("item_name")
                     var ItemName: String? = null,

                     @Expose
                     @SerializedName("item_id")
                     var ItemId: String? = null,

                     @Expose
                     @SerializedName("item_quantity")
                     var itemQuantity: String? = null,

                     @Expose
                     @SerializedName("item_price")
                     var itemPrice: String? = null,

                     @Expose
                     @SerializedName("no_of_item")
                     var noOfItem: String? = null)