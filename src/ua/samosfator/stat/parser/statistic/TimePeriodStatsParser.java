package ua.samosfator.stat.parser.statistic;

import org.jsoup.nodes.Element;
import ua.samosfator.stat.bean.statistic.TimePeriodStats;

import java.util.Arrays;
import java.util.List;

public class TimePeriodStatsParser {

    private TimePeriodStatsPiecesParser timePeriodStatsPiecesParser;

    public TimePeriodStatsParser(Element timePeriodStatsElement) {
        timePeriodStatsPiecesParser = new TimePeriodStatsPiecesParser(getStatsPieces(timePeriodStatsElement));
    }

    private List<String> getStatsPieces(Element timePeriodStatsElement) {
        return Arrays.asList(
                timePeriodStatsElement
                        .select(".time_period_large")
                        .text()
                        .trim()
                        .split(",")
        );
    }

    public TimePeriodStats getTimePeriodStats() {
        TimePeriodStats timePeriodStats = new TimePeriodStats();

        timePeriodStats.setDays(parseDays());
        timePeriodStats.setTotalEdits(parseTotalEdits());
        timePeriodStats.setApprovedEdits(parseApprovedEdits());
        timePeriodStats.setReviews(parseReview());

        return timePeriodStats;
    }

    public static TimePeriodStats getEmptyTimePeriodStats() {
        TimePeriodStats timePeriodStats = new TimePeriodStats();

        timePeriodStats.setDays(0);
        timePeriodStats.setTotalEdits(0);
        timePeriodStats.setApprovedEdits(0);
        timePeriodStats.setReviews(0);

        return timePeriodStats;
    }

    private int parseDays() {
        return timePeriodStatsPiecesParser.parseIntPiece("days");
    }

    private int parseTotalEdits() {
        return timePeriodStatsPiecesParser.parseIntPiece("total edits");
    }

    private int parseApprovedEdits() {
        return timePeriodStatsPiecesParser.parseIntPiece("approved");
    }

    private int parseReview() {
        return timePeriodStatsPiecesParser.parseIntPiece("reviews");
    }
}
