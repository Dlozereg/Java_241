package org.knit.lab9;

 enum Seasons {
    WINTER("Зима", "холодно", "Новый год"),
    SPRING("Весна","тепло", "Международный женский день"),
    SUMMER("Лето","жарко", "Международный день защиты детей"),
    AUTUMN("Осень", "тепло", "День знаний");

    private final String season;
    private final String weather;
    private final String holiday;

    Seasons (String season, String weather, String holiday) {
        this.season = season;
        this.weather = weather;
        this.holiday = holiday;
    }

    public String getSeason() {
        return season;
    }

    public String getWeather() {
        return weather;
    }

    public String getHoliday() {
        return holiday;
    }
}
