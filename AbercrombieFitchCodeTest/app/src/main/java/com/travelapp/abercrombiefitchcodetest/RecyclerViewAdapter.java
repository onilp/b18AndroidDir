package com.travelapp.abercrombiefitchcodetest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private List<ShoppingModel> shoppingModelList;
    private RecyclerView.LayoutManager layoutManager;
    private CardButtonRecyclerViewAdapter cardButtonRecyclerViewAdapter;
    private Context context;

    RecyclerViewAdapter(List<ShoppingModel> shoppingModels, MainActivity mainActivity) {
        this.shoppingModelList = shoppingModels;
        layoutManager = new LinearLayoutManager(mainActivity);
        context = mainActivity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_layout, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        ShoppingModel shoppingModel = shoppingModelList.get(position);

        Picasso.get().load(shoppingModel.getBackgroundImage()).into(myViewHolder.iv_background);
        myViewHolder.tv_topDescription.setText(shoppingModel.getTopDescription());
        myViewHolder.tv_title.setText(shoppingModel.getTitle());
        myViewHolder.tv_promo_message.setText(shoppingModel.getPromoMessage());
        myViewHolder.tv_bottom_description.setText(shoppingModel.getBottomDescription());

        myViewHolder.rv_card_button.setLayoutManager(layoutManager);
        cardButtonRecyclerViewAdapter = new CardButtonRecyclerViewAdapter(shoppingModel.getContent(), context);
        myViewHolder.rv_card_button.setAdapter(cardButtonRecyclerViewAdapter);
    }


    @Override
    public int getItemCount() {
        return shoppingModelList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_background;
        TextView tv_topDescription, tv_title, tv_promo_message, tv_bottom_description;
        RecyclerView rv_card_button;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_background = itemView.findViewById(R.id.background_iv);
            tv_topDescription = itemView.findViewById(R.id.topDescription_tv);
            tv_title = itemView.findViewById(R.id.title_tv);
            tv_promo_message = itemView.findViewById(R.id.promo_message_tv);
            tv_bottom_description = itemView.findViewById(R.id.bottom_description_tv);
            rv_card_button = itemView.findViewById(R.id.card_button_recyclerview);
        }
    }
}

