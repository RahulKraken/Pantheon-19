package com.kraken.pantheon19.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kraken.pantheon19.Activities.EventDetailActivity;
import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.Entities.ImageNicer;
import com.kraken.pantheon19.Fragments.Day1Fragment;
import com.kraken.pantheon19.Fragments.Day3Fragment;
import com.kraken.pantheon19.R;

import java.util.List;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class EventsRecyclerViewAdapter extends RecyclerView.Adapter<EventsRecyclerViewAdapter.EventsRecyclerViewHolder> {
    private static final String TAG = "ERVA";

    private Context context;
    private List<Event> eventList;

    public EventsRecyclerViewAdapter(Context context, List<Event> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    private String setRandomColor() {
        Random r = new Random();
        int rand = r.nextInt(5 - 1) + 1;
        if (rand == 1) return "#4fC3F7"; //blue
        else if (rand == 2) return "#76FF03"; //green
        else if (rand == 3) return "#FFFF00"; //yellow
        else if (rand == 4) return "#FF0000"; //red
        else return "#FFFFFF";
    }

    @NonNull
    @Override
    public EventsRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row_events, parent, false);
        return new EventsRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsRecyclerViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: binding values to views");
        holder.txtName.setText(eventList.get(position).getTitle());
        holder.txtName.setTextColor(Color.parseColor(setRandomColor()));
        holder.venue.setText(eventList.get(position).getVenue());
        holder.duration.setText(eventList.get(position).getDuration());
        holder.startTime.setText(eventList.get(position).getTime());
        // TODO : replace with actual image
        //holder.circleImageView.setImageResource(R.mipmap.ic_launcher);
        //holder.circleImageView.setImageBitmap(ImageNicer.decodeSampledBitmapFromResource(context.getResources(),
               // eventList.get(position).getImage(),100,100));
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    class EventsRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtName,venue,duration,startTime;
        private CircleImageView circleImageView;

        EventsRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.tv_event_title);
            venue = itemView.findViewById(R.id.tv_event_venue);
            duration=itemView.findViewById(R.id.tv_event_duration);
            startTime=itemView.findViewById(R.id.tv_event_time);
            circleImageView=itemView.findViewById(R.id.circle_image_view);
            txtName.setOnClickListener(this);
            venue.setOnClickListener(this);
            duration.setOnClickListener(this);
            startTime.setOnClickListener(this);
            circleImageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: event was clicked!!");
            // TODO : send event detail with intent
            context.startActivity(new Intent(context, EventDetailActivity.class));
        }
    }
}
