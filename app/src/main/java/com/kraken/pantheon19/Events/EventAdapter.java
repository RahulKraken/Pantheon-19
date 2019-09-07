package com.kraken.pantheon19.Events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kraken.pantheon19.R;
import java.util.ArrayList;

class EventHolder extends RecyclerView.ViewHolder {
    private TextView txtName,txtDes,duration,starttime;
    public EventHolder(View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.txtName);
        txtDes = itemView.findViewById(R.id.txtDes);
        duration=itemView.findViewById(R.id.duration);
        starttime=itemView.findViewById(R.id.starting_time);
    }
    public void setDetails(Event event) {
        txtName.setText(event.getEventName());
        txtDes.setText(event.getEventDescription());
        duration.setText(event.getEventDuration());
        starttime.setText(event.getEventStartTime());
    }
}
public class EventAdapter extends RecyclerView.Adapter<EventHolder>{
    private Context context;
    private ArrayList<Event> events;

    public EventAdapter(Context context,ArrayList<Event> events) {
        this.context=context;
        this.events = events;
    }

    @NonNull
    @Override
    public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
        return new EventHolder(view);
    }

    @Override
    public void onBindViewHolder(EventHolder holder, int position) {
        Event event = events.get(position);
        holder.setDetails(event);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}

