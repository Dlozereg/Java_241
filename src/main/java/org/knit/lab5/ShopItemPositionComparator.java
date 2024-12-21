package org.knit.lab5;

import java.util.Comparator;

public class ShopItemPositionComparator implements Comparator<ShopItem> {
    @Override
    public int compare(ShopItem o1, ShopItem o2) {
        if (o1.getPosition() > o2.getPosition()){
            return 1;
        }
        else if (o1.getPosition() < o2.getPosition()){
            return -1;
        }
        return 0;
    }
}
