package com.iamvickyav.jarvis.navigationandsharetextsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText textToShare;
    Button navigate, share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textToShare = findViewById(R.id.shareText);
        navigate = findViewById(R.id.navigate);
        share = findViewById(R.id.share);

        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = textToShare.getText().toString();
                // Navigate to Another Activity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("mydata", data);
                startActivity(intent);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = textToShare.getText().toString();

                // Share Text to other apps
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, data);
                intent.setType("text/plain");

                // Share JPEG Image to other apps
                //intent.setType("image/jpeg");

                // Share Any Image format to other apps
                //intent.setType("image/*");
                startActivity(intent);
            }
        });
    }
}
