package com.calvert.kotlinretrofitrecyclerview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.calvert.kotlinretrofitrecyclerview.R
import com.calvert.kotlinretrofitrecyclerview.model.Users
import kotlinx.android.synthetic.main.list_users.view.*

class MyAdapter(val context: Context, val usersList: List<Users>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_users, parent, false)
        return ViewHolder(view)    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindValues(usersList.get(position))
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindValues(users: Users){
            itemView.id_tv.text = users.id.toString()
            itemView.email_tv.text = users.email
            itemView.first_name_tv.text = users.first_name
            itemView.last_name_tv.text = users.last_name
            itemView.avatar_tv.text = users.avatar
        }
    }
}