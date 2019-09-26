package com.kraken.pantheon19.Adapters;
/*
 * created by RahulKraken on 08-09-2019 at 20:23.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.recyclerview.widget.RecyclerView;

import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.Entities.Sponsor;
import com.kraken.pantheon19.R;

import java.util.List;

public class SponsorsRecyclerViewAdapter extends RecyclerView.Adapter<SponsorsRecyclerViewAdapter.SponsorsRecyclerViewHolder> {
    private static final String TAG = "SpeakerRecyclerViewAda";

    private Context context;
    private List<Sponsor> sponsorList;
    private CustomTabsIntent customTabsIntent;

    public SponsorsRecyclerViewAdapter(Context context, List<Sponsor> sponsorList) {
        this.context = context;
        this.sponsorList = sponsorList;
        // setup customTabIntent
        customTabsIntent = new CustomTabsIntent.Builder()
                .setShowTitle(true)
                .build();
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
        holder.textView.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition_animation));
        holder.img.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition_animation));
        holder.sponsorCard.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_scale_animation));

        // TODO : replace with actual image
        holder.textView.setText(sponsorList.get(position).getSponsorName());
        holder.img.setImageResource(sponsorList.get(position).getSponsorImage());
    }

    @Override
    public int getItemCount() {
        return sponsorList.size();
    }

    class SponsorsRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        ImageView img;
        LinearLayout sponsorCard;

        SponsorsRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.sponsor_text);
            img = itemView.findViewById(R.id.item_sponsor);
            sponsorCard=itemView.findViewById(R.id.sponsors_layout);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: event was clicked!!");
            // TODO : replace with sponsors website link
            customTabsIntent.launchUrl((Activity) context, Uri.parse("https://www.google.com"));
        }
    }
}
