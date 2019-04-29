package com.example.recyclerviewinfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class RecyclerViewFragment extends Fragment implements MainContract.View{
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    List<UsersModel> userList;
    MainContract.Presenter presenter;
    RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        presenter = new MainPresenter(this);
        presenter.addUsers(userList);

        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(userList, presenter);
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }

    @Override
    public void redirectToDisplayFragment(Fragment displayFragment) {
        getChildFragmentManager().beginTransaction().replace(R.id.fragment_recycler_view, displayFragment).addToBackStack(null).commit();
    }

    @Override
    public void setDataToAdapter(List<UsersModel> userList) {
        this.userList = userList;
    }
}
