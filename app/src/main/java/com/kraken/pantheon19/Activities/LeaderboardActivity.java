package com.kraken.pantheon19.Activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.kraken.pantheon19.Adapters.LeaderBoardRecyclerViewAdapter;
import com.kraken.pantheon19.Entities.Team;
import com.kraken.pantheon19.R;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = "LeaderBoardTeamActivity";
    private RecyclerView recyclerView;
    private List<Team> teams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        // setup swipe refresh
        SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.leader_board_swipe_refresh_layout);
        swipeRefreshLayout.setColorSchemeResources(R.color.md_red_500, R.color.md_green_500, R.color.md_blue_500, R.color.md_yellow_500);
        swipeRefreshLayout.setOnRefreshListener(this);

        // adding app bar
        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Leader Board");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        recyclerView = findViewById(R.id.lb_recycler_view);

        setupTeamList();
        setupRecyclerView();
    }

    @Override
    public void onRefresh() {
        // TODO : fetch latest leader board
        Toast.makeText(this, "Refreshing", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        Log.d(TAG, "onSupportNavigateUp: back pressed");
        finish();
        return true;
    }

    /*
    create list of events
    TODO : replace with repository call
     */
    private void setupTeamList() {
        teams = new ArrayList<>();
        teams.add(new Team(85, "amit", "10", "20"));
        teams.add(new Team(85, "1madarchod", "10", "20"));
        teams.add(new Team(85, "2madarchod", "10", "20"));
        teams.add(new Team(85, "3madarchod", "10", "20"));
        teams.add(new Team(85, "4madarchod", "10", "20"));
        teams.add(new Team(85, "5madarchod", "10", "20"));
        teams.add(new Team(85, "6madarchod", "10", "20"));
        teams.add(new Team(85, "7madarchod", "10", "20"));
        teams.add(new Team(85, "8madarchod", "10", "20"));
        teams.add(new Team(85, "9madarchod", "10", "20"));
        teams.add(new Team(85, "0madarchod", "10", "20"));
        teams.add(new Team(85, "1madarchod", "10", "20"));
        teams.add(new Team(85, "2madarchod", "10", "20"));
        teams.add(new Team(85, "3madarchod", "10", "20"));
        teams.add(new Team(85, "4madarchod", "10", "20"));
        teams.add(new Team(85, "5madarchod", "10", "20"));
        teams.add(new Team(85, "6madarchod", "10", "20"));
        teams.add(new Team(85, "7madarchod", "10", "20"));
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        LeaderBoardRecyclerViewAdapter adapter = new LeaderBoardRecyclerViewAdapter(this, teams);

        // set on recycler view
        Log.d(TAG, "setupRecyclerView: inflating recycler view");
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
