package com.kirana.ui.trackOrder.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.*
import android.widget.Button
import android.widget.RelativeLayout
import com.kirana.R
import com.kirana.data.network.OrderItem
import com.kirana.data.network.Orders
import com.kirana.util.OnStartDragListener
import com.kirana.util.SimpleItemTouchHelperCallback
import com.kirana.util.Util
import kotlinx.android.synthetic.main.frag_product_list_fragment.*

class MyCartFragment : Fragment(), OnStartDragListener {


    private var mItemTouchHelper: ItemTouchHelper? = null
    //fun MyCartFragment() {}


    fun updateMyCartFragment(showList: Boolean) {

        if (showList) {

            if (null != product_list_recycler_view && null != default_nodata) {
                product_list_recycler_view.setVisibility(View.VISIBLE)

                default_nodata.setVisibility(View.GONE)
            }
        } else {
            if (null != product_list_recycler_view && null != default_nodata) {
                product_list_recycler_view.setVisibility(View.GONE)

                default_nodata.setVisibility(View.VISIBLE)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.frag_product_list_fragment, container,
                false)

        var recyclerView = view.findViewById(R.id.product_list_recycler_view) as RecyclerView

        view.findViewById<RelativeLayout>(R.id.slide_down).visibility = View.VISIBLE

        view.findViewById<RelativeLayout>(R.id.slide_down).setOnTouchListener(
                View.OnTouchListener { v, event ->
                    Util.switchFragmentWithAnimation(R.id.frag_container,
                            MyCartFragment(), context as TrackOrderActivity,
                            Util.HOME_FRAGMENT, Util.AnimationType.SLIDE_DOWN)
                    false
                })


        // Fill Recycler View


        //if (CenterRepository.getCenterRepository().getListOfProductsInShoppingList().size() !== 0) {

        val linearLayoutManager = LinearLayoutManager(activity!!.baseContext)
        val orderListItems: MutableList<Orders> = OrderList()

        recyclerView.setLayoutManager(linearLayoutManager)
        recyclerView.setHasFixedSize(true)

        val shoppinListAdapter = ShoppingListAdapter(activity!!, this)
        recyclerView.setAdapter(shoppinListAdapter)

        shoppinListAdapter.SetOnItemClickListener(object : ShoppingListAdapter.OnItemClickListener {

            override fun onItemClick(view: View, position: Int) {

                /*Utils.switchFragmentWithAnimation(
                        R.id.frag_container,
                        ProductDetailsFragment("", position,
                                true),
                        context as ECartHomeActivity, null,
                        AnimationType.SLIDE_LEFT)*/

            }
        })

        val callback = SimpleItemTouchHelperCallback(shoppinListAdapter)
        mItemTouchHelper = ItemTouchHelper(callback)
        mItemTouchHelper!!.attachToRecyclerView(recyclerView)

        //} else {

       //updateMyCartFragment(false)

        //}

        view.findViewById<Button>(R.id.start_shopping).setOnClickListener(
                View.OnClickListener {
                    Util.switchContent(R.id.frag_container,
                            Util.HOME_FRAGMENT,
                            context as TrackOrderActivity,
                            Util.AnimationType.SLIDE_UP)
                })

        // Handle Back press
        view.setFocusableInTouchMode(true)
        view.requestFocus()
        view.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {

                /*Util.switchContent(R.id.frag_container,
                        Util.HOME_FRAGMENT,
                        context as TrackOrderActivity,
                        Util.AnimationType.SLIDE_UP)*/

            }
            true
        })

        return view
    }

    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
        mItemTouchHelper?.startDrag(viewHolder)
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
}
