package com.example.volleyhomeworktwo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<Profile> profileList;
    Context context;

    public RecyclerViewAdapter(List<Profile> profileList, Context context) {
        this.profileList = profileList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.profile_list_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Profile profile = profileList.get(position);

        viewHolder.firstNameTextView.setText(profile.getFirstName());
        viewHolder.lastNameTextView.setText(profile.getLastName());
        viewHolder.ageTextView.setText(profile.getAge());
    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView firstNameTextView, lastNameTextView, ageTextView;
        ViewHolder(@NonNull View itemView) {
            super(itemView);

            firstNameTextView = itemView.findViewById(R.id.firstname_textview);
            lastNameTextView = itemView.findViewById(R.id.lastname_textview);
            ageTextView = itemView.findViewById(R.id.age_textview);
        }
    }
}
