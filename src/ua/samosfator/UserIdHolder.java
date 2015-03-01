package ua.samosfator;

import java.util.ArrayList;
import java.util.List;

public class UserIdHolder {

    private static List<String> uids = new ArrayList<>();

    public static List<String> getUids() {
        return uids;
    }

    public static void setUids(List<String> uids) {
        UserIdHolder.uids = uids;
    }
}
