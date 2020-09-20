package com.iamvickyav.jarvis.recylerviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);

        Player s1 = new Player("S Dhawan", "L Batsman");
        Player s2 = new Player("R Sharma", "R Batsman");
        Player s3 = new Player("V Kohli", "R Batsman");
        Player s4 = new Player("KL Rahul", "R Batsman");
        Player s5 = new Player("S Raina", "L Batsman");
        Player s6 = new Player("MS Dhoni", "R Batsman");
        Player s7 = new Player("H Pandya", "R Batsman");
        Player s8 = new Player("U Yadav", "R Batsman");
        Player s9 = new Player("K Yadav", "L Batsman");
        Player s10 = new Player("I Sharma", "R Batsman");
        Player s11 = new Player("J Bumrah", "R Batsman");

        List<Player> playerList = new ArrayList<>();
        playerList.add(s1);
        playerList.add(s2);
        playerList.add(s3);
        playerList.add(s4);
        playerList.add(s5);
        playerList.add(s6);
        playerList.add(s7);
        playerList.add(s8);

        PlayerViewAdapater playerViewAdapater = new PlayerViewAdapater(this, playerList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(playerViewAdapater);
    }
}
