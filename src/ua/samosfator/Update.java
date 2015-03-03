package ua.samosfator;

import ua.samosfator.stat.bean.User;
import ua.samosfator.stat.parser.UserParser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Update extends HttpServlet {

    private UserIdLoader userIdLoader = new UserIdLoader();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        userIdLoader.updateUidsList();
        History.users = getUsersUpdate();

        resp.getWriter().println("ok");
    }

    private List<User> getUsersUpdate() {
        List<User> users = new ArrayList<>();

        for (String uid : UserIdHolder.getUids()) {
            User userByUid = History.getUserByUid(uid);
            UserParser userParser;
            if (userByUid == null) {
                userParser = new UserParser(uid);
            } else {
                userParser = new UserParser(userByUid, uid);
            }
            User user = userParser.getUser();
            users.add(user);
        }
        return users;
    }

}
