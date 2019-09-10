package com.kraken.pantheon19.Adapters;
/*
 * created by RahulKraken on 09-09-2019 at 04:13.
 */

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kraken.pantheon19.Activities.EventDetailActivity;
import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class EventsRecyclerViewAdapter extends RecyclerView.Adapter<EventsRecyclerViewAdapter.EventsViewHolder> {
    private static final String TAG = "EventsRecyclerViewAdapt";

    private Context context;
    private List<Event> events = new ArrayList<>();

    public EventsRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public EventsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
        return new EventsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsViewHolder holder, int position) {
        holder.title.setText(events.get(position).getEventName());
        holder.venue.setText(events.get(position).getVenue());
//        holder.duration.setText(events.get(position).getDuration());
        holder.time.setText(events.get(position).getTiming());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public void setEvents(List<Event> events) {
        this.events = events;
        notifyDataSetChanged();
    }

    class EventsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CircleImageView imageView;
        TextView title, venue, time, duration;

        EventsViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.circle_image_view);
            title = itemView.findViewById(R.id.tv_event_title);
            venue = itemView.findViewById(R.id.tv_event_venue);
            time = itemView.findViewById(R.id.tv_event_time);
//            duration = itemView.findViewById(R.id.tv_event_duration);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: clicked");
            Intent intent = new Intent(context, EventDetailActivity.class);
            intent.putExtra(context.getResources().getString(R.string.event_intent_pass_key), events.get(getAdapterPosition()));
            context.startActivity(intent);
        }
    }
}
