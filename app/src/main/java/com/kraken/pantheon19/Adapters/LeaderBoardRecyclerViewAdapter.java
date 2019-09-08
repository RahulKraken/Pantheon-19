package com.kraken.pantheon19.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kraken.pantheon19.Entities.Team;
import com.kraken.pantheon19.R;

import java.util.List;


public class LeaderBoardRecyclerViewAdapter extends RecyclerView.Adapter<LeaderBoardRecyclerViewAdapter.LeaderBoardRecyclerViewHolder> {
    private static final String TAG = "LBRVA";

    private Context context;
    private List<Team> teamList;

    public LeaderBoardRecyclerViewAdapter(Context context, List<Team> teamList) {
        this.context = context;
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public LeaderBoardRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row_lb, parent, false);
        return new LeaderBoardRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderBoardRecyclerViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: binding values to views");
        holder.teamName.setText(teamList.get(position).getTeamName());
        //holder.teamPos.setText(teamList.get(position).getTeamPos());
        holder.teamScore.setText(teamList.get(position).getTeamScore());
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    class LeaderBoardRecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView teamPos,teamName,teamScore;

        LeaderBoardRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.teamName);
            //teamPos = itemView.findViewById(R.id.teamPos);
            teamScore=itemView.findViewById(R.id.points_scored);
        }
    }
}
