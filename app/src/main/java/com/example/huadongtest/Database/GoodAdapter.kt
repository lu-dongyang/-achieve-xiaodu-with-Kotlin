package com.example.huadongtest.Database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.huadongtest.R

class GoodAdapter(val goodslist:List<String>): RecyclerView.Adapter<GoodAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view ){

        val goodsName: TextView = view.findViewById(R.id.goodsname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // TODO("Not yet implemented")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.goods_item,parent,false)
        val viewHolder = ViewHolder(view)
        //整体也行，图片或者汉字单独也行
        viewHolder.itemView.setOnClickListener{
            val position = viewHolder.adapterPosition  //找到点击位置
            val good = goodslist[position]  //提取位置
            Toast.makeText(parent.context,"you click view ", Toast.LENGTH_SHORT).show() //显示
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        TODO("Not yet implemented")

        val goods=goodslist[position]

        holder.goodsName.text = goods
    }

    override fun getItemCount(): Int {
        // TODO("Not yet implemented")
        return goodslist.size
    }


}