package com.kraken.pantheon19.Utils;
/*
 * created by RahulKraken on 09-09-2019 at 15:51.
 */

import com.google.gson.Gson;
import com.kraken.pantheon19.Entities.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Serializer {

    public static List<Event> serializeEvents(String raw) {
        Gson gson = new Gson();
        Event[] events = gson.fromJson(raw, Event[].class);
        return new ArrayList<>(Arrays.asList(events));
    }
}
