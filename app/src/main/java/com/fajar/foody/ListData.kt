package com.fajar.foody

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_list.view.*

class ListData(private val listMyData: ArrayList<Data>, val context: Context) :
    RecyclerView.Adapter<ListData.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMyData[position])
    }

    override fun getItemCount(): Int = listMyData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(myData: Data) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(myData.photo_makanan)
                    .apply( RequestOptions().override(55, 55))
                    .into(img_item_photo)
                tv_item_name . text = myData.nama_makanan
                tv_item_description.text = myData.deskripsi_makanan
                itemView.setOnClickListener {
                    val moveWithObjectIntent = Intent (context, DetailActivity::class.java)
                    moveWithObjectIntent.putExtra(DetailActivity.extra_data, myData)
                    context.startActivity(moveWithObjectIntent)
                }
            }
        }
    }
}