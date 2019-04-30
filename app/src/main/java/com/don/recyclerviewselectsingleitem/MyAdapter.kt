package com.don.recyclerviewselectsingleitem

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by gideon on 30,April,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */

class MyAdapter(
        val context: Context,
        private val data: List<MyMdl>
) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    var rowIndex =-1


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var tvName: TextView
        var tvDetail: TextView
        var llContainer: LinearLayout

        init {
            itemView.tag = adapterPosition
            tvName = itemView.findViewById(R.id.tv_name)
            tvDetail = itemView.findViewById(R.id.tv_detail)
            llContainer = itemView.findViewById(R.id.ll_container)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): MyAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_example, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        val result: MyMdl = data.get(position)
        holder.tvName.text = result.name
        holder.tvDetail.text = result.detail
        holder.llContainer.setOnClickListener {
            rowIndex = position;
            notifyDataSetChanged()
        }

        if (rowIndex == position) {
            holder.llContainer.setBackgroundColor(Color.parseColor("#FF929091"))
        } else {
            holder.llContainer.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }


}