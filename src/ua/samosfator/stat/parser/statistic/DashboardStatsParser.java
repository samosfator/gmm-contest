package ua.samosfator.stat.parser.statistic;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ua.samosfator.stat.bean.statistic.DashboardStats;

import java.util.HashMap;
import java.util.Map;

public class DashboardStatsParser {

    private DashboardStatsRowsParser dashboardStatsRowsParser;

    public DashboardStatsParser(Element dashboardStatsElement) {
        this.dashboardStatsRowsParser = new DashboardStatsRowsParser(getStatsRows(dashboardStatsElement));
    }

    private Map<String, String> getStatsRows(Element dashboardStatsElement) {
        Map<String, String> statsRows = new HashMap<>();

        Elements tr = dashboardStatsElement.select("tr");

        for (Element element : tr) {
            String rowName = element.select("td").first().text();
            String rowValue = element.select("td").last().text();

            statsRows.put(rowName, rowValue);
        }

        return statsRows;
    }

    public DashboardStats getDashboardStats() {
        DashboardStats dashboardStats = new DashboardStats();

        dashboardStats.setRoadLength(parseRoadLength());
        dashboardStats.setPoi(parsePoi());
        dashboardStats.setBusinessListings(parseBusinessListings());
        dashboardStats.setRegions(parseRegions());
        dashboardStats.setFeatureEdits(parseFeatureEdits());

        return dashboardStats;
    }

    private double parseRoadLength() {
        return dashboardStatsRowsParser.parseDoubleRow("Road length");
    }

    private int parsePoi() {
        return dashboardStatsRowsParser.parseIntRow("Points of interest");
    }

    private int parseBusinessListings() {
        return dashboardStatsRowsParser.parseIntRow("Business listings");
    }

    private double parseRegions() {
        return dashboardStatsRowsParser.parseDoubleRow("Regions");
    }

    private int parseFeatureEdits() {
        return dashboardStatsRowsParser.parseIntRow("Feature edits");
    }
}
