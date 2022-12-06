package com.example.android_appv2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android_appv2.Adapter.ClubPostAdapter;
import com.example.android_appv2.Adapter.PostAdapter;
import com.example.android_appv2.Model.ClubPostModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ActualClubHome extends AppCompatActivity implements View.OnClickListener {


    FloatingActionButton addPostButton;

    FirebaseAuth auth;

    RecyclerView recyclerView;
    ClubPostAdapter clubPostAdapter;
    List<ClubPostModel> clubPostModelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_club_home);

        auth = FirebaseAuth.getInstance();
        recyclerView = findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);

        recyclerView.setLayoutManager(layoutManager);


        clubPostModelList = new ArrayList<>();
        
        loadPosts();


        addPostButton = (FloatingActionButton) findViewById(R.id.addPostClub);
        addPostButton.setOnClickListener(this);

    }

    private void loadPosts() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("ClubPosts");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                clubPostModelList.clear();
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    ClubPostModel clubPostModel = ds.getValue(ClubPostModel.class);
                    clubPostModelList.add(clubPostModel);
                    clubPostAdapter = new ClubPostAdapter(ActualClubHome.this,clubPostModelList);
                    recyclerView.setAdapter(clubPostAdapter);
                    clubPostAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ActualClubHome.this,"Error retrieving data",Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addPostClub:
                startActivity(new Intent(this,ActualCreateClubPost.class));
                break;
        }
    }

}