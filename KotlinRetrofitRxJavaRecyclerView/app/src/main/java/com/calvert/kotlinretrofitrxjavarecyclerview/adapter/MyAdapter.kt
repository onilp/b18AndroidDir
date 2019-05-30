package com.calvert.kotlinretrofitrxjavarecyclerview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.calvert.kotlinretrofitrxjavarecyclerview.R
import com.calvert.kotlinretrofitrxjavarecyclerview.model.Post
import kotlinx.android.synthetic.main.list_post.view.*

class MyAdapter(val context: Context, val postList: List<Post>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_post, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindValues(postList.get(position))
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindValues(post: Post){
            itemView.user_id_tv.text = post.userId.toString()
            itemView.id_tv.text = post.id.toString()
            itemView.title_tv.text = post.title
            itemView.body_tv.text = post.body
        }
    }

}