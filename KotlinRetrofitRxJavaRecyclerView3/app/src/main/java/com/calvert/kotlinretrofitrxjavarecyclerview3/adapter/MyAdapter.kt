package com.calvert.kotlinretrofitrxjavarecyclerview3.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.calvert.kotlinretrofitrxjavarecyclerview3.R
import com.calvert.kotlinretrofitrxjavarecyclerview3.model.Comment
import kotlinx.android.synthetic.main.list_comment.view.*

class MyAdapter(val context: Context, val commentList: List<Comment>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_comment, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindValues(commentList.get(position))
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindValues(comment: Comment){
            itemView.post_id_tv.text = comment.postId.toString()
            itemView.id_tv.text = comment.id.toString()
            itemView.name_tv.text = comment.name
            itemView.email_tv.text = comment.email
            itemView.body_tv.text = comment.body
        }
    }

}