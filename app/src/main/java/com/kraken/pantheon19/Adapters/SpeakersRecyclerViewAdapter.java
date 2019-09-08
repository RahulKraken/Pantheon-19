package com.kraken.pantheon19.Adapters;
/*
 * created by RahulKraken on 08-09-2019 at 19:43.
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kraken.pantheon19.Entities.Speaker;
import com.kraken.pantheon19.R;

import java.util.List;

public class SpeakersRecyclerViewAdapter extends RecyclerView.Adapter<SpeakersRecyclerViewAdapter.SpeakersRecyclerViewHolder> {
    private static final String TAG = "SpeakerRecyclerViewAda";

    private Context context;
    private List<Speaker> speakersList;

    public SpeakersRecyclerViewAdapter(Context context, List<Speaker> speakersList) {
        this.context = context;
        this.speakersList = speakersList;
    }

    @NonNull
    @Override
    public SpeakersRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row_speakers, parent, false);
        return new SpeakersRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpeakersRecyclerViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: binding values to views");
        holder.name.setText(speakersList.get(position).getName());
        holder.venue.setText(speakersList.get(position).getVenue());
        holder.stime.setText(speakersList.get(position).getTime());
        holder.des.setText(speakersList.get(position).getDetail());
//        holder.view.setBackgroundColor(Color.parseColor(speakersList.get(position).getColor()));
        // TODO : replace with actual image
        holder.img.setImageResource(R.mipmap.ic_launcher);
        //holder.img.setImageBitmap(ImageNicer.decodeSampledBitmapFromResource(context.getResources(),
        // speakersList.get(position).getImage(),100,100));
    }

    @Override
    public int getItemCount() {
        return speakersList.size();
    }

    class SpeakersRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView name, venue, des, stime;
        ImageView img;
        View view;

        SpeakersRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.speaker_name);
            venue = itemView.findViewById(R.id.speakers_venue);
            des = itemView.findViewById(R.id.speaker_description);
            stime= itemView.findViewById(R.id.speakers_start_time);
            img = itemView.findViewById(R.id.circleView);
            view=itemView.findViewById(R.id.underline);
        }
    }
}
