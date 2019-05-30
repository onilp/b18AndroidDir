package com.calvert.kotlinretrofitrxjavarecyclerview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.calvert.kotlinretrofitrxjavarecyclerview.R
import com.calvert.kotlinretrofitrxjavarecyclerview.model.Model
import kotlinx.android.synthetic.main.list_album.view.*

class MyAdapter(val context: Context, val albumList: List<Model.Album>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_album, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindValues(albumList.get(position))
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindValues(album: Model.Album){
            itemView.user_id_tv.text = album.userId.toString()
            itemView.id_tv.text = album.id.toString()
            itemView.title_tv.text = album.title
        }
    }

}