package com.iamvickyav.jarvis.mobileno_data;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText mobileNo;
    Button submit;
    TextView no, series, state, provider, service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileNo = findViewById(R.id.mobile_no);
        submit = findViewById(R.id.submit);
        no = findViewById(R.id.no);
        series = findViewById(R.id.series);
        state = findViewById(R.id.state);
        provider = findViewById(R.id.provider);
        service = findViewById(R.id.service);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = mobileNo.getText().toString();
                callRetro(number);
            }
        });
    }

    void callRetro(String number){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ajith-indian-mob-info.p.mashape.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        MobileDataService mobileDataService = retrofit.create(MobileDataService.class);
        mobileDataService.getMobileData("DUMMY_MASHAPE_CODE",number).enqueue(new Callback<MobileData>() {
            @Override
            public void onResponse(Call<MobileData> call, Response<MobileData> response) {
                MobileData mobileData = response.body();
                no.setText(mobileData.Number);
                series.setText(mobileData.Series);
                state.setText(mobileData.State);
                provider.setText(mobileData.Provider);
                service.setText(mobileData.Service);
            }

            @Override
            public void onFailure(Call<MobileData> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Connection Issue", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
