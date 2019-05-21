package com.calvert.retrofittwoproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.calvert.retrofittwoproject.R;
import com.calvert.retrofittwoproject.model.Comments;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Comments> commentsList;
    private Context context;

    public RecyclerViewAdapter(List<Comments> commentsList, Context context) {
        this.commentsList = commentsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.comments_list_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Comments comments = commentsList.get(position);

        viewHolder.tv_postId.setText(String.valueOf(comments.getPostId()));
        viewHolder.tv_id.setText(String.valueOf(comments.getId() + ""));
        viewHolder.tv_name.setText(comments.getName());
        viewHolder.tv_email.setText(comments.getEmail());
        viewHolder.tv_body.setText(comments.getBody());
    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_postId, tv_id, tv_name, tv_email, tv_body;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_postId = itemView.findViewById(R.id.postId_tv);
            tv_id = itemView.findViewById(R.id.id_tv);
            tv_name = itemView.findViewById(R.id.name_tv);
            tv_email = itemView.findViewById(R.id.email_tv);
            tv_body = itemView.findViewById(R.id.body_tv);
        }
    }
}
