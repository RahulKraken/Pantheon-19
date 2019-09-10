package com.kraken.pantheon19.Utils;
/*
 * created by RahulKraken on 11-09-2019 at 02:16.
 */

import java.util.Random;

public class ColorService {

    /**
     * @return : resource id of random color from set of available colors
     */
    public static int getRandomColor() {
        Random random = new Random();
        return Constants.COLORS[random.nextInt(Constants.COLORS.length)];
    }
}
