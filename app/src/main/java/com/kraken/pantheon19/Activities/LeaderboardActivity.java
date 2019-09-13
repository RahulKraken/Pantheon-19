package com.kraken.pantheon19.Activities;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kraken.pantheon19.Adapters.LeaderBoardRecyclerViewAdapter;
import com.kraken.pantheon19.Entities.SharedThemePref;
import com.kraken.pantheon19.Entities.Team;
import com.kraken.pantheon19.MyApplication;
import com.kraken.pantheon19.R;
import com.kraken.pantheon19.Utils.Constants;
import com.kraken.pantheon19.Utils.Serializer;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = "LeaderBoardTeamActivity";

    private RecyclerView recyclerView;
    private List<Team> teams = new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshLayout;
    private LeaderBoardRecyclerViewAdapter adapter;
    SharedThemePref sharedThemePref;
    CoordinatorLayout lbLayout;
    Toolbar toolbar;
    TextView coming_soon_lb;
    boolean isDark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        // setup swipe refresh
        //swipeRefreshLayout = findViewById(R.id.leader_board_swipe_refresh_layout);
        //swipeRefreshLayout.setColorSchemeResources(R.color.md_red_500, R.color.md_green_500, R.color.md_blue_500, R.color.md_yellow_500);
        //swipeRefreshLayout.setOnRefreshListener(this);

        // adding app bar
        coming_soon_lb=findViewById(R.id.comingsoon_lb);
        lbLayout=findViewById(R.id.lb_list_layout);
        toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Leader Board");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        sharedThemePref=new SharedThemePref();

        //set theme
        isDark = sharedThemePref.getThemeStatePref(this);
        if(isDark) setDarkTheme();
        else setLightTheme();

        //recyclerView = findViewById(R.id.lb_recycler_view);

        setupRecyclerView();

        // trigger a refresh
//        swipeRefreshLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                swipeRefreshLayout.setRefreshing(true);
//                onRefresh();
//            }
//        });
    }

    @Override
    public void onRefresh() {
        Toast.makeText(this, "Refreshing", Toast.LENGTH_SHORT).show();
        StringRequest request = new StringRequest(Request.Method.GET, Constants.LEADERBOARD_API, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: 200 OK\n" + response);
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(LeaderboardActivity.this, "Updated leaderboard", Toast.LENGTH_SHORT).show();

                // serialize the list of teams
                teams.clear();
                teams = Serializer.serializeTeams(response);
                Log.d(TAG, "onResponse: " + teams.toString());
                Log.d(TAG, "onResponse: " + teams.size());
                adapter.setList(teams);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: " + error);
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(LeaderboardActivity.this, "Failed to update leaderboard", Toast.LENGTH_SHORT).show();
            }
        });

        MyApplication.getVolleyRequestQueue().add(request);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Log.d(TAG, "onSupportNavigateUp: back pressed");
        finish();
        return true;
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new LeaderBoardRecyclerViewAdapter(this, teams);

        // set on recycler view
        Log.d(TAG, "setupRecyclerView: inflating recycler view");
        //recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setAdapter(adapter);
    }

    public void setDarkTheme() {
        lbLayout.setBackgroundColor(getResources().getColor(R.color.md_black_1000));
        coming_soon_lb.setTextColor(getResources().getColor(R.color.md_white_1000));
        toolbar.setTitleTextColor(getResources().getColor(R.color.md_white_1000));
        toolbar.setBackgroundColor(getResources().getColor(R.color.md_black_1000));
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP);
    }

    public void setLightTheme() {
        lbLayout.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
        coming_soon_lb.setTextColor(getResources().getColor(R.color.md_black_1000));
        toolbar.setTitleTextColor(getResources().getColor(R.color.md_black_1000));
        toolbar.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.md_black_1000), PorterDuff.Mode.SRC_ATOP);
    }
}
