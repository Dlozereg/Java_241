package org.knit.lab21.task27;

public class Cappuccino implements Coffee{
    @Override
    public double getCalories() {
        return 120;
    }

    @Override
    public double getCost() {
        return 2.49;
    }

    @Override
    public String getDescription() {
        return "Капучино";
    }
}
