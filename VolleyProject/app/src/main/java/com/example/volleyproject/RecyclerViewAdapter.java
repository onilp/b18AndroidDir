package com.example.volleyproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<POJO> itemList;
    RequestQueue requestQueue;

    public RecyclerViewAdapter(List<POJO> itemList) {
        this.itemList = itemList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        POJO item = itemList.get(position);
        viewHolder.idTextView.setText(item.getCategoryID());
        viewHolder.nameTextView.setText(item.getCategoryName());
        viewHolder.descriptionTextView.setText(item.getCategoryDescription());

        ImageRequest imageRequest = new ImageRequest(item.getCategoryImage(), new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                viewHolder.imageView.setImageBitmap(response);
            }
        }, 350, 350, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Image error", error.toString());
            }
        });

        requestQueue = Volley.newRequestQueue(viewHolder.itemView.getContext());
        requestQueue.add(imageRequest);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView idTextView, nameTextView, descriptionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview);
            idTextView = itemView.findViewById(R.id.id_textview);
            nameTextView = itemView.findViewById(R.id.name_textview);
            descriptionTextView = itemView.findViewById(R.id.description_textview);
        }
    }
}
