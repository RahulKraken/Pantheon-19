package com.kraken.pantheon19;

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

import java.util.ArrayList;

public class Day3Fragment extends Fragment {
    private RecyclerView recyclerView;
    private EventAdapter adapter;
    private ArrayList<Event> eventsArrayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.activity_day1,container,false);
        recyclerView = rootview.findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        eventsArrayList = new ArrayList<>();
        adapter = new EventAdapter(getContext(), eventsArrayList);
        recyclerView.setAdapter(adapter);
        createListData();
        return rootview;
    }
    private void createListData() {
        Event event = new Event("Event 1", "This is Event 1","1-2 Hours","10:00 A.M");
        eventsArrayList.add(event);
        event = new Event("Event 2", "This is Event 2","1-2 Hours","11:00 A.M");
        eventsArrayList.add(event);
        event = new Event("Event 3", "This is Event 3","1-2 Hours","12:00 P.M");
        eventsArrayList.add(event);
        event = new Event("Event 4", "This is Event 4","1-2 Hours","1:00 P.M");
        eventsArrayList.add(event);
        event = new Event("Event 5", "This is Event 5","1-2 Hours","2:00 P.M");
        eventsArrayList.add(event);
        event = new Event("Event 6", "This is Event 6","1-2 Hours","3:00 P.M");
        eventsArrayList.add(event);
        event = new Event("Event 7", "This is Event 7","1-2 Hours","4:00 P.M");
        eventsArrayList.add(event);
        adapter.notifyDataSetChanged();
    }
}

