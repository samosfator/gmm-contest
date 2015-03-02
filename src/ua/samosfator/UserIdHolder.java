package ua.samosfator;

import java.util.HashSet;
import java.util.Set;

public class UserIdHolder {

    private static Set<String> uids = new HashSet<>();

    public static Set<String> getUids() {
        return uids;
    }

    public static void setUids(Set<String> uids) {
        UserIdHolder.uids = uids;
    }
}
