package org.knit.lab24;

public class Task36 {
    static public void execute() {
        Stock google = new Stock("Google", 10);
        Stock microsoft = new Stock("Microsoft", 9);

        MobileApp mobileApp = new MobileApp();
        EmailNotifier emailNotifier = new EmailNotifier();

        mobileApp.getSubscriptions();
        System.out.println();

        mobileApp.subscribe(google);
        emailNotifier.subscribe(google);
        emailNotifier.subscribe(microsoft);

        google.setPrice(15.5);
        microsoft.setPrice(11.2);
        System.out.println();

        emailNotifier.unsubscribe(google);

        google.setPrice(18.9);
        microsoft.setPrice(14.4);
        System.out.println();
    }
}
