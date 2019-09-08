package com.kraken.pantheon19.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.kraken.pantheon19.Entities.ImageNicer;
import com.kraken.pantheon19.R;

import java.util.List;

public class SponsorsRecyclerViewAdapter extends RecyclerView.Adapter<SponsorsRecyclerViewAdapter.SponsorsRecyclerViewHolder> {
    private static final String TAG = "SpeakerRecyclerViewAda";

    private Context context;
    private List<Event> eventList;

    public SponsorsRecyclerViewAdapter(Context context, List<Event> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public SponsorsRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row_sponsors, parent, false);
        return new SponsorsRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SponsorsRecyclerViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: binding values to views");
        // TODO : replace with actual image
        //holder.img.setImageResource(R.mipmap.ic_launcher);
        //holder.img.setImageBitmap(ImageNicer.decodeSampledBitmapFromResource(context.getResources(),
                //eventList.get(position).getImage(),100,100));
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    class SponsorsRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;

        SponsorsRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.circleView);
            img.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: event was clicked!!");
            // TODO : send event detail with intent
            String url = "http://www.google.com";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            context.startActivity(i);
        }
    }
}
