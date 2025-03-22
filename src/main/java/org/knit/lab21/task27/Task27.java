package org.knit.lab21.task27;

public class Task27 {
    public static void execute(){
        Coffee espresso = new Espresso();
        System.out.println(espresso.getDescription() + " | Цена: $" + espresso.getCost() + " | Калорийность: " + espresso.getCalories() + " ккал");

        espresso = new Milk(espresso);
        System.out.println(espresso.getDescription() + " | Цена: $" + espresso.getCost() + " | Калорийность: " + espresso.getCalories() + " ккал");

        Coffee cappuccino = new Cappuccino();
        System.out.println(cappuccino.getDescription() + " | Цена: $" + cappuccino.getCost() + " | Калорийность: " + cappuccino.getCalories() + " ккал");

        cappuccino = new Caramel(cappuccino);
        System.out.println(cappuccino.getDescription() + " | Цена: $" + cappuccino.getCost() + " | Калорийность: " + cappuccino.getCalories() + " ккал");

        Coffee latte = new Latte();
        System.out.println(latte.getDescription() + " | Цена: $" + latte.getCost() + " | Калорийность: " + latte.getCalories() + " ккал");

        latte = new Chocolate(latte);
        System.out.println(latte.getDescription() + " | Цена: $" + latte.getCost() + " | Калорийность: " + latte.getCalories() + " ккал");
    }
}
