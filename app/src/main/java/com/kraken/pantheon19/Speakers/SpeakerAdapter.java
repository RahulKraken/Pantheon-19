package com.kraken.pantheon19.Speakers;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kraken.pantheon19.R;
import java.util.ArrayList;
import java.util.Random;

class SpeakerHolder extends RecyclerView.ViewHolder {

    private TextView speakerName,speakDes,duration,starttime;
    private View view;

    SpeakerHolder(View itemView) {
        super(itemView);
        view=itemView.findViewById(R.id.underline);
        speakerName = itemView.findViewById(R.id.speaker_name);
        speakDes = itemView.findViewById(R.id.speaker_description);
        duration=itemView.findViewById(R.id.speakers_venue);
        starttime=itemView.findViewById(R.id.speakers_start_time);
    }

    void setDetails(Speaker speaker) {
        view.setBackgroundColor(Color.parseColor(speaker.getColor()));
        speakerName.setText(speaker.getSpeakerName());
        speakDes.setText(speaker.getSpeakerDescription());
        duration.setText(speaker.getSpeakertDuration());
        starttime.setText(speaker.getSpeakerStartTime());
    }
}

public class SpeakerAdapter extends RecyclerView.Adapter<SpeakerHolder>{
    private Context context;
    private ArrayList<Speaker> speakers;

    public SpeakerAdapter(Context context,ArrayList<Speaker> speakers) {
        this.context=context;
        this.speakers = speakers;
    }

    @NonNull
    @Override
    public SpeakerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row_speakers, parent, false);
        return new SpeakerHolder(view);
    }

    @Override
    public void onBindViewHolder(SpeakerHolder holder, int position) {
        Speaker speaker = speakers.get(position);
        holder.setDetails(speaker);
    }

    @Override
    public int getItemCount() {
        return speakers.size();
    }
}

