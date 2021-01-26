package com.example.adapter

import android.media.Image
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.adapter_vertical.view.*
import java.util.ArrayList

class MyAdapter(private val layout:Int, private val data: ArrayList<Item>):BaseAdapter() {
    override fun getCount() = data.size
    override fun getItem(position: Int) = data[position]
    override fun getItemId(position: Int) = 0L
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View
        val holder:ViewHolder

        if(convertView == null) {
            view = View.inflate(parent?.context, layout, null);
            holder = ViewHolder();
            //為view加上標籤，以便重複使用
            view.tag = holder
            //連接畫面中的元件
            holder.img_photo = view.findViewById(R.id.img_photo)
            holder.tv_name = view.findViewById(R.id.tv_name)
        }else{
            //重複使用已存在的view
            holder = convertView.tag as ViewHolder
            view = convertView
        }

        holder.img_photo.setImageResource(data[position].photo)
        holder.tv_name.text = data[position].name

        return view
    }
}

private class ViewHolder{
    lateinit var img_photo:ImageView
    lateinit var tv_name:TextView
}