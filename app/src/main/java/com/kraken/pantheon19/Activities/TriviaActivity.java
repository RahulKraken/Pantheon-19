package com.kraken.pantheon19.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kraken.pantheon19.Entities.Trivia;
import com.kraken.pantheon19.R;

import butterknife.BindView;

public class TriviaActivity extends AppCompatActivity {

    @BindView(R.id.trivia_img) ImageView img;
    @BindView(R.id.trivia_title) TextView title;
    @BindView(R.id.trivia_desc) TextView desc;
    @BindView(R.id.trivia_read_more) TextView readMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        // get Bundle containing trivia data
        final Trivia trivia = (Trivia) getIntent().getSerializableExtra(getResources().getString(R.string.TRIVIA_INTENT_PASS_KEY));

        // load img
        Glide.with(this)
                .load(trivia.getImageUrl())
                .apply(new RequestOptions().placeholder(R.color.md_blue_grey_200))
                .into(img);

        // set text
        title.setText(trivia.getTitle());
        desc.setText(trivia.getDescription());

        // onClick listener for read more link
        readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create a customTabIntent
                CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder()
                        .setShowTitle(true)
                        .build();

                // launch custom tab with read more Uri
                customTabsIntent.launchUrl(TriviaActivity.this, Uri.parse(trivia.getReadMoreUrl()));
            }
        });
    }
}
