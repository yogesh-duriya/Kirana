package com.kirana.ui.deliveryDetails.view

import android.content.Context
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.Filterable
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.net.URLEncoder


class GooglePlacesAutompleteAdapter(context: Context, textViewResourceId: Int) : ArrayAdapter<String>(context, textViewResourceId), Filterable {

    private val LOG_TAG = "Google Places Auto"
    private val PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place"
    private val TYPE_AUTOCOMPLETE = "/autocomplete"
    private val OUT_JSON = "/json"
    private val API_KEY = "AIzaSyCelpieCyUFEdKoaLjTf_DrfFcutIKqF7M"
    private var resultList: ArrayList<String>? = null


    override fun getCount(): Int {
        return if (resultList != null)
            resultList!!.size
        else
            0
    }

    override fun getItem(index: Int): String {
        return resultList!![index]
    }


    fun autocomplete(input: String): ArrayList<String>? {
        var resultList: ArrayList<String>? = null
        var descriptionList: ArrayList<String>? = null
        var conn: HttpURLConnection? = null
        val jsonResults = StringBuilder()
        try {
            val sb = StringBuilder(PLACES_API_BASE + TYPE_AUTOCOMPLETE + OUT_JSON)
            sb.append("?key=$API_KEY")
            sb.append("&components=country:in")
            sb.append("&input=" + URLEncoder.encode(input, "utf8"))

            val url = URL(sb.toString())
            conn = url.openConnection() as HttpURLConnection
            val inp = InputStreamReader(conn!!.getInputStream())

            // Load the results into a StringBuilder
            var read: Int
            val buff = CharArray(1024)

            while ((inp.read(buff)) !== -1) {
                read = inp.read(buff)
                jsonResults.append(buff, 0, read)
            }
        } catch (e: MalformedURLException) {
            Log.e(LOG_TAG, "Error processing Places API URL", e)
            return resultList
        } catch (e: IOException) {
            Log.e(LOG_TAG, "Error connecting to Places API", e)
            return resultList
        } finally {
            if (conn != null) {
                conn!!.disconnect()
            }
        }

        try {
            // Create a JSON object hierarchy from the results
            Log.d("yo", jsonResults.toString())
            val jsonObj = JSONObject(jsonResults.toString())
            val predsJsonArray = jsonObj.getJSONArray("predictions")

            // Extract the Place descriptions from the results
            resultList = ArrayList(predsJsonArray.length())
            descriptionList = ArrayList(predsJsonArray.length())
            for (i in 0 until predsJsonArray.length()) {
                resultList.add(predsJsonArray.getJSONObject(i).toString())
                descriptionList.add(predsJsonArray.getJSONObject(i).getString("description"))
            }
            //saveArray(resultList.toArray(arrayOfNulls<String>(resultList.size)), "predictionsArray", getContext())
        } catch (e: JSONException) {
            Log.e(LOG_TAG, "Cannot process JSON results", e)
        }

        return descriptionList
    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                if (constraint != null) {
                    // Retrieve the autocomplete results.
                    resultList = autocomplete(constraint.toString())

                    // Assign the data to the FilterResults
                    filterResults.values = resultList
                    filterResults.count = resultList!!.size
                }
                return filterResults
            }

            override fun publishResults(constraint: CharSequence, results: FilterResults?) {
                if (results != null && results!!.count > 0) {
                    //setImageVisibility()
                    notifyDataSetChanged()
                } else {
                    notifyDataSetInvalidated()
                }
            }
        }
    }
}