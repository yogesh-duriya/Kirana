package com.kirana.ui.shop.view

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kirana.R
import com.kirana.data.network.Product
import com.kirana.ui.ProductDetail.view.ProductDetailActivity
import kotlinx.android.synthetic.main.item_product.view.*

class ProductAdapter (private val categoryListItems: MutableList<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun getItemCount() = this.categoryListItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.let {
        it.clear()
        it.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_product, parent, false))


    internal fun addProductToList(category: List<Product>) {
        this.categoryListItems.addAll(category)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun clear() {
            //itemView.iv_cat.setImageDrawable(null)
            itemView.tv_name.text = ""
        }

        fun onBind(position: Int) {

            val (name, id, image, rating, raters, price, offer) = categoryListItems[position]
            inflateData(name, id, image, rating, raters, price, offer)
            setItemClickListener(name)
        }

        private fun setItemClickListener(name: String?) {
            itemView.setOnClickListener {
                name?.let {
                    try {
                        Toast.makeText(itemView.context, name, Toast.LENGTH_SHORT).show()
                        itemView.context.startActivity(Intent(itemView.context, ProductDetailActivity::class.java))
                        //val intent = Intent()
                        // using "with" as an example
                        /*with(intent) {
                            action = Intent.ACTION_VIEW
                            data = Uri.parse(it)
                            addCategory(Intent.CATEGORY_BROWSABLE)
                        }*/
                        // using "apply" as an example
                        /*itemView.context.startActivity(Intent().apply {
                            action = Intent.ACTION_VIEW
                            data = it.toUri()
                            addCategory(Intent.CATEGORY_BROWSABLE)
                        })
                        itemView.context.startActivity(intent)*/
                    } catch (e: Exception) {
                        println(e.printStackTrace())
                    }
                }
            }
        }

        private fun inflateData(name: String?, id: String?, image: String?, rating: String?, raters: String?, price: String?, offer: String?) {
            name?.let { itemView.tv_name.text = it }
            rating?.let { itemView.tv_rating.text = it }
            ("("+raters+")")?.let { itemView.tv_no_raters.text = it }
            ("Rs."+price)?.let { itemView.tv_price.text = it }
            (offer+"% off")?.let { itemView.tv_offer.text = it }
            //id?.let { itemView.tv_rating.text = it }
            //image.let{itemView.iv_cat.setImageResource(it)}

        }
    }
}