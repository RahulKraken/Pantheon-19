package com.kraken.pantheon19;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class HomepageActivity extends AppCompatActivity {

    Button eventsButton;
    CarouselPicker carouselPicker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        carouselPicker = (CarouselPicker)findViewById(R.id.carouselPicker);
        eventsButton=findViewById(R.id.events_button);
        eventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomepageActivity.this,EventsActivity.class);
                startActivity(intent);
            }
        });

        List<CarouselPicker.PickerItem> imageItems = new ArrayList<>();
        imageItems.add(new CarouselPicker.DrawableItem(R.drawable.i1));
        imageItems.add(new CarouselPicker.DrawableItem(R.drawable.i2));
        imageItems.add(new CarouselPicker.DrawableItem(R.drawable.i3));
        //Creating an adapter
        CarouselPicker.CarouselViewAdapter imageAdapter = new CarouselPicker.CarouselViewAdapter(this, imageItems, 0);
        //Setting the adapter
        carouselPicker.setAdapter(imageAdapter);




        carouselPicker.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //position of the selected item
                if(position == 0){
                    Toast.makeText(HomepageActivity.this, position+" was clicked", Toast.LENGTH_SHORT).show();
                }
                else if(position == 1){
                    Toast.makeText(HomepageActivity.this, position+" was clicked", Toast.LENGTH_SHORT).show();
                }
                // Same conditions for another cases.
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
