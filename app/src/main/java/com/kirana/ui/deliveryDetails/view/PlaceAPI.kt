package com.kirana.ui.deliveryDetails.view

import android.util.Log
import org.json.JSONException
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.net.URLEncoder


class PlaceAPI {
    private val TAG = PlaceAPI::class.java.simpleName

    private val PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place"
    private val TYPE_AUTOCOMPLETE = "/autocomplete"
    private val OUT_JSON = "/json"

    private val API_KEY = "AIzaSyCNbmY_zv50Lm2g9yI2-ljUpn665m2KWcQ"

    fun autocomplete(input: String): ArrayList<String>? {
        var resultList: ArrayList<String>? = null

        var conn: HttpURLConnection? = null
        val jsonResults = StringBuilder()

        try {
            val sb = StringBuilder(PLACES_API_BASE + TYPE_AUTOCOMPLETE + OUT_JSON)
            sb.append("?key=$API_KEY")
            sb.append("&types=(cities)")
            sb.append("&input=" + URLEncoder.encode(input, "utf8"))

            val url = URL(sb.toString())
            conn = url.openConnection() as HttpURLConnection
            val input = InputStreamReader(conn!!.getInputStream())

            // Load the results into a StringBuilder
            var read: Int
            val buff = CharArray(1024)
            read = input.read(buff)
            while (read != -1) {
                jsonResults.append(buff, 0, read)
                read = input.read(buff)
            }
        } catch (e: MalformedURLException) {
            Log.e(TAG, "Error processing Places API URL", e)
            return resultList
        } catch (e: IOException) {
            Log.e(TAG, "Error connecting to Places API", e)
            return resultList
        } finally {
            if (conn != null) {
                conn!!.disconnect()
            }
        }

        try {
            // Log.d(TAG, jsonResults.toString());

            // Create a JSON object hierarchy from the results
            val jsonObj = JSONObject(jsonResults.toString())
            val predsJsonArray = jsonObj.getJSONArray("predictions")

            // Extract the Place descriptions from the results
            resultList = ArrayList(predsJsonArray.length())
            for (i in 0 until predsJsonArray.length()) {
                resultList.add(predsJsonArray.getJSONObject(i).getString("description"))
            }
        } catch (e: JSONException) {
            Log.e(TAG, "Cannot process JSON results", e)
        }

        return resultList
    }
}