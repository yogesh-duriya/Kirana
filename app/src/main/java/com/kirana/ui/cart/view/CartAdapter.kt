package com.kirana.ui.cart.view

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kirana.R
import com.kirana.data.network.Shop
import com.kirana.ui.shop.view.ShopActivity
import com.kirana.util.extension.loadImage
import kotlinx.android.synthetic.main.shop_row.view.*

class CartAdapter(private val shopListItems: MutableList<Shop>) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    override fun getItemCount() = this.shopListItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.let {
        it.clear()
        it.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_cart , parent, false))


    internal fun addShopsToList(shops: List<Shop>){
        this.shopListItems.addAll(shops)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        fun clear(){
            /*itemView.coverImageView.setImageDrawable(null)
            itemView.tv_shop_name.text = ""
            itemView.tv_promo.text = ""*/
        }

        fun onBind(position: Int){

            val (shopName, shopId, shopImage, shopRating, deliveryTime, noRaters, Categories, promo) = shopListItems[position]
            inflateData(shopName, shopId, shopImage, shopRating + " " + noRaters, deliveryTime,  Categories, promo)
            setItemClickListener(shopId, shopName)
        }

        private fun setItemClickListener(id: String?, name: String?){
            itemView.setOnClickListener {
                name?.let {
                    try {
                        /*itemView.context.startActivity(Intent(itemView.context, ShopActivity::class.java)
                                .putExtra("ID", id)
                                .putExtra("NAME", name))*/
                    }catch (e: Exception){

                    }
                }
            }
        }

        private fun inflateData(shopName: String?, shopId: String?, shopImage: String?,
                                shopRating: String?, deliveryTime: String?, categories: String?, promo: String?) {
            /*shopName?.let { itemView.tv_shop_name.text = it }
            shopRating?.let { itemView.tv_rating.text  = it }
            deliveryTime?.let { itemView.tv_time.text = it }
            categories?.let { itemView.tv_cat_1.text = it }
            *//*if (!promo.equals(""))
                itemView.tv_promo.visibility =  View.VISIBLE*//*
            promo?.let { itemView.tv_promo.text = it }
            shopImage?.let { itemView.coverImageView.loadImage(it) }*/
        }
    }
}