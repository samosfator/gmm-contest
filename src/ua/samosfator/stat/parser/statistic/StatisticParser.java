package ua.samosfator.stat.parser.statistic;

import org.jsoup.nodes.Element;
import ua.samosfator.stat.bean.User;
import ua.samosfator.stat.bean.statistic.Statistic;
import ua.samosfator.stat.bean.statistic.StatsSnapshot;

public class StatisticParser {

    private Element statisticElement;

    public StatisticParser(Element statisticElement) {
        this.statisticElement = statisticElement;
    }

    public Statistic getStatistic() {
        Statistic statistic = new Statistic();
        StatsSnapshot statsSnapshot = new StatsSnapshot();

        Element timePeriodStatsElement = getTimePeriodStatsElement();
        Element dashboardStatsElement = getDashboardStatsElement();

        if (timePeriodStatsElement == null) {
            statsSnapshot.setTimePeriodStats(TimePeriodStatsParser.getEmptyTimePeriodStats());
        } else {
            TimePeriodStatsParser timePeriodStatsParser = new TimePeriodStatsParser(timePeriodStatsElement);
            statsSnapshot.setTimePeriodStats(timePeriodStatsParser.getTimePeriodStats());
        }

        if (dashboardStatsElement == null) {
            statsSnapshot.setDashboardStats(DashboardStatsParser.getEmptyDashboardStats());
        } else {
            DashboardStatsParser dashboardStatsParser = new DashboardStatsParser(dashboardStatsElement);
            statsSnapshot.setDashboardStats(dashboardStatsParser.getDashboardStats());
        }

        statistic.getStatsSnapshots().add(statsSnapshot);

        return statistic;
    }

    public Statistic getStatistic(User previouslyParsedUser) {
        StatsSnapshot statsSnapshot = new StatsSnapshot();

        Element timePeriodStatsElement = getTimePeriodStatsElement();
        Element dashboardStatsElement = getDashboardStatsElement();

        if (timePeriodStatsElement == null) {
            statsSnapshot.setTimePeriodStats(TimePeriodStatsParser.getEmptyTimePeriodStats());
        } else {
            TimePeriodStatsParser timePeriodStatsParser = new TimePeriodStatsParser(timePeriodStatsElement);
            statsSnapshot.setTimePeriodStats(timePeriodStatsParser.getTimePeriodStats());
        }

        if (dashboardStatsElement == null) {
            statsSnapshot.setDashboardStats(DashboardStatsParser.getEmptyDashboardStats());
        } else {
            DashboardStatsParser dashboardStatsParser = new DashboardStatsParser(dashboardStatsElement);
            statsSnapshot.setDashboardStats(dashboardStatsParser.getDashboardStats());
        }

        previouslyParsedUser.getStatistic().getStatsSnapshots().add(statsSnapshot);

        return previouslyParsedUser.getStatistic();
    }

    private Element getTimePeriodStatsElement() {
        return statisticElement.select(".time_period_large").first();
    }

    private Element getDashboardStatsElement() {
        return statisticElement.select("#div-mini-dashboard-expanded").first();
    }
}
