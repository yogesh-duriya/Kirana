package com.kirana.ui.trackOrder.view

import android.content.Context
import android.graphics.Color
import android.support.v4.view.MotionEventCompat
import android.support.v7.widget.RecyclerView
import android.text.Spannable
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.androidnetworking.utils.Utils
import com.bumptech.glide.Glide
import com.kirana.R
import com.kirana.data.network.OrderItem
import com.kirana.data.network.Orders
import com.kirana.util.ItemTouchHelperAdapter
import com.kirana.util.ItemTouchHelperViewHolder
import com.kirana.util.OnStartDragListener
import java.math.BigDecimal
import java.util.*

class ShoppingListAdapter(context: Context, dragStartListener: OnStartDragListener) : RecyclerView.Adapter<ShoppingListAdapter.ItemViewHolder>(), ItemTouchHelperAdapter {


    companion object {
        var clickListener: OnItemClickListener? = null
    }

    private lateinit var mDragStartListener: OnStartDragListener
    private var ImageUrl: String? = null
    private val productList: MutableList<Orders>
    private val context: Context

    init {
        mDragStartListener = dragStartListener

        this.context = context

        productList = OrderList()
    }

    private fun OrderList(): MutableList<Orders> {
        var orderList: MutableList<Orders> =
                mutableListOf(Orders("Chhabra's Pure Veg- Nirman Nagar", "1", "", "#132456", "5", "25 Aug 2018, 12:51", "Harish", "120.00", orderItems(), "10.00", "200.00", "10.00", "100"),
                        Orders("Chhabra's Pure Veg- Nirman Nagar", "2", "", "#78910", "4", "25 Aug 2018, 12:51", "Harish", "120.00", orderItems(), "10.00", "200.00", "10.00", "100"))
        return orderList
    }

    private fun orderItems(): List<OrderItem>? {
        var orderItem: MutableList<OrderItem> =
                mutableListOf(OrderItem("Dal Fry", "2", "500Gms", "110.00", "1"),
                        OrderItem("kadai Paneer", "5", "250Gms", "90.00", "1"))

        return orderItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_order_list, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {


    }


    override fun getItemCount(): Int {
        return productList.size
    }

    fun SetOnItemClickListener(
            itemClickListener: OnItemClickListener) {
        clickListener = itemClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    /**
     * Simple example of a view holder that implements
     * [ItemTouchHelperViewHolder] and has a "handle" view that initiates
     * a drag event when touched.
     */
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), ItemTouchHelperViewHolder, View.OnClickListener {

        // public final ImageView handleView;

        init {

            itemView.setOnClickListener(this)
        }

        override fun onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY)
        }

        override fun onItemClear() {
            itemView.setBackgroundColor(0)
        }

        override fun onClick(v: View) {
            clickListener!!.onItemClick(v, position)
        }
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        Collections.swap(productList, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    override fun onItemDismiss(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}