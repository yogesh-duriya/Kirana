package com.kirana.ui.trackOrder.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import com.androidnetworking.utils.Utils
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.kirana.R
import com.kirana.util.Util
import kotlinx.android.synthetic.main.view_bottom_anchor.*
import java.lang.Double
import java.util.LinkedHashMap

class TrackOrderActivity : AppCompatActivity() , OnMapReadyCallback {

    private var mMapFragment: SupportMapFragment? = null // MapView UI element

    private var mGoogleMap: GoogleMap? = null // object that represents googleMap and allows us to use Google Maps API features

    private var driverMarker: Marker? = null // Marker to display driver's location

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track_order)

        mMapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mMapFragment!!.getMapAsync(this)

        setListener()
    }

    private fun setListener() {
        ll_bottom.setOnClickListener {
            Util.switchContent(R.id.frag_container,
                    Util.SHOPPING_LIST_TAG, this,
                    Util.AnimationType.SLIDE_UP)
        }
    }

    public override fun onResume() {
        super.onResume()
        mMapFragment?.onResume()
    }

    public override fun onPause() {
        super.onPause()
        mMapFragment?.onPause()
    }

    public override fun onDestroy() {
        super.onDestroy()
        mMapFragment?.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mMapFragment?.onLowMemory()
    }

    /*
        This method is called when the map is completely set up. After the map is setup,
        the passenger will be subscribed to the driver's location channel, so their location
        can be updated on the MapView. We use the reference to the GoogleMap object googleMap
        to utilize any Google Maps API features.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        try {
            mGoogleMap = googleMap
            mGoogleMap!!.setMyLocationEnabled(true)
        } catch (e: SecurityException) {
            e.printStackTrace()
        }

        // This code adds the listener and subscribes passenger to channel with driver's location.
        try {
            val newLocation = HashMap<String, String>()
            newLocation.put("lat", "26.936961") //= JsonUtil.fromJson(message.getMessage().toString(), LinkedHashMap<*, *>::class.java)
            newLocation.put("lng", "75.803016") //= JsonUtil.fromJson(message.getMessage().toString(), LinkedHashMap<*, *>::class.java)
            updateUI(newLocation)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /*
        This method gets the new location of driver and calls method animateCar
        to move the marker slowly along linear path to this location.
        Also moves camera, if marker is outside of map bounds.
     */
    private fun updateUI(newLoc: Map<String, String>) {
        val newLocation = LatLng(Double.valueOf(newLoc["lat"]), Double.valueOf(newLoc["lng"]))
        if (driverMarker != null) {
            animateCar(newLocation)
            val contains = mGoogleMap?.getProjection()?.visibleRegion?.latLngBounds?.contains(newLocation)
            if (!contains!!) {
                mGoogleMap?.moveCamera(CameraUpdateFactory.newLatLng(newLocation))
            }
        } else {
            mGoogleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(
                    newLocation, 15.5f))
            driverMarker = mGoogleMap?.addMarker(MarkerOptions().position(newLocation).icon(BitmapDescriptorFactory.fromResource(R.drawable.car)))
        }
    }

    /*
        Animates car by moving it by fractions of the full path and finally moving it to its
        destination in a duration of 5 seconds.
     */
    private fun animateCar(destination: LatLng) {
        val startPosition = driverMarker?.getPosition()
        val endPosition = LatLng(destination.latitude, destination.longitude)
        val latLngInterpolator = LatLngInterpolator.LinearFixed()

        val valueAnimator = ValueAnimator.ofFloat(0F, 1F)
        valueAnimator.duration = 5000 // duration 5 seconds
        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.addUpdateListener { animation ->
            try {
                val v = animation.animatedFraction
                val newPosition = latLngInterpolator.interpolate(v, startPosition!!, endPosition)
                driverMarker?.setPosition(newPosition)
            } catch (ex: Exception) {
            }
        }
        valueAnimator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
            }
        })
        valueAnimator.start()
    }

    /*
        This interface defines the interpolate method that allows us to get LatLng coordinates for
        a location a fraction of the way between two points. It also utilizes a Linear method, so
        that paths are linear, as they should be in most streets.
     */
    private interface LatLngInterpolator {
        fun interpolate(fraction: Float, a: LatLng, b: LatLng): LatLng

        class LinearFixed : LatLngInterpolator {
            override fun interpolate(fraction: Float, a: LatLng, b: LatLng): LatLng {
                val lat = (b.latitude - a.latitude) * fraction + a.latitude
                var lngDelta = b.longitude - a.longitude
                if (Math.abs(lngDelta) > 180) {
                    lngDelta -= Math.signum(lngDelta) * 360
                }
                val lng = lngDelta * fraction + a.longitude
                return LatLng(lat, lng)
            }
        }
    }
}
