package com.example.lab7dialogrv_sec1_603020771_3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.std_item_layout.view.*
import java.text.FieldPosition

class StudentsAdapter (val items : List<Student>, val context: Context): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view_item = LayoutInflater.from(parent.context).inflate(R.layout.std_item_layout, parent,false)
        return ViewHolder(view_item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {
        holder.tvID?.text = "ID : " + items[position].id
        holder.tvName?.text = "Name : " + items[position].name
        holder.tvAge?.text = "Age : " + items[position].age.toString()
    }
}
class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
    val tvID  = view.tv_id
    val tvName = view.tv_name
    val tvAge = view.tv_age
}