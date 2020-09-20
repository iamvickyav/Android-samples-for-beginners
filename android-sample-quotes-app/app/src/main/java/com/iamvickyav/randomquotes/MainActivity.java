package com.iamvickyav.randomquotes;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView t1;
    SwipeRefreshLayout swipeLayout;
    FloatingActionButton floatingActionButton;

    static Boolean isNight = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(isNight)
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        else
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (TextView) findViewById(R.id.quote_textview);
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setImageResource(isNight? R.mipmap.day:R.mipmap.night);

        getQuote("http://quotesondesign.com/wp-json/posts?filter[orderby]=rand");

        if(savedInstanceState != null) {
            t1.setText(savedInstanceState.get("Quote").toString());
        }


        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getQuote("http://quotesondesign.com/wp-json/posts?filter[orderby]=rand");
                swipeLayout.setRefreshing(false);
            }
        });

        floatingActionButton.setOnClickListener(new FloatingActionButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                isNight = !isNight;
                recreate();
            }
        });

    }

    private void getQuote(String url) {

        OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                updateUIWithError(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                Quotes[] quotesArray = gson.fromJson(response.body().charStream(), Quotes[].class);
                updateUI(quotesArray[0].content);
            }
        });
    }

    public void updateUI(final String content){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                t1.setText(Html.fromHtml(content));
            }
        });
    }


    public void updateUIWithError(final Exception e){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Error " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putString("Quote", t1.getText().toString());

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }
}
