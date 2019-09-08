package com.kraken.pantheon19.Adapters;
/*
 * created by RahulKraken on 09-09-2019 at 04:13.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class EventsRecyclerViewAdapter extends RecyclerView.Adapter<EventsRecyclerViewAdapter.EventsViewHolder> {
    private static final String TAG = "EventsRecyclerViewAdapt";

    private Context context;
    private List<Event> events;

    public EventsRecyclerViewAdapter(Context context) {
        this.context = context;
        events = new ArrayList<>();
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
        events.add(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", 1, "30 mins"));
    }

    @NonNull
    @Override
    public EventsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
        return new EventsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsViewHolder holder, int position) {
        holder.title.setText(events.get(position).getTitle());
        holder.venue.setText(events.get(position).getVenue());
        holder.duration.setText(events.get(position).getDuration());
        holder.time.setText(events.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    class EventsViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        TextView title, venue, time, duration;

        public EventsViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.circle_image_view);
            title = itemView.findViewById(R.id.tv_event_title);
            venue = itemView.findViewById(R.id.tv_event_venue);
            time = itemView.findViewById(R.id.tv_event_time);
            duration = itemView.findViewById(R.id.tv_event_duration);
        }
    }
}
