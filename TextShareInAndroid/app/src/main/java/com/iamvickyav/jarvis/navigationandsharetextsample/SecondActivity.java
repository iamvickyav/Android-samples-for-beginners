package com.iamvickyav.jarvis.navigationandsharetextsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        textView = findViewById(R.id.textShared);

        Intent intent = getIntent();
        if(intent != null) {
            String data = intent.getStringExtra("mydata");
            textView.setText(data);
        }
    }
}
