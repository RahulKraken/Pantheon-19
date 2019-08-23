package com.kraken.pantheon19.Adapters;
/*
 * created by RahulKraken on 23-08-2019 at 15:12.
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.R;

import java.util.List;

public class FlagshipRecyclerViewAdapter extends RecyclerView.Adapter<FlagshipRecyclerViewAdapter.FlagshipRecyclerViewHolder> {
    private static final String TAG = "FlagshipRecyclerViewAda";

    private Context context;
    private List<Event> eventList;

    public FlagshipRecyclerViewAdapter(Context context, List<Event> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public FlagshipRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.flagship_rv_item, parent, false);
        return new FlagshipRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlagshipRecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return eventList.size();
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
        }
    }
}