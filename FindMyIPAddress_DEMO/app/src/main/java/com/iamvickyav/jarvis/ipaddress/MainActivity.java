package com.iamvickyav.jarvis.ipaddress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ip = findViewById(R.id.ip);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.ipify.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IPService ipService = retrofit.create(IPService.class);
        ipService.getMyIp().enqueue(new Callback<IPAddress>() {
            @Override
            public void onResponse(Call<IPAddress> call, Response<IPAddress> response) {
                IPAddress ipAddress = response.body();
                ip.setText(ipAddress.ip);
            }

            @Override
            public void onFailure(Call<IPAddress> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Connection error",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
