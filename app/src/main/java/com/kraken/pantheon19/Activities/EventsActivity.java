package com.kraken.pantheon19.Activities;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.kraken.pantheon19.Adapters.EventsRecyclerViewAdapter;
import com.kraken.pantheon19.Entities.SharedThemePref;
import com.kraken.pantheon19.Fragments.DayOneFragment;
import com.kraken.pantheon19.Fragments.DayTwoFragment;
import com.kraken.pantheon19.R;

import java.util.Objects;

public class EventsActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    SharedThemePref sharedThemePref;
    boolean isDark;
    ViewPager viewPager;
    CoordinatorLayout eventsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        Fade fade=new Fade();
        View decor=getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container),true);
        fade.excludeTarget(android.R.id.statusBarBackground,true);
        fade.excludeTarget(android.R.id.navigationBarBackground,true);
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);
        final int[] icons=new int[]{R.drawable.one,R.drawable.two};

        tabLayout=findViewById(R.id.tab_layout);
        toolbar = findViewById(R.id.app_bar);
        tabLayout = findViewById(R.id.tab_layout);
        eventsList=findViewById(R.id.event_list_layout);

        viewPager = findViewById(R.id.pager);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Events");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        sharedThemePref=new SharedThemePref();

        //set theme
        isDark = sharedThemePref.getThemeStatePref(this);
        if(isDark) setDarkTheme();
        else setLightTheme();

        viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(icons[0]);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(icons[1]);
    }

    @Override
    public boolean onSupportNavigateUp() {
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
                case 0: return new DayOneFragment(isDark);
                default: return new DayTwoFragment(isDark);
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: return "";
                default: return "";
            }
        }
    }

    public void setDarkTheme() {
        eventsList.setBackgroundColor(getResources().getColor(R.color.md_black_1000));
        tabLayout.setBackground(getDrawable(R.drawable.tabs_dark));
        toolbar.setTitleTextColor(getResources().getColor(R.color.md_white_1000));
        toolbar.setBackgroundColor(getResources().getColor(R.color.md_black_1000));
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP);
    }

    public void setLightTheme() {
        eventsList.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
        tabLayout.setBackground(getDrawable(R.drawable.tabs_light));
        toolbar.setTitleTextColor(getResources().getColor(R.color.md_black_1000));
        toolbar.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.md_black_1000), PorterDuff.Mode.SRC_ATOP);
    }
}
