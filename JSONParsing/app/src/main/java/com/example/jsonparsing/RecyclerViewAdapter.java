package com.example.jsonparsing;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<ContactModel> contactList;

    public RecyclerViewAdapter(List<ContactModel> contactList) {
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ContactModel contact = contactList.get(position);
        viewHolder.idTextView.setText(contact.getId());
        viewHolder.nameTextView.setText(contact.getName());
        viewHolder.emailTextView.setText(contact.getEmail());
        viewHolder.addressTextView.setText(contact.getAddress());
        viewHolder.genderTextView.setText(contact.getGender());
        viewHolder.mobileTextView.setText(contact.getMobile());
        viewHolder.homeTextView.setText(contact.getHome());
        viewHolder.officeTextView.setText(contact.getOffice());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView idTextView, nameTextView, emailTextView, addressTextView, genderTextView, mobileTextView, homeTextView, officeTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            idTextView = itemView.findViewById(R.id.idTextView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
            addressTextView = itemView.findViewById(R.id.addressTextView);
            genderTextView = itemView.findViewById(R.id.genderTextView);
            mobileTextView = itemView.findViewById(R.id.mobileTextView);
            homeTextView = itemView.findViewById(R.id.homeTextView);
            officeTextView = itemView.findViewById(R.id.officeTextView);
        }
    }
}
