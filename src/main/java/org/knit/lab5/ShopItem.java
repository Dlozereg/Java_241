package org.knit.lab5;

import java.util.Objects;

public class ShopItem {
    private String name;
    private int price;
    private int position;

    public ShopItem(String name, int price, int position) {
        this.name = name;
        this.price = price;
        this.position = position;
    }

    @Override
    public String toString() {
        return "ShopItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopItem shopItem = (ShopItem) o;
        return price == shopItem.price && position == shopItem.position && Objects.equals(name, shopItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, position);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getPosition() {
        return position;
    }
}
