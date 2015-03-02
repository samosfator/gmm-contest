package ua.samosfator.stat.parser.statistic;

import org.jsoup.nodes.Element;
import ua.samosfator.stat.bean.statistic.Statistic;

public class StatisticParser {

    private Element statisticElement;

    public StatisticParser(Element statisticElement) {
        this.statisticElement = statisticElement;
    }

    public Statistic getStatistic() {
        Statistic statistic = new Statistic();

        Element timePeriodStatsElement = getTimePeriodStatsElement();
        Element dashboardStatsElement = getDashboardStatsElement();

        if (timePeriodStatsElement == null) {
            statistic.setTimePeriodStats(TimePeriodStatsParser.getEmptyTimePeriodStats());
        } else {
            TimePeriodStatsParser timePeriodStatsParser = new TimePeriodStatsParser(timePeriodStatsElement);
            statistic.setTimePeriodStats(timePeriodStatsParser.getTimePeriodStats());
        }

        if (dashboardStatsElement == null) {
            statistic.setDashboardStats(DashboardStatsParser.getEmptyDashboardStats());
        } else {
            DashboardStatsParser dashboardStatsParser = new DashboardStatsParser(dashboardStatsElement);
            statistic.setDashboardStats(dashboardStatsParser.getDashboardStats());
        }

        return statistic;
    }

    private Element getTimePeriodStatsElement() {
        return statisticElement.select(".time_period_large").first();
    }

    private Element getDashboardStatsElement() {
        return statisticElement.select("#div-mini-dashboard-expanded").first();
    }
}
