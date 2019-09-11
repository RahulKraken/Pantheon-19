package com.kraken.pantheon19.Adapters;
/*
 * created by RahulKraken on 08-09-2019 at 20:00.
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kraken.pantheon19.Entities.Team;
import com.kraken.pantheon19.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class LeaderBoardRecyclerViewAdapter extends RecyclerView.Adapter<LeaderBoardRecyclerViewAdapter.LeaderBoardRecyclerViewHolder> {
    private static final String TAG = "LeaderBoardRecyclerView";

    private Context context;
    private List<Team> teamList;

    public LeaderBoardRecyclerViewAdapter(Context context, List<Team> teamList) {
        this.context = context;
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public LeaderBoardRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row_leaderboard, parent, false);
        return new LeaderBoardRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderBoardRecyclerViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: binding values to views");
        holder.lbcard.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_scale_animation));
        holder.teamName.setText(teamList.get(position).getTeamName());
        holder.teamPos.setText(String.valueOf(teamList.get(position).getTeamPos()));
        holder.teamScore.setText(String.valueOf(teamList.get(position).getTeamScore()));

        switch (teamList.get(position).getTeamPos()) {
            case 1:
                holder.teamPos.setVisibility(View.INVISIBLE);
                holder.posImg.setVisibility(View.VISIBLE);
                holder.posImg.setImageResource(R.drawable.one);
                break;
            case 2:
                holder.teamPos.setVisibility(View.INVISIBLE);
                holder.posImg.setVisibility(View.VISIBLE);
                holder.posImg.setImageResource(R.drawable.two);
                break;
            case 3:
                holder.teamPos.setVisibility(View.INVISIBLE);
                holder.posImg.setVisibility(View.VISIBLE);
                holder.posImg.setImageResource(R.drawable.three);
                break;
                default:
                    holder.posImg.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public void setList(List<Team> teams) {
        teamList = teams;
        notifyDataSetChanged();
    }

    class LeaderBoardRecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView teamPos, teamName, teamScore;
        CircleImageView posImg;
        LinearLayout lbcard;

        LeaderBoardRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.team_name);
            teamPos = itemView.findViewById(R.id.team_pos);
            teamScore = itemView.findViewById(R.id.team_score);
            lbcard=itemView.findViewById(R.id.lb_layout);
            posImg = itemView.findViewById(R.id.pos_img_view);
        }
    }
}
