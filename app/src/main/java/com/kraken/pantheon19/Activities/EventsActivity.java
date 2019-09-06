package com.kraken.pantheon19.Activities;

import android.os.Bundle;
import android.util.Log;;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.kraken.pantheon19.Entities.SharedPrefThemes;
import com.kraken.pantheon19.Fragments.Day1Fragment;
import com.kraken.pantheon19.Fragments.Day2Fragment;
import com.kraken.pantheon19.Fragments.Day3Fragment;
import com.kraken.pantheon19.R;

public class EventsActivity extends AppCompatActivity {

    SharedPrefThemes sharedPrefThemes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPrefThemes=new SharedPrefThemes(this);
        if(sharedPrefThemes.loadNightModeState()) setTheme(R.style.AppTheme);
        else setTheme(R.style.LightTheme);
        setContentView(R.layout.activity_events);
        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Events");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        TabLayout tabLayout=findViewById(R.id.tab_layout);
        ViewPager viewPager=findViewById(R.id.pager);
        viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }
    @Override
    public boolean onSupportNavigateUp() {
        Log.d("upupdowndown", "onSupportNavigateUp: back pressed");
        finish();
        return true;
    }

    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: return new Day1Fragment();
                case 1: return new Day2Fragment();
                default: return new Day3Fragment();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: return "Day 1";
                case 1: return "Day 2";
                default: return "Day 3";
            }
        }
    }

}
