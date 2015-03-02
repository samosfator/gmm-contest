package ua.samosfator;

import com.google.appengine.api.ThreadManager;
import ua.samosfator.stat.bean.User;
import ua.samosfator.stat.parser.UserParser;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.text.SimpleDateFormat;
import java.util.*;

public class StartupListener implements ServletContextListener {

    private UserIdLoader userIdLoader = new UserIdLoader();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Thread thread = ThreadManager.createBackgroundThread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        userIdLoader.updateUidsList();
                        String updateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());

                        Set<User> users = new HashSet<>();

                        for (String uid : UserIdHolder.getUids()) {
                            UserParser userParser = new UserParser(uid);
                            User user = userParser.getUser();
                            users.add(user);
                        }

                        StatisticHistory.usersHistory.put(updateTime, users);

                        Thread.sleep(20_000);
                    }
                } catch (InterruptedException ignored) {
                }
            }
        });
        thread.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
