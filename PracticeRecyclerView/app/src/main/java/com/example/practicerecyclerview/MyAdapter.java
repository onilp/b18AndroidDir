package com.example.practicerecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<MyListData> myListData;

    public MyAdapter(List<MyListData> myListData) {
        this.myListData = myListData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        MyListData listData = myListData.get(position);
        myViewHolder.myListDataTextView.setText(listData.getMyListData());
    }

    @Override
    public int getItemCount() {
        return myListData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView myListDataTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            myListDataTextView = itemView.findViewById(R.id.myListDataTextView);

        }
    }
}
