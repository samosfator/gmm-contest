package ua.samosfator;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserIdLoader {

    private String uidRemoteSource = "http://pastebin.com/raw.php?i=zfif2VWL";

    public void updateUidsList() {
        try {
            String txt = loadUidsTextFile();
            List<String> uids = extractUidsFromTextFile(txt);

            UserIdHolder.setUids(uids);

            System.out.println("Found " + uids.size() + " uids.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String loadUidsTextFile() throws IOException {
        InputStream inputStream = new URL(uidRemoteSource).openStream();
        return new Scanner(inputStream).useDelimiter("\\A").next();
    }

    private List<String> extractUidsFromTextFile(String txt) {
        List<String> extractedUids = new ArrayList<>();

        Pattern regexPattern = Pattern.compile("\\d{19,}");
        Matcher matcher = regexPattern.matcher(txt);
        while (matcher.find()) {
            extractedUids.add(matcher.group());
        }

        return extractedUids;
    }
}
