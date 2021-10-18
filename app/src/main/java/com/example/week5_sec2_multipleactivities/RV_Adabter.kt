package com.example.week5_sec2_multipleactivities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RV_Adabter (private val listOf_info:ArrayList<String>): RecyclerView.Adapter<RV_Adabter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val name = listOf_info[position]

        holder.itemView.apply {
            textView.text = name
        }
    }

    override fun getItemCount() = listOf_info.size
}