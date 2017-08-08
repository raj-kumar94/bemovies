package com.example.raj.bemovies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by raj on 08-Aug-17.
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatHolder> {
    Context mContext;
    ArrayList<Chat> chatObjects;

    public ChatAdapter(Context mContext, ArrayList<Chat> chatObjects) {
        this.mContext = mContext;
        this.chatObjects = chatObjects;
    }

    @Override
    public ChatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.chat_items,parent,false);
        return new ChatHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatHolder holder, int position) {
        //code
        holder.userName.setText(chatObjects.get(position).getUserID());
        holder.message.setText(chatObjects.get(position).getMesssage());
        holder.timestamp.setText(chatObjects.get(position).getTimestamp());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    // no of itmes to display
    @Override
    public int getItemCount() {
        return chatObjects.size();
    }

    class ChatHolder extends RecyclerView.ViewHolder{

        View v;
        TextView userName;
        TextView message;
        TextView timestamp;
        public ChatHolder(View itemView) {
            super(itemView);
            v=itemView;
            userName = (TextView) itemView.findViewById(R.id.uname);
            message = (TextView) itemView.findViewById(R.id.user_message);
            timestamp = (TextView) itemView.findViewById(R.id.timestamp);
        }
    }
}
