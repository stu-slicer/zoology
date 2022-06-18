package com.nology.zoology.star;

import com.nology.ColourUtils;

public class StarUtils {

    public static final String WHITE_STAR = "\u2606"; //☆
    public static final String BLACK_STAR = "\u2605"; //★
    public static final String PINWHEEL_STAR = "\u272F"; //✯
    public static final String OUTLINED_STAR = "\u2690"; //⚝

    public static String printStars(Starrable starrable) {

        if (starrable.getStars() == 0) {
            return ColourUtils.yellow(WHITE_STAR);
        }

        StringBuilder sb = new StringBuilder(" ");

        for (int i = 0; i < starrable.getStars(); i++) {
            sb.append( ColourUtils.yellow(BLACK_STAR) + " " );
        }

        return sb.toString();
    }

}
