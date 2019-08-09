package com.kraken.pantheon19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class MainActivity extends AppCompatActivity {

    CarouselPicker carouselPicker1,carouselPicker2,carouselPicker3,carouselPicker4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carouselPicker1 = (CarouselPicker)findViewById(R.id.carouselPicker1);
        carouselPicker2 = (CarouselPicker)findViewById(R.id.carouselPicker2);
        carouselPicker3 = (CarouselPicker)findViewById(R.id.carouselPicker3);
        carouselPicker4 = (CarouselPicker)findViewById(R.id.carouselPicker4);

        List<CarouselPicker.PickerItem> textItems1 = new ArrayList<>();
        textItems1.add(new CarouselPicker.TextItem("The first One", 10));
        textItems1.add(new CarouselPicker.TextItem("The second One",10));
        textItems1.add(new CarouselPicker.TextItem("The third One",10));
        CarouselPicker.CarouselViewAdapter textAdapter1 = new CarouselPicker.CarouselViewAdapter(this,textItems1,0);
        carouselPicker1.setAdapter(textAdapter1);

        List<CarouselPicker.PickerItem> textItems2 = new ArrayList<>();
        textItems2.add(new CarouselPicker.TextItem("The first One", 10));
        textItems2.add(new CarouselPicker.TextItem("The second One",10));
        textItems2.add(new CarouselPicker.TextItem("The third One",10));
        CarouselPicker.CarouselViewAdapter textAdapter2 = new CarouselPicker.CarouselViewAdapter(this,textItems2,0);
        carouselPicker1.setAdapter(textAdapter2);

        List<CarouselPicker.PickerItem> textItems3 = new ArrayList<>();
        textItems3.add(new CarouselPicker.TextItem("The first One", 10));
        textItems3.add(new CarouselPicker.TextItem("The second One",10));
        textItems3.add(new CarouselPicker.TextItem("The third One",10));
        CarouselPicker.CarouselViewAdapter textAdapter3 = new CarouselPicker.CarouselViewAdapter(this,textItems3,0);
        carouselPicker1.setAdapter(textAdapter3);

        List<CarouselPicker.PickerItem> textItems4 = new ArrayList<>();
        textItems4.add(new CarouselPicker.TextItem("The first One", 10));
        textItems4.add(new CarouselPicker.TextItem("The second One",10));
        textItems4.add(new CarouselPicker.TextItem("The third One",10));
        CarouselPicker.CarouselViewAdapter textAdapter4 = new CarouselPicker.CarouselViewAdapter(this,textItems4,0);
        carouselPicker1.setAdapter(textAdapter4);
    }
}