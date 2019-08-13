package com.kraken.pantheon19.Activities;

import android.os.Bundle;;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.kraken.pantheon19.Fragments.Day1Fragment;
import com.kraken.pantheon19.Fragments.Day2Fragment;
import com.kraken.pantheon19.Fragments.Day3Fragment;
import com.kraken.pantheon19.R;

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Toolbar toolbar=findViewById(R.id.events_toolbar);
        TabLayout tabLayout=findViewById(R.id.tab_layout);
        ViewPager viewPager=findViewById(R.id.pager);
        if (toolbar != null) setSupportActionBar(toolbar);
        viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
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
