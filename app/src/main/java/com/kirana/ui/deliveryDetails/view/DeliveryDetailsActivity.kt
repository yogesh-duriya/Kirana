package com.kirana.ui.deliveryDetails.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import android.os.Process
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.kirana.R
import kotlinx.android.synthetic.main.activity_delivery_details.*
import android.widget.Toast
import android.widget.AdapterView


class DeliveryDetailsActivity : AppCompatActivity() {
    private val TAG = DeliveryDetailsActivity::class.java!!.getName()
    private var mAdapter: PlacesAutoCompleteAdapter? = null
    lateinit var mHandlerThread: HandlerThread
    var mThreadHandler: Handler? = null
    //lateinit var dataAdapter: GooglePlacesAutompleteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery_details)

        mAdapter = PlacesAutoCompleteAdapter(this, R.layout.autocomplete_list_item)
        mAdapter?.resultList?.add("footer")
        autocomplete.setAdapter(mAdapter)

        autocomplete.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Get data associated with the specified position
                // in the list (AdapterView)
                val description = parent.getItemAtPosition(position) as String
                showTost(description)

            }
        })

        autocomplete.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val value = s.toString()

                // Remove all callbacks and messages
                mThreadHandler?.removeCallbacksAndMessages(null)

                // Now add a new one
                mThreadHandler?.postDelayed(Runnable {
                    // Background thread

                    mAdapter?.resultList = mAdapter?.mPlaceAPI?.autocomplete(value)!!

                    // Footer
                    if (mAdapter?.resultList!!.size > 0)
                        mAdapter?.resultList?.add("footer")

                    // Post to Main Thread
                    mThreadHandler!!.sendEmptyMessage(1)
                }, 500)
            }

            override fun afterTextChanged(s: Editable) {
                //doAfterTextChanged()
            }
        })

    }

    private fun showTost(description: String) {
        Toast.makeText(this, description, Toast.LENGTH_SHORT).show()
    }

    public override fun onDestroy() {
        super.onDestroy()

        // Get rid of our Place API Handlers
        if (mThreadHandler != null) {
            mThreadHandler!!.removeCallbacksAndMessages(null)
            mHandlerThread.quit()
        }
    }



    init{
        // Required empty public constructor

        if (mThreadHandler == null) {
            // Initialize and start the HandlerThread
            // which is basically a Thread with a Looper
            // attached (hence a MessageQueue)
            mHandlerThread = HandlerThread(TAG, Process.THREAD_PRIORITY_BACKGROUND)
            mHandlerThread.start()

            // Initialize the Handler
            mThreadHandler = object : Handler(mHandlerThread.looper) {
                override fun handleMessage(msg: Message) {
                    if (msg.what === 1) {
                        val results = mAdapter?.resultList

                        if (results != null && results!!.size > 0) {
                            mAdapter?.notifyDataSetChanged()
                        } else {
                            mAdapter?.notifyDataSetInvalidated()
                        }
                    }
                }
            }
        }

    }
}
