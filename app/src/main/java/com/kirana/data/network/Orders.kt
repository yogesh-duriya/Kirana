package com.kirana.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Orders(@Expose
                  @SerializedName("shop_name")
                  var shopName: String? = null,

                  @Expose
                  @SerializedName("shop_id")
                  var shopId: String? = null,

                  @Expose
                  @SerializedName("shop_image")
                  var shopImage: String? = null,

                  @Expose
                  @SerializedName("order_id")
                  var orderId: String? = null,

                  @Expose
                  @SerializedName("order_rating")
                  var orderRating: String? = null,

                  @Expose
                  @SerializedName("order_date")
                  var orderDate: String? = null,

                  @Expose
                  @SerializedName("delivered_by")
                  var deliveredBy: String? = null,

                  @Expose
                  @SerializedName("total")
                  var total: String? = null,

                  @Expose
                  @SerializedName("order_Item")
                  var orderItem: List<OrderItem>? = null,

                  @Expose
                  @SerializedName("tax")
                  var Tax: String? = null,

                  @Expose
                  @SerializedName("sub_total")
                  var subTotal: String? = null,

                  @Expose
                  @SerializedName("delivery_fee")
                  var deliveryFee: String? = null,

                  @Expose
                  @SerializedName("discount")
                  var discount: String? = null)



