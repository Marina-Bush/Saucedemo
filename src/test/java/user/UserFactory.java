package user;

import utils.PropertyReader;

public class UserFactory {

    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withLockedUserPermission() {
        return new User(PropertyReader.getProperty("saucedemo.loked.user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withHRPermission() {
        return new User(PropertyReader.getProperty(""),
                PropertyReader.getProperty(""));
    }
}