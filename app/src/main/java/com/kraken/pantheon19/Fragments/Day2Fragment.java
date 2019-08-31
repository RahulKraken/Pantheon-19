package com.kraken.pantheon19.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kraken.pantheon19.Events.Event;
import com.kraken.pantheon19.Events.EventAdapter;
import com.kraken.pantheon19.R;
import java.util.ArrayList;

public class Day2Fragment extends Fragment {

    private RecyclerView recyclerView;
    private EventAdapter adapter;
    private ArrayList<Event> eventsArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.activity_day2,container,false);
        recyclerView = rootview.findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        eventsArrayList = new ArrayList<>();
        adapter = new EventAdapter(getContext(), eventsArrayList);
        recyclerView.setAdapter(adapter);
        createListData();
        return rootview;
    }
    private void createListData() {
        Event event = new Event("Event 1", "This is Event 1","10","20");
        eventsArrayList.add(event);
        event = new Event("Event 2", "This is Event 2","10","20");
        eventsArrayList.add(event);
        event = new Event("Event 3", "This is Event 3","10","20");
        eventsArrayList.add(event);
        event = new Event("Event 4", "This is Event 4","10","20");
        eventsArrayList.add(event);
        event = new Event("Event 5", "This is Event 5","10","20");
        eventsArrayList.add(event);
        event = new Event("Event 6", "This is Event 6","10","20");
        eventsArrayList.add(event);
        event = new Event("Event 7", "This is Event 7","10","20");
        eventsArrayList.add(event);
        event = new Event("Event 8", "This is Event 7","10","20");
        eventsArrayList.add(event);
        event = new Event("Event 9", "This is Event 7","10","20");
        eventsArrayList.add(event);
        event = new Event("Event 10", "This is Event 7","10","20");
        eventsArrayList.add(event);
        event = new Event("Event 11", "This is Event 7","10","20");
        eventsArrayList.add(event);
        event = new Event("Event 12", "This is Event 7","10","20");
        eventsArrayList.add(event);
        event = new Event("Event 13", "This is Event 7","10","20");
        eventsArrayList.add(event);
        event = new Event("Event 14", "This is Event 7","10","20");
        eventsArrayList.add(event);
        event = new Event("Event 15", "This is Event 7","10","20");
        eventsArrayList.add(event);
        event = new Event("Event 16", "This is Event 7","10","20");
        eventsArrayList.add(event);
        adapter.notifyDataSetChanged();
    }
}