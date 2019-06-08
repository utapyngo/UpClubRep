package com.example.upclubapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.upclubapp.R;
import com.example.upclubapp.interfaces.OnClickModel;
import com.example.upclubapp.model.Message;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessagesRecyclerViewAdapter
        extends RecyclerView.Adapter<MessagesRecyclerViewAdapter.MessageViewHolder> {

    private final static int SENDER = 0;
    private final static int RECEIVER = 1;

    private List<Message> mData;

    public MessagesRecyclerViewAdapter(List<Message> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case SENDER: {
                return new MessageViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_sender, parent, false));
            }
            case RECEIVER: {
                return new MessageViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_receiver, parent, false));
            }
            default: {
                throw new RuntimeException("Unsupported type");
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = mData.get(position);
        holder.tvMessage.setText(message.getMessage());
    }

    @Override
    public int getItemViewType(int position) {
        return SENDER;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MessageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cardView)
        CardView cardView;

        @BindView(R.id.tvText)
        TextView tvMessage;

        MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
