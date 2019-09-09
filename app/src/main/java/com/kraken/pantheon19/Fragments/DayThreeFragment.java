package com.kraken.pantheon19.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kraken.pantheon19.Adapters.EventsRecyclerViewAdapter;
import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.R;
import com.kraken.pantheon19.ViewModels.EventActivityViewModel;

import java.util.List;

public class DayThreeFragment extends Fragment {
    private static final String TAG = "DayThreeFragment";

    private RecyclerView recyclerView;
    private EventsRecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_day_three, container, false);
        recyclerView = v.findViewById(R.id.day_three_recycler_view);
        initRecyclerView();

        // live data setup
        EventActivityViewModel viewModel = ViewModelProviders.of(this).get(EventActivityViewModel.class);

        // now observe data
        viewModel.getEventList(3).observe(this, new Observer<List<Event>>() {
            @Override
            public void onChanged(List<Event> events) {
                Log.d(TAG, "onChanged: " + events.toString());
                adapter.setEvents(events);
            }
        });

        return v;
    }

    private void initRecyclerView() {
        adapter = new EventsRecyclerViewAdapter(getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}