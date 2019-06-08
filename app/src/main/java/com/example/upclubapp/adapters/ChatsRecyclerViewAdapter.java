package com.example.upclubapp.adapters;

import android.text.Layout;
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
import com.example.upclubapp.model.Chat;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatsRecyclerViewAdapter
        extends RecyclerView.Adapter<ChatsRecyclerViewAdapter.ChatViewHolder> {

    private List<Chat> mData;
    private OnClickModel<Chat> mClickListener;

    public ChatsRecyclerViewAdapter(List<Chat> mData, OnClickModel<Chat> mClickListener) {
        this.mData = mData;
        this.mClickListener = mClickListener;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChatViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_chat, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        Chat chat = mData.get(position);
        Glide.with(holder.ivImage.getContext())
                .load(chat.getUrlImage())
                .into(holder.ivImage);
        holder.tvName.setText(String.valueOf(chat.getReceiver()));
        holder.tvMessage.setText(chat.getLastMessage());
        holder.cardView.setOnClickListener(view -> mClickListener.onClick(chat));
        holder.cardView.setOnLongClickListener(view -> {
            mClickListener.onLongClick(chat);
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ChatViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cardView)
        CardView cardView;

        @BindView(R.id.ivImage)
        ImageView ivImage;

        @BindView(R.id.tvName)
        TextView tvName;

        @BindView(R.id.tvMessage)
        TextView tvMessage;

        ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
