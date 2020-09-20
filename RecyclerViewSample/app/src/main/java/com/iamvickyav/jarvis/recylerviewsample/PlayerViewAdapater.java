package com.iamvickyav.jarvis.recylerviewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class PlayerViewAdapater extends RecyclerView.Adapter<PlayerViewHolder> {

    List<Player> playerList;
    Context context;

    PlayerViewAdapater(Context context, List<Player> players){
        this.playerList = players;
        this.context = context;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_list_item, viewGroup, false);
        PlayerViewHolder playerViewHolder = new PlayerViewHolder(view);
        return playerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder playerViewHolder, int i) {

        playerViewHolder.imageView.setImageResource(R.mipmap.ic_launcher_round);
        playerViewHolder.name.setText(playerList.get(i).name);
        playerViewHolder.battingStyle.setText(playerList.get(i).battingStyle);
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }
}
