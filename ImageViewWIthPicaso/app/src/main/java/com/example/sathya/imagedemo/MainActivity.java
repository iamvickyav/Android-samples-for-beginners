package com.example.sathya.imagedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    String url = "https://i.pinimg.com/564x/b2/45/37/b24537a5a41ca67dacfec5f3c2655ef9.jpg";
    Float angle = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        imageView = findViewById(R.id.imageView);

        loadImage(url, imageView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.rotate_right:
                loadImageWithRotation(url, 90f, imageView);
                return true;
            case R.id.rotate_left:
                loadImageWithRotation(url, 270f, imageView);
                return true;
        }
        return (super.onOptionsItemSelected(item));
    }

    private void loadImage(String url, ImageView imageView) {
        Picasso.with(this)
                .load(url)
                .resize(1200, 1400)
                .into(imageView);
    }

    private void loadImageWithRotation(String url, Float rotation, ImageView imageView) {
        angle += rotation;
        Picasso.with(this)
                .load(url)
                .resize(1200, 1400)
                .rotate(angle)
                .into(imageView);
    }
}
