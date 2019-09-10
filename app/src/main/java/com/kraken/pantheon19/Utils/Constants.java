package com.kraken.pantheon19.Utils;
/*
 * created by RahulKraken on 09-09-2019 at 14:13.
 */

import com.kraken.pantheon19.R;

public class Constants {

    public static final String FORMAL_EVENTS_API = "https://www.pantheonbit.com/api/event/getFormalEvents";
    public static final String INFORMAL_EVENTS_API = "https://www.pantheonbit.com/api/event/getInformalEvents";
    public static final String FLAGSHIP_EVENTS_API = "http://10.0.2.2:5000/formalevents";
    public static final String WINNERS_API = "http://10.0.2.2:5000/informalevents";
    public static final String LEADERBOARD_API = "http://10.0.2.2:5000/leaderboard";

    public static final int[] COLORS = {
            R.color.md_red_500,
            R.color.md_blue_500,
            R.color.md_amber_500,
            R.color.md_green_500
    };

    public static final int[] FLAGSHIP_POINTS = {250, 200, 150};
    public static final int[] FORMAL_POINTS = {100, 80, 60};
    public static final int[] INFORMAL_POINTS = {50, 30, 20};

    public static final String FACEBOOK_URL = "https://www.facebook.com/bitmesra.pantheon/";
    public static final String INSTAGRAM_URL = "https://www.instagram.com/pantheon_techfest/";
    public static final String WEBSITE_URL = "https://pantheonbit.com";
}
