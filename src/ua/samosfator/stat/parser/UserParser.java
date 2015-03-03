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
    private User previouslyParsedUser;

    public UserParser(String uid) {
        this.uid = uid;
    }

    public UserParser(User previousParsingResult, String uid) {
        this.previouslyParsedUser = previousParsingResult;
        this.uid = uid;
    }

    public User getUser() {
        System.out.println("Parsing user: " + uid);

        loadUserPageHtml(uid);
        StatisticParser statisticParser = new StatisticParser(getStatisticElement());

        if (previouslyParsedUser == null) {

            User user = new User();


            user.setUid(uid);
            user.setName(parseUsername());
            user.setAvatarUrl(parseAvatarUrl());
            user.setStatistic(statisticParser.getStatistic());

            return user;
        } else {
            previouslyParsedUser.setStatistic(statisticParser.getStatistic(previouslyParsedUser));
            return previouslyParsedUser;
        }
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
        return userPageDocument.select("#rightpanel").first();
    }
}
