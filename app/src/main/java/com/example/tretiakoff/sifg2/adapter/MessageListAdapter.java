package com.example.tretiakoff.sifg2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tretiakoff.sifg2.R;
import com.example.tretiakoff.sifg2.model.Message;
import com.example.tretiakoff.sifg2.model.User;

import java.util.ArrayList;

/**
 * Created by tretiakoff on 03/07/2018.
 */

public class MessageListAdapter extends RecyclerView.Adapter{

    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;

    private Context mContext;
    private ArrayList<Message> mMessageList;

    public MessageListAdapter(Context context, ArrayList<Message> messageList) {
        mContext = context;
        mMessageList = messageList;
    }

    public void setMessageList(ArrayList<Message> topRatedList) {

        mMessageList = topRatedList;
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

    // Inflates the appropriate layout according to the ViewType.
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_message_sent, parent, false);
            return new SentMessageHolder(view);
    }

    // Passes the message object to a ViewHolder so that the contents can be bound to UI.
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Message message = mMessageList.get(position);

                ((SentMessageHolder) holder).bind(message);
    }

    private class SentMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText, timeText;

        SentMessageHolder(View itemView) {
            super(itemView);

            messageText = itemView.findViewById(R.id.text_message_body);
            timeText = itemView.findViewById(R.id.text_message_time);
        }



        void bind(Message message) {
            messageText.setText(message.getMessage());

//            timeText.setText(DateUtils.formatDateTime(mContext, message.getCreatedAt(), 0));
        }
    }

//    private class ReceivedMessageHolder extends RecyclerView.ViewHolder {
//        TextView messageText, timeText, nameText;
//
//        ReceivedMessageHolder(View itemView) {
//            super(itemView);
//
//            messageText = itemView.findViewById(R.id.text_message_body);
//            timeText = itemView.findViewById(R.id.text_message_time);
//            nameText = itemView.findViewById(R.id.text_message_name);
//        }
//
//        void bind(Message message) {
//            messageText.setText(message.getMessage());
//
//            timeText.setText(DateUtils.formatDateTime(mContext, message.getCreatedAt(), 0));
//
//            nameText.setText(message.getSender().getNickname());
//
//        }
//    }
}
