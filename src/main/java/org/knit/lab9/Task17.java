package org.knit.lab9;

public class Task17 {
    public static void execute() throws IllegalAccessException {
        User user = new User(null, "LongUsernameHere", 16);
        Validator.validate(user);

        User anotherUser = new User("bob", "bob321", 18);
        Validator.validate(anotherUser);
    }
}
