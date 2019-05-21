package com.travelapp.abercrombiefitchcodetest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

public class CardButtonRecyclerViewAdapter extends RecyclerView.Adapter<CardButtonRecyclerViewAdapter.ViewHolder> {

    List<ContentItem> contentItemList;
    Context context;

    public CardButtonRecyclerViewAdapter(List<ContentItem> contentItemList, Context context) {
        this.contentItemList = contentItemList;
        context = context;
    }

    @NonNull
    @Override
    public CardButtonRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_button_list_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardButtonRecyclerViewAdapter.ViewHolder viewHolder, int position) {
        ContentItem contentItem = contentItemList.get(position);
        viewHolder.btn_content.setText(contentItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return contentItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btn_content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btn_content = itemView.findViewById(R.id.content_btn);
        }
    }
}
