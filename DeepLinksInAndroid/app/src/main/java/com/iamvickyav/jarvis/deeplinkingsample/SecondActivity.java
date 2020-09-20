package com.iamvickyav.jarvis.deeplinkingsample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        textView = findViewById(R.id.linkClicked);

        Intent intent = getIntent();
        if(intent != null) {
            Uri uri = intent.getData();
            textView.setText(uri.toString());
        }
    }
}
