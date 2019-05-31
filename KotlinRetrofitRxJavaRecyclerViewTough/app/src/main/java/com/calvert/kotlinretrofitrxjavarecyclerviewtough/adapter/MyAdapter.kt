package com.calvert.kotlinretrofitrxjavarecyclerviewtough.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.calvert.kotlinretrofitrxjavarecyclerviewtough.R
import com.calvert.kotlinretrofitrxjavarecyclerviewtough.model.Data
import kotlinx.android.synthetic.main.list_users.view.*
import org.jetbrains.anko.toast

class MyAdapter(private val context: Context, private val dataList: List<Data>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_users, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder, position: Int) {
//        myViewHolder.bindValues(dataList.get(position))
        myViewHolder.id_tv.text = dataList.get(position).id.toString()
        myViewHolder.email_tv.text = dataList.get(position).email
        myViewHolder.first_name_tv.text = dataList.get(position).first_name
        myViewHolder.last_name_tv.text = dataList.get(position).last_name
        myViewHolder.avatar_tv.text = dataList.get(position).avatar

        myViewHolder.itemView.setOnClickListener({
            context.toast(dataList.get(position).email)
        })
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//        fun bindValues(data: Data){
//            itemView.id_tv.text = data.id.toString()
//            itemView.email_tv.text = data.email
//            itemView.first_name_tv.text = data.first_name
//            itemView.last_name_tv.text = data.last_name
//            itemView.avatar_tv.text = data.avatar
//        }

        val id_tv = itemView.id_tv
        val email_tv = itemView.email_tv
        val first_name_tv = itemView.first_name_tv
        val last_name_tv = itemView.last_name_tv
        val avatar_tv = itemView.avatar_tv
    }
}