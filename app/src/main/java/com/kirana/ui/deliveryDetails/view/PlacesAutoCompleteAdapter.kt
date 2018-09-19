package com.kirana.ui.deliveryDetails.view

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.Filterable

class PlacesAutoCompleteAdapter(context: Context, resource: Int) : ArrayAdapter<String>(context, resource), Filterable {

    var resultList: ArrayList<String>? = ArrayList()

    var mContext: Context
    var mResource: Int = 0

    var mPlaceAPI = PlaceAPI()

    init {
        mContext = context
        mResource = resource
    }



    override fun getItem(position: Int): String? {
        return resultList!![position]
    }

    override fun getCount(): Int {
        return resultList?.size!!
    }


    override fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                if (constraint != null) {
                    resultList = mPlaceAPI.autocomplete(constraint.toString())!!

                    // Footer
                    resultList?.add("footer");

                    filterResults.values = resultList
                    filterResults.count = resultList!!.size
                }

                // Footer
                    resultList?.add("footer");


                return filterResults
            }

            override fun publishResults(constraint: CharSequence, results: FilterResults?) {
                if (results != null && results!!.count > 0) {
                    notifyDataSetChanged()
                } else {
                    notifyDataSetInvalidated()
                }
            }
        }

    }

}