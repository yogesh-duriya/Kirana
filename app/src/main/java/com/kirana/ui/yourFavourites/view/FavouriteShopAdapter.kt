package com.kirana.ui.yourFavourites.view

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kirana.R
import com.kirana.data.network.Shop
import com.kirana.ui.shop.view.ShopActivity
import com.kirana.util.extension.loadImage
import kotlinx.android.synthetic.main.item_fav_shop.view.*


class FavouriteShopAdapter(private val shopListItems: MutableList<Shop>) : RecyclerView.Adapter<FavouriteShopAdapter.ShopViewHolder>() {

    override fun getItemCount() = this.shopListItems.size
    var check : Boolean = false

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) = holder.let {
        it.clear()
        it.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ShopViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_fav_shop , parent, false))


    internal fun addShopsToList(shops: List<Shop>){
        this.shopListItems.addAll(shops)
        notifyDataSetChanged()
    }

    internal fun editable(check: Boolean){
            this.check = check
            /*for (i in this.shopListItems.indices){
                if (check) {
                    this.shopListItems[i].isEditable = true
                }else
                    this.shopListItems[i].isEditable = false
                }*/
        notifyDataSetChanged()
    }

    inner class ShopViewHolder(view: View) : RecyclerView.ViewHolder(view){

        fun clear(){
            itemView.iv_shop_image.setImageDrawable(null)
            itemView.tv_shop_name.text = ""
            itemView.tv_total_orders.text = ""
        }

        fun onBind(position: Int){

            val (shopName, shopId, shopImage, shopRating, deliveryTime, noRaters, Categories, promo, totalOrders, isEditable) = shopListItems[position]
            inflateData(shopName, shopId, shopImage, shopRating + " " + noRaters, deliveryTime,  Categories, promo, totalOrders, isEditable)
            setItemClickListener(shopId, shopName, position)
        }

        private fun setItemClickListener(id: String?, name: String?, position: Int){
            itemView.setOnClickListener {
                name?.let {
                    try {
                        itemView.context.startActivity(Intent(itemView.context, ShopActivity::class.java)
                                .putExtra("ID", id)
                                .putExtra("NAME", name))
                    }catch (e: Exception){
                        e.printStackTrace()
                    }
                }
            }
            itemView.iv_edit.setOnClickListener {
                if (shopListItems[position].isEditable) {
                    itemView.iv_edit.setImageDrawable(itemView.context.resources.getDrawable(R.drawable.ic_lens_gray_24dp))
                    shopListItems[position].isEditable = false
                }else{
                    itemView.iv_edit.setImageDrawable(itemView.context.resources.getDrawable(R.drawable.ic_lens_red_24dp))
                    shopListItems[position].isEditable = true
                }
            }
        }

        private fun inflateData(shopName: String?, shopId: String?, shopImage: String?,
                                shopRating: String?, deliveryTime: String?, categories: String?, promo: String?, totalOrders: String?, editable: Boolean) {
            shopName?.let { itemView.tv_shop_name.text = it }
            deliveryTime?.let { itemView.tv_time.text = it }
            categories?.let { itemView.tv_cat_1.text = it }
            totalOrders+"Order"?.let { itemView.tv_total_orders.text = it }
            shopImage?.let { itemView.iv_shop_image.loadImage(it) }
            if (check) {
                itemView.iv_edit.visibility = View.VISIBLE
                itemView.tv_time.visibility = View.GONE
            }else{
                itemView.iv_edit.visibility = View.GONE
                itemView.tv_time.visibility = View.VISIBLE
            }

        }
    }
}