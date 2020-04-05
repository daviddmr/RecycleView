package com.example.david.recycleview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.david.recycleview.R

class MyAdapterK(private val context: Context,
                 private val mList: MutableList<String>) : RecyclerView.Adapter<MyViewHolderK>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderK {
        val layoutInflater: View = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return MyViewHolderK(layoutInflater)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MyViewHolderK, position: Int) {
        holder.tvText.text = mList[position]
    }

    fun addItem(item: String, position: Int) {
        mList.add(item)
        notifyItemInserted(position)
    }

    fun getItemList(): MutableList<String> {
        return mList
    }
}

class MyViewHolderK(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvText: TextView = itemView.findViewById(R.id.tv_text)
}