package com.kraken.pantheon19.Adapters;
/*
 * created by RahulKraken on 23-08-2019 at 15:12.
 */

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kraken.pantheon19.Activities.EventDetailActivity;
import com.kraken.pantheon19.Activities.FlagshipEventActivity;
import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.R;

import java.util.ArrayList;
import java.util.List;

public class FlagshipRecyclerViewAdapter extends RecyclerView.Adapter<FlagshipRecyclerViewAdapter.FlagshipRecyclerViewHolder> {
    private static final String TAG = "FlagshipRecyclerViewAda";

    private Context context;
    private List<Event> eventList = new ArrayList<>();

    public FlagshipRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FlagshipRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.flagship_rv_item, parent, false);
        return new FlagshipRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlagshipRecyclerViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: binding values to views");
        holder.title.setText(eventList.get(position).getTitle());
        holder.venue.setText(eventList.get(position).getVenue());
        holder.time.setText(eventList.get(position).getTime());

        holder.img.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
        notifyDataSetChanged();
    }

    class FlagshipRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title, venue, time;
        ImageView img;
        Button viewBtn;

        FlagshipRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.flagship_card_title);
            venue = itemView.findViewById(R.id.flagship_card_venue);
            time = itemView.findViewById(R.id.flagship_card_time);
            img = itemView.findViewById(R.id.flagship_card_featured_image);
            viewBtn = itemView.findViewById(R.id.flagship_card_view_btn);

            viewBtn.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: view btn clicked!!");
            // TODO : send event detail with intent
            context.startActivity(new Intent(context, EventDetailActivity.class));
        }
    }
}
