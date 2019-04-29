package com.example.uitest.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.uitest.R;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;
    private Context mContext;
    private MainContract.Presenter mPresenter;

    public WordListAdapter(Context context, LinkedList<String> wordList, MainContract.Presenter presenter) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
        mContext = context;
        mPresenter = presenter;
    }


    //when you scroll a new row gets exposed at the bottom, that row needs to be inflated--wordlist_item
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View mItemView = mInflater.inflate(R.layout.wordlist_item, viewGroup, false);
        return new WordViewHolder(mItemView, this);    }


   //populate data into the textview
    @Override
    public void onBindViewHolder(@NonNull WordViewHolder wordViewHolder, int position) {
        String mCurrent = mWordList.get(position);
        wordViewHolder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
    //holder -- wooden plank     https://thumbs.dreamstime.com/z/wood-menu-board-vector-illustration-brown-planks-58088544.jpg
    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView wordItemView;
        final WordListAdapter mAdapter;
        public WordViewHolder(@NonNull View itemView,WordListAdapter adapter) {
            super(itemView);
            wordItemView = (TextView) itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mPresenter.listItemClicked(mWordList.get(getLayoutPosition()));
            //Toast.makeText(mContext, mWordList.get(getLayoutPosition()), Toast.LENGTH_SHORT).show();
            /*int mPosition = getLayoutPosition();
            String element = mWordList.get(mPosition);
            mWordList.set(mPosition, "Clicked! " + element);
            mAdapter.notifyDataSetChanged();*/
        }
    }

}
