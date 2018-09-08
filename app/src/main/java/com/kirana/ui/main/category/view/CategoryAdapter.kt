package com.kirana.ui.main.category.view

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kirana.R
import com.kirana.data.network.Category
import kotlinx.android.synthetic.main.item_category_list.view.*

class CategoryAdapter(private val categoryListItems: MutableList<Category>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun getItemCount() = this.categoryListItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.let {
        it.clear()
        it.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_category_list, parent, false))


    internal fun addCategoryToList(category: List<Category>) {
        this.categoryListItems.addAll(category)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun clear() {
            itemView.iv_cat.setImageDrawable(null)
            itemView.tv_category.text = ""
        }

        fun onBind(position: Int) {

            val (name, id, image) = categoryListItems[position]
            inflateData(name, id, image)
            //setItemClickListener(blogUrl)
        }

        private fun setItemClickListener(blogUrl: String?) {
            itemView.setOnClickListener {
                blogUrl?.let {
                    try {
                        val intent = Intent()
                        // using "with" as an example
                        with(intent) {
                            action = Intent.ACTION_VIEW
                            data = Uri.parse(it)
                            addCategory(Intent.CATEGORY_BROWSABLE)
                        }
                        itemView.context.startActivity(intent)
                    } catch (e: Exception) {

                    }
                }
            }
        }

        private fun inflateData(name: String?, id: String?, image: Int) {
            name?.let { itemView.tv_category.text = it }
            //id?.let { itemView.tv_rating.text = it }
            image.let{itemView.iv_cat.setImageResource(it)}

        }
    }
}