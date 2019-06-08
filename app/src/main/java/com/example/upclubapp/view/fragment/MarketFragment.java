package com.example.upclubapp.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.upclubapp.R;
import com.example.upclubapp.adapters.EventsRecyclerViewAdapter;
import com.example.upclubapp.interfaces.OnClickModel;
import com.example.upclubapp.model.Event;
import com.example.upclubapp.view.activity.AddNewEventActivity;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MarketFragment extends Fragment
        implements OnClickModel<Event> {
    public MarketFragment() {
        // Required empty public constructor
    }

    private Unbinder unbinder;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_market, container, false);

        unbinder = ButterKnife.bind(this, view);

        FirebaseFirestore.getInstance().collection("events")
                .addSnapshotListener((queryDocumentSnapshots, e) -> {
                    List<Event> list = new ArrayList<>();
                    if (queryDocumentSnapshots != null) {
                        for (DocumentSnapshot ds : queryDocumentSnapshots) {
                            list.add(ds.toObject(Event.class));
                        }
                    }
                    recyclerView.setAdapter(new EventsRecyclerViewAdapter(list, MarketFragment.this));
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                });

        return view;
    }

    @OnClick(R.id.fabAddNewEvent)
    void onClick() {
        Intent intent = new Intent(getActivity(), AddNewEventActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(Event model) {

    }

    @Override
    public void onLongClick(Event model) {

    }
}
