package com.example.tretiakoff.sifg2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tretiakoff.sifg2.R;
import com.example.tretiakoff.sifg2.model.Message;
import com.example.tretiakoff.sifg2.model.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by tretiakoff on 03/07/2018.
 */

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.TopRatedViewHolder> {

    private ArrayList<Message> mAnimalList = new ArrayList<>();
    private LayoutInflater topRatedInflater;
    private OnTopRatedClickListener mOnTopRatedOnClickListener;

    public MessageListAdapter(OnTopRatedClickListener mOnTopRatedOnClickListener) {
        this.mOnTopRatedOnClickListener = mOnTopRatedOnClickListener;
    }

    public static class TopRatedViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        RelativeLayout topRatedContainer;

        TopRatedViewHolder(View topRatedItemLayout) {
            super(topRatedItemLayout);
            topRatedContainer = (RelativeLayout) topRatedItemLayout;
            title = topRatedItemLayout.findViewById(R.id.text_message_body);
        }
    }

    @Override
    public TopRatedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View topRatedRl = topRatedInflater.from(parent.getContext()).inflate(R.layout.item_message_sent, parent, false);
        return new TopRatedViewHolder(topRatedRl);
    }

    @Override
    public void onBindViewHolder(TopRatedViewHolder holder, final int position) {

        final Message mAnimal = mAnimalList.get(position);
        holder.title.setText(mAnimal.getMessage());

        holder.topRatedContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnTopRatedOnClickListener.onTopRatedClick(m);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mAnimalList.size();
    }

    public void setTopRatedList(ArrayList<Message> animalList) {

        mAnimalList = animalList;
    }

    public interface OnTopRatedClickListener{
        void onTopRatedClick(Message animal);
    }
}