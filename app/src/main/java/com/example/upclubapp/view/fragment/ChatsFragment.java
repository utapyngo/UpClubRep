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
import android.widget.ProgressBar;

import com.example.upclubapp.R;
import com.example.upclubapp.adapters.ChatsRecyclerViewAdapter;
import com.example.upclubapp.interfaces.OnClickModel;
import com.example.upclubapp.model.Chat;
import com.example.upclubapp.view.activity.ChatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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

public class ChatsFragment extends Fragment  implements OnClickModel<Chat> {
    public ChatsFragment() {
        // Required empty public constructor
    }

    private Unbinder unbinder;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chats, container, false);

        unbinder = ButterKnife.bind(this, view);

        progressBar.setVisibility(View.VISIBLE);
        FirebaseFirestore.getInstance().collection("chats")
                .addSnapshotListener((queryDocumentSnapshots, e) -> {
                    List<Chat> list = new ArrayList<>();
                    if (queryDocumentSnapshots != null) {
                        for (DocumentSnapshot query : queryDocumentSnapshots) {
                            list.add(query.toObject(Chat.class));
                        }
                    }
                    progressBar.setVisibility(View.INVISIBLE);
                    initRecyclerView(list);
                });

        return view;
    }

    private void initRecyclerView(List<Chat> data) {
        ChatsRecyclerViewAdapter adapter =
                new ChatsRecyclerViewAdapter(data, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onClick(Chat model) {
        Intent intent = new Intent(getActivity(), ChatActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLongClick(Chat model) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
