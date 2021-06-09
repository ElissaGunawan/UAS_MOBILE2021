package umn.ac.id.uasproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class HistoryActivity extends AppCompatActivity implements HistoryAdapter.OnClickedHistory {
    ImageView btnback;
    TextView histtitle;
    RecyclerView recyclerView;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    DocumentReference reference;
    private HistoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        getSupportActionBar().hide();

        btnback = findViewById(R.id.btnback);
        histtitle = findViewById(R.id.histtitle);
        recyclerView = findViewById(R.id.recyclerview);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();
        reference = fStore.collection("users").document(userID);
        Query query = fStore.collection("users");

        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(6).setPageSize(3)
                .build();

        FirestorePagingOptions<HistoryModel> options = new FirestorePagingOptions.Builder<HistoryModel>()
                .setLifecycleOwner(this)
                .setQuery(query, config, HistoryModel.class)
                .build();

//        setOnclickListener();
        adapter = new HistoryAdapter(options, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HistoryActivity.this, HomeActivity.class));
            }
        });
    }

    @Override
    public void onItemClick(DocumentSnapshot snapshot, int position) {
        Log.d("Item Clicked", "clicked" + position + "ID : " + snapshot.getId());
    }
}