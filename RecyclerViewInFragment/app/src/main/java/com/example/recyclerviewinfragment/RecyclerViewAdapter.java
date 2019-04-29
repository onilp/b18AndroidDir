package com.example.recyclerviewinfragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<UsersModel> userList;
    MainContract.Presenter presenter;

    RecyclerViewAdapter(List<UsersModel> userList, MainContract.Presenter presenter) {
        this.userList = userList;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {
        final UsersModel user = userList.get(position);
        viewHolder.nameTextView.setText(user.getName());
        viewHolder.ageTextView.setText(user.getAge());

//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DisplayFragment displayFragment = new DisplayFragment();
//                Bundle bundle = new Bundle();
//                bundle.putString("name", user.getName());
//                bundle.putString("age", user.getAge());
//                displayFragment.setArguments(bundle);
//
//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.activity_container, displayFragment).addToBackStack(null).commit();
//            }
//        });

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickedData(user.getName(), user.getAge());
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, ageTextView;

        ViewHolder(@NonNull final View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.name_textview);
            ageTextView = itemView.findViewById(R.id.age_textview);

        }
    }
}
