package com.example.volleyhomeworkone;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private final List<Actors> actorsList;
    private final Context context;

    RecyclerViewAdapter(List<Actors> actorsList, Context context) {
        this.actorsList = actorsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.actor_list_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        Actors actor = actorsList.get(position);

        viewHolder.idTextView.setText(actor.getId());
        viewHolder.actorNameTextView.setText(actor.getActorName());
        viewHolder.movieNameTextView.setText(actor.getMovieName());

        ImageRequest imageRequest = new ImageRequest(actor.getImageUrl(), new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                viewHolder.actorImageView.setImageBitmap(response);
            }
        }, 300, 300, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Failed to load image.", Toast.LENGTH_LONG).show();
            }
        });

        VolleySingleton.getInstance(context).addToRequestQueue(imageRequest);
    }

    @Override
    public int getItemCount() {
        return actorsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView idTextView;
        final TextView actorNameTextView;
        final TextView movieNameTextView;
        final ImageView actorImageView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            idTextView = itemView.findViewById(R.id.id_textview);
            actorNameTextView = itemView.findViewById(R.id.actor_name_textview);
            movieNameTextView = itemView.findViewById(R.id.movie_name_textview);
            actorImageView = itemView.findViewById(R.id.movie_star_imageview);
        }
    }
}
