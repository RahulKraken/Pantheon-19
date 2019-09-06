package com.kraken.pantheon19.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.kraken.pantheon19.Adapters.EventsRecyclerViewAdapter;
import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.R;
import java.util.ArrayList;
import java.util.List;

public class Day2Fragment extends Fragment {

    private static final String TAG = "Day2Fragment";
    private RecyclerView recyclerView;
    private List<Event> events;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.activity_day2,container,false);
        recyclerView = rootview.findViewById(R.id.recyclerView2);
        setupEventList();
        setupRecyclerView();
        return rootview;
    }

    private void setupEventList() {
        events = new ArrayList<>();
        events.add(new Event(85, "madarchod", "bhosdika", "lauda", "gandu","10",
                "betichod", 2, 4, "bhosdiwala",""));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl","10",
                "kldsj", 2, 4, "lkfsjdflks",""));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl","10",
                "kldsj", 2, 4, "lkfsjdflks",""));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl","10",
                "kldsj", 2, 4, "lkfsjdflks",""));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl","10",
                "kldsj", 2, 4, "lkfsjdflks",""));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl","10",
                "kldsj", 2, 4, "lkfsjdflks",""));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl","10",
                "kldsj", 2, 4, "lkfsjdflks",""));
    }

    private void setupRecyclerView() {
        EventsRecyclerViewAdapter adapter = new EventsRecyclerViewAdapter(getContext(), events);

        // set on recycler view
        Log.d(TAG, "setupRecyclerView: inflating events recycler view");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        // snap behavior for recycler view
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
    }
}