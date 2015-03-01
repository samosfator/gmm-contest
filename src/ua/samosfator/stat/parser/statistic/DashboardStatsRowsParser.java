package ua.samosfator.stat.parser.statistic;

import java.util.Map;
import java.util.Set;

public class DashboardStatsRowsParser {

    private Map<String, String> statsRows;

    public DashboardStatsRowsParser(Map<String, String> statsRows) {
        this.statsRows = statsRows;
    }

    public int parseIntRow(String rowName) {
        Set<Map.Entry<String, String>> entries = statsRows.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            if (entry.getKey().contains(rowName)) {
                try {
                    return Integer.parseInt(entry.getValue().trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        }

        return 0;
    }

    public double parseDoubleRow(String rowName) {
        Set<Map.Entry<String, String>> entries = statsRows.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            if (entry.getKey().contains(rowName)) {
                try {
                    return Double.parseDouble(entry.getValue().trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        }

        return 0;
    }
}
