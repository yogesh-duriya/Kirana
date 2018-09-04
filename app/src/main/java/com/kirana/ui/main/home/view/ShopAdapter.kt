package com.kirana.ui.main.home.view

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kirana.R
import com.kirana.data.network.Shop
import com.kirana.util.extension.loadImage
import kotlinx.android.synthetic.main.item_blog_list.view.*

class ShopAdapter(private val shopListItems: MutableList<Shop>) : RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {

    override fun getItemCount() = this.shopListItems.size

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) = holder.let {
        it.clear()
        it.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ShopViewHolder(LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_blog_list , parent, false))

    internal fun addShopsToList(shops: List<Shop>){
        this.shopListItems.addAll(shops)
        notifyDataSetChanged()
    }

    inner class ShopViewHolder(view: View) : RecyclerView.ViewHolder(view){

        fun clear(){
            itemView.coverImageView.setImageDrawable(null)
            itemView.titleTextView.text = ""
            itemView.contentTextView.text = ""
        }

        fun onBind(position: Int){

            val (title, coverPageUrl, date, description, autor, blogUrl) = shopListItems[position]
            inflateData(title, autor, date, description, coverPageUrl)
            setItemClickListener(blogUrl)
        }

        private fun setItemClickListener(blogUrl: String?){
            itemView.setOnClickListener {
                blogUrl?.let {
                    try {
                        val intent = Intent()
                        // using "with" as an example
                        with(intent){
                            action = Intent.ACTION_VIEW
                            data = Uri.parse(it)
                            addCategory(Intent.CATEGORY_BROWSABLE)
                        }
                        itemView.context.startActivity(intent)
                    }catch (e: Exception){

                    }
                }
            }
        }

        private fun inflateData(title: String?, author: String?, date: String?, description: String?, coverPageUrl: String?){
            title?.let { itemView.titleTextView.text = it }
            author?.let { itemView.authorTextView.text = it }
            date?.let { itemView.dateTextView.text = it }
            description?.let { itemView.contentTextView.text = it }
            coverPageUrl?.let { itemView.coverImageView.loadImage(it) }
        }
    }
}