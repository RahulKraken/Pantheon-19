package com.kraken.pantheon19.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kraken.pantheon19.R;
import com.kraken.pantheon19.Speakers.Speaker;
import com.kraken.pantheon19.Speakers.SpeakerAdapter;
import java.util.ArrayList;
import java.util.Random;

public class SpeakerFragment extends Fragment {

    private RecyclerView recyclerView;
    private SpeakerAdapter adapter;
    private ArrayList<Speaker> speakersArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.activity_speakers_list,container,false);
        recyclerView = rootview.findViewById(R.id.recyclerView12);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        speakersArrayList = new ArrayList<>();
        adapter = new SpeakerAdapter(getContext(), speakersArrayList);
        recyclerView.setAdapter(adapter);
        createListData();
        return rootview;
    }

    private String setRandomColor() {
        Random r=new Random();
        int rand=r.nextInt(5 - 1)+1;
        if(rand==1) return "#4fC3F7"; //blue
        else if(rand==2) return "#76FF03"; //green
        else if(rand==3) return "#FFFF00"; //yellow
        else if(rand==4) return "#FFA726"; //orange
        else return "#FFFFFF";
    }

    private void createListData() {
        Speaker speaker = new Speaker("Amit Dutta", "Heart hacker","10","20",
                setRandomColor());
        speakersArrayList.add(speaker);
        speaker = new Speaker("Amit Dutta", "Heart hacker","10","20",setRandomColor());
        speakersArrayList.add(speaker);
        speaker = new Speaker("Amit Dutta", "Heart hacker","10","20",setRandomColor());
        speakersArrayList.add(speaker);
        speaker = new Speaker("Amit Dutta", "Heart hacker","10","20",setRandomColor());
        speakersArrayList.add(speaker);
        speaker = new Speaker("Amit Dutta", "Heart hacker","10","20",setRandomColor());
        speakersArrayList.add(speaker);
        speaker = new Speaker("Amit Dutta", "Heart hacker","10","20",setRandomColor());
        speakersArrayList.add(speaker);
        speaker = new Speaker("Amit Dutta", "Heart hacker","10","20",setRandomColor());
        speakersArrayList.add(speaker);
        speaker = new Speaker("Amit Dutta", "Heart hacker","10","20",setRandomColor());
        speakersArrayList.add(speaker);
        adapter.notifyDataSetChanged();
    }
}