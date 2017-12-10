package com.example.hp.easywallet;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.hp.easywallet.adapter.PayListAdapter;
import com.example.hp.easywallet.db.PayDbHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  private Button mGet;
  private Button mPay;
    private PayDbHelper mHelper;
    private SQLiteDatabase mDb;

    private ArrayList<PayItem> mPayItemList = new ArrayList<>();
    private PayListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelper = new PayDbHelper(this);
        mDb = mHelper.getReadableDatabase();


        mGet = findViewById(R.id.get_button);
        mPay = findViewById(R.id.pay_button);


        mGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activityget.class);
                startActivity(intent);
            }
        });
        mPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activitypay.class);
                startActivity(intent);
            }
        });


    }
}
