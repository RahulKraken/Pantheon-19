package com.kraken.pantheon19.Entities;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefThemes {

    SharedPreferences sharedPreferences;
    public SharedPrefThemes(Context context) {
        sharedPreferences=context.getSharedPreferences("filename",Context.MODE_PRIVATE);
    }

    public void setNightModeState(Boolean state) {
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("Nightmode",state);
        editor.apply();
    }

    public Boolean loadNightModeState() {
        return sharedPreferences.getBoolean("Nightmode",false);
    }
}
