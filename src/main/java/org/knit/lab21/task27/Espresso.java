package org.knit.lab21.task27;

public class Espresso implements Coffee{
    @Override
    public double getCalories() {
        return 100;
    }

    @Override
    public double getCost() {
        return 1.99;
    }

    @Override
    public String getDescription() {
        return "Эспрессо";
    }
}
