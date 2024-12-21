package org.knit.lab5;

import java.util.*;

public class Task8 {
    public static void execute() {
        String[] names = {"книга", "ручка", "линейка", "пинал"};
        int[] prices = {10, 20, 30};
        int[] positions = {0, 1};
        Random random = new Random();
        Comparator<ShopItem> comp = new ShopItemPositionComparator()
                .thenComparing(new ShopItemPriceComparator())
                .thenComparing(new ShopItemNameComparator());
        ShopItem[] testData = new ShopItem[100];
        testData[0] = new ShopItem(names[0], prices[0], positions[0]);
        testData[1] = new ShopItem(names[0], prices[0], positions[0]);
        for (int i = 2; i < 100; i++) {
            testData[i] = new ShopItem(names[random.nextInt(4)], prices[random.nextInt(3)],
                    positions[random.nextInt(2)]);
        }
        testData = Arrays.stream(testData).sorted(comp).toArray(ShopItem[]::new);
        HashSet<ShopItem> unique = new HashSet<>();
        int duplicates = 0;
        for (ShopItem item : testData){
            System.out.println(item);
            if (unique.contains(item)){
                duplicates++;
            }
            else{
                unique.add(item);
            }
        }
        System.out.printf("duplicates = %d", duplicates);
    }
}
