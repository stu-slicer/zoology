package com.nology.zoology.star;

import com.nology.ColourUtils;

public class StarUtils {

    public static final String WHITE_STAR = "\u2606"; //☆
    public static final String BLACK_STAR = "\u2605"; //★
    public static final String PINWHEEL_STAR = "\u272F"; //✯
    public static final String OUTLINED_STAR = "\u2690"; //⚝

    public static String printStars(Starrable starrable) {
        return printStars( starrable.getStars(), -1 );
    }

    public static String printStars(Starrable starrable, int outOf) {
        return printStars( starrable.getStars(), outOf );
    }

    public static String printStars(int stars) {
        return printStars(stars, -1);
    }

    public static String printStars(int stars, int outOf) {

        if (stars == 0) {
            return ColourUtils.yellow(WHITE_STAR);
        }

        StringBuilder sb = new StringBuilder(" ");

        for (int i = 0; i < stars; i++) {
            sb.append( ColourUtils.yellow(BLACK_STAR) + " " );
        }
        if( outOf > 0 ) {
            for (int i = stars; i < outOf; i++) {
                sb.append( ColourUtils.yellow(WHITE_STAR) + " " );
            }
        }

        return sb.toString();
    }

}
