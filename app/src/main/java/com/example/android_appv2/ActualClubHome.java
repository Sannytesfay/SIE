package com.example.android_appv2;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class ActualClubHome extends AppCompatActivity implements View.OnClickListener {

    ImageButton addPostButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_club_home);

        addPostButton = (ImageButton) findViewById(R.id.addPostClub);
        addPostButton.setOnClickListener(this);
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