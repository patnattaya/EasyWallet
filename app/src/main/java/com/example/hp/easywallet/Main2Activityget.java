package com.example.hp.easywallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activityget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_activityget);

        Bundle bundle = getIntent().getExtras();

    }
}
