package ua.samosfator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserIdLoader {

    private String uidRemoteSource = "https://docs.google.com/spreadsheets/d/13eNJRPBDDuxb19ABdNgwpYh8BvYv_MDM9zroeQ6F3lw/pubhtml?gid=1916706986&single=true";

    public void updateUidsList() {
        try {
//            String txt = loadUidsTextFile();
//            Set<String> uids = extractUidsFromTextFile(txt);
            Set<String> uids = loadUisFromGoogleSpreadsheet();

            UserIdHolder.setUids(uids);

            System.out.println("Found " + uids.size() + " uids.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Set<String> loadUisFromGoogleSpreadsheet() throws IOException {
        Set<String> extractedUids = new HashSet<>();

        Document document = Jsoup.connect(uidRemoteSource).timeout(0).get();
        Elements allLinks = document.select("a");

        Pattern regexPattern = Pattern.compile("\\d{19,}");

        for (Element aLink : allLinks) {
            if (aLink.attr("href").contains("mapmaker")/* && extractedUids.size() < 2*/) {
                Matcher matcher = regexPattern.matcher(aLink.attr("href"));
                while (matcher.find()) {
                    extractedUids.add(matcher.group());
                }
            }
        }

//        extractedUids.add("213060211708116919463");
        return extractedUids;
    }

    private String loadUidsTextFile() throws IOException {
        InputStream inputStream = new URL("http://pastebin.com/raw.php?i=HZS9xSk7").openStream();
        return new Scanner(inputStream).useDelimiter("\\A").next();
    }

    private Set<String> extractUidsFromTextFile(String txt) {
        System.out.println(txt);


        Set<String> extractedUids = new HashSet<>();

        Pattern regexPattern = Pattern.compile("\\d{19,}");
        Matcher matcher = regexPattern.matcher(txt);
        while (matcher.find()) {
            extractedUids.add(matcher.group());
        }

        return extractedUids;
    }
}
