package org.knit.lab9;

public class Task15 {
    public static void execute() {
        for (Seasons seasons : Seasons.values()) {
            System.out.printf("%s: %s, типичный праздник - %s%n",
                    seasons.getSeason(), seasons.getWeather(), seasons.getHoliday());
        }
    }

}
