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
import com.example.upclubapp.model.Event;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventsRecyclerViewAdapter
        extends RecyclerView.Adapter<EventsRecyclerViewAdapter.EventViewHolder> {

    private List<Event> mData;
    private OnClickModel<Event> mClickListener;

    public EventsRecyclerViewAdapter(List<Event> mData, OnClickModel<Event> mClickListener) {
        this.mData = mData;
        this.mClickListener = mClickListener;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EventViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_event, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = mData.get(position);
        holder.tvTitle.setText(String.valueOf(event.getTitle()));
        holder.tvDescription.setText(event.getDescription());
        holder.tvAddress.setText(event.getAddress());
        holder.cardView.setOnClickListener(view -> mClickListener.onClick(event));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class EventViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cardView)
        CardView cardView;

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        @BindView(R.id.tvDescription)
        TextView tvDescription;

        @BindView(R.id.tvAddress)
        TextView tvAddress;

        EventViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
