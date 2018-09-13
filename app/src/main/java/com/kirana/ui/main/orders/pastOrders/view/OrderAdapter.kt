package com.kirana.ui.main.orders.pastOrders.view

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kirana.R
import com.kirana.data.network.Orders
import com.kirana.ui.main.orders.viewReceipt.view.RateUsDialog
import com.kirana.ui.productList.view.ProductListActivity
import com.kirana.ui.shop.view.ShopActivity
import kotlinx.android.synthetic.main.item_order_list.view.*

class OrderAdapter(private val orderListItems: MutableList<Orders>) : RecyclerView.Adapter<OrderAdapter.ViewHolder>() {

    override fun getItemCount() = this.orderListItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.let {
        it.clear()
        it.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_order_list, parent, false))


    internal fun addOrderToList(orders: List<Orders>) {
        this.orderListItems.addAll(orders)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun clear() {
            //itemView.iv_cat.setImageDrawable(null)
            //itemView.tv_shop_name.text = ""
        }

        fun onBind(position: Int) {

            val (name, id, image) = orderListItems[position]
            //inflateData(name, id, image)
            setItemClickListener(id, name)

        }

        private fun setItemClickListener(id: String?, name: String?) {
            itemView.tv_view_more.setOnClickListener {
                try {
                    itemView.context.startActivity(Intent(itemView.context, ShopActivity::class.java)
                            .putExtra("ID", id)
                            .putExtra("NAME", name))

                } catch (e: Exception) {
                    println(e.printStackTrace())
                }
            }
            itemView.tv_view_receipt.setOnClickListener {
                RateUsDialog.newInstance().let {
                    //it?.show(itemView.context.supportFragmentManager)
                }
            }
        }

        private fun inflateData(name: String?, id: String?, image: Int) {
            //name?.let { itemView.tv_category.text = it }
            //id?.let { itemView.tv_rating.text = it }
            //image.let{itemView.iv_cat.setImageResource(it)}

        }
    }
}