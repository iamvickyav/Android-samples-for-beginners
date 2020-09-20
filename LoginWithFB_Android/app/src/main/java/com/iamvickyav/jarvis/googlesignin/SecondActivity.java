package com.iamvickyav.jarvis.googlesignin;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Intent intent = getIntent();
        if(intent != null) {
            FBResponse fbResponse = (FBResponse) intent.getSerializableExtra("fb_response");
            Toast.makeText(this, fbResponse.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
