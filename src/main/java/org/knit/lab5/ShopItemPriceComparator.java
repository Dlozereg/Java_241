package org.knit.lab5;

import java.util.Comparator;

public class ShopItemPriceComparator implements Comparator<ShopItem> {
    @Override
    public int compare(ShopItem o1, ShopItem o2) {
        if (o1.getPrice() > o2.getPrice()){
            return 1;
        }
        else if (o1.getPrice() < o2.getPrice()){
            return -1;
        }
        return 0;
    }
}
