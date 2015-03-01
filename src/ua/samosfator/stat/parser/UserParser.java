package ua.samosfator.stat.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import ua.samosfator.stat.bean.User;
import ua.samosfator.stat.parser.statistic.StatisticParser;

import java.io.IOException;

public class UserParser {

    private Document userPageDocument;
    private String uid;

    public UserParser(String uid) {
        this.uid = uid;
    }

    public User getUser() {
        loadUserPageHtml(uid);

        User user = new User();

        StatisticParser statisticParser = new StatisticParser(getStatisticElement());

        user.setUid(uid);
        user.setName(parseUsername());
        user.setAvatarUrl(parseAvatarUrl());
        user.setStatistic(statisticParser.getStatistic());

        return user;
    }

    private void loadUserPageHtml(String uid) {
        String userPageUrl = "https://www.google.com/mapmaker?gw=66&hl=en&uid=" + uid;
        try {
            userPageDocument = Jsoup.connect(userPageUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String parseUsername() {
        return userPageDocument.select(".profile-name").first().text();
    }

    private String parseAvatarUrl() {
        return userPageDocument.select(".profile-img").first().attr("src");
    }

    private Element getStatisticElement() {
        return userPageDocument.getElementById("rightpanel");
    }
}
