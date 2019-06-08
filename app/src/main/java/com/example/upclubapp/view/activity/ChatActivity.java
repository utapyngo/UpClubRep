package com.example.upclubapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.upclubapp.R;
import com.example.upclubapp.adapters.MessagesRecyclerViewAdapter;
import com.example.upclubapp.model.Chat;
import com.example.upclubapp.model.Message;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChatActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvName)
    TextView tvName;

    @BindView(R.id.ivImage)
    ImageView ivImage;

    @BindView(R.id.etText)
    EditText etText;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setTitle("");
        tvName.setText(String.valueOf(getChat().getReceiver()));
        Glide.with(this).load(getChat().getUrlImage()).into(ivImage);

        FirebaseFirestore.getInstance().collection("chats")
                .document(getChat().getId()).collection("messages")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots,
                                        @Nullable FirebaseFirestoreException e) {
                        List<Message> list = new ArrayList<>();
                        if (queryDocumentSnapshots != null) {
                            for (DocumentSnapshot ds : queryDocumentSnapshots) {
                                list.add(ds.toObject(Message.class));
                            }
                        }
                        recyclerView.setLayoutManager(new LinearLayoutManager(ChatActivity.this));
                        recyclerView.setAdapter(new MessagesRecyclerViewAdapter(list));
                    }
                });
    }

    @OnClick(R.id.ibSend)
    void onClick() {
        if (!etText.getText().toString().equals("")) {
            DocumentReference fs = FirebaseFirestore.getInstance().collection("chats")
                    .document(getChat().getId()).collection("messages")
                    .document();
            Message message = new Message();
            message.setId(fs.getId());
            message.setMessage(etText.getText().toString());
            message.setReceiver(getChat().getReceiver());
            message.setSender(getChat().getSender());
            fs.set(message);
            etText.setText("");
        }
    }

    private Chat getChat() {
        return new Chat(Objects.requireNonNull(getIntent().getExtras()));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
