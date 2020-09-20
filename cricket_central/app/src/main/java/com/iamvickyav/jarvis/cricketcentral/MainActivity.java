package com.iamvickyav.jarvis.cricketcentral;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        String[] countries = {"India", "Australia", "New Zeland", "South Africa", "Pakistan",
            "Srilanka", "Bangladesh", "Afghanistan", "Ireland", "England", "West Indies", "Scotland",
            "UAE", "Kenya", "Nabibia", "Netherland", "USA" , "Zimbabwe", "Hong Kong", "Hong Kong",
            "Nepal", "Malaysia", "Myanmar", "Philippines", "Namibia", "Zambia",
            "Tanzania", "Singapore"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.listview_element, countries);
        listView.setAdapter(arrayAdapter);


        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int firstElement, int i1, int i2) {

                if(firstElement>2){
                    floatingActionButton.setVisibility(View.VISIBLE);
                } else {
                    floatingActionButton.setVisibility(View.GONE);
                }
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setSelection(0);
            }
        });
    }
}
