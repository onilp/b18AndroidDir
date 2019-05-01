package com.example.recyclerviewmvp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<FirstNameModel> firstNameList;
    MainContract.Presenter presenter;

    public RecyclerViewAdapter(List<FirstNameModel> firstNameList, MainContract.Presenter presenter) {
        this.firstNameList = firstNameList;
        presenter = presenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.first_name_item_view, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final FirstNameModel firstName = firstNameList.get(position);
        viewHolder.firstNameTextView.setText(firstName.getFirstName());
    }

    @Override
    public int getItemCount() {
        return firstNameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView firstNameTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            firstNameTextView = itemView.findViewById(R.id.firstNameTextView);
        }

        @Override
        public void onClick(View v) {
            presenter.listItemClicked(firstNameList.get(getLayoutPosition()));
        }
    }
}
