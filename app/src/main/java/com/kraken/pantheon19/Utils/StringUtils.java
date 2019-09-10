package com.kraken.pantheon19.Utils;
/*
 * created by RahulKraken on 11-09-2019 at 05:06.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {

    /**
     * parse string with given delimiter
     * @param raw : raw string
     * @param delimiter : delimiter to slice on (should be a valid regex)
     * @return list of parsed strings
     */
    public static List<String> parseContact(String raw, String delimiter) {
        String[] s = raw.split(delimiter);
        return new ArrayList<>(Arrays.asList(s));
    }
}
