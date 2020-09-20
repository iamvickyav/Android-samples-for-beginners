package com.iamvickyav.randomquote;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    TextView quoteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        quoteText = (TextView) findViewById(R.id.quote);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://quotesondesign.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                QuoteService quoteService = retrofit.create(QuoteService.class);
                quoteService.getRandomQuote().enqueue(new Callback<List<Quote>>() {
                    @Override
                    public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                        List<Quote> quoteList = response.body();
                        quoteText.setText(quoteList.get(0).content);
                    }

                    @Override
                    public void onFailure(Call<List<Quote>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
