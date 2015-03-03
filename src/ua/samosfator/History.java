package ua.samosfator;

import ua.samosfator.stat.bean.User;

import java.util.ArrayList;
import java.util.List;

public class History {

    public static List<User> users = new ArrayList<>();

    public static User getUserByUid(String uid) {
        User foundUser = null;
        for (User user : users) {
            if (user.getUid().equals(uid)) {
                return user;
            }
        }
        return foundUser;
    }
}
