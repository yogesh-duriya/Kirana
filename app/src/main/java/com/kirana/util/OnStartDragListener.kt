package com.kirana.util

import android.support.v7.widget.RecyclerView

interface OnStartDragListener {
    /**
     * Called when a view is requesting a start of a drag.
     *
     * @param viewHolder The holder of the view to drag.
     */
    abstract fun onStartDrag(viewHolder: RecyclerView.ViewHolder)
}