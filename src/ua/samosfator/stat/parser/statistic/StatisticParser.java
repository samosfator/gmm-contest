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

        TimePeriodStatsParser timePeriodStatsParser = new TimePeriodStatsParser(getTimePeriodStatsElement());
        DashboardStatsParser dashboardStatsParser = new DashboardStatsParser(getDashboardStatsElement());

        statistic.setTimePeriodStats(timePeriodStatsParser.getTimePeriodStats());
        statistic.setDashboardStats(dashboardStatsParser.getDashboardStats());

        return statistic;
    }

    private Element getTimePeriodStatsElement() {
        return statisticElement.select(".time_period_large").first();
    }

    private Element getDashboardStatsElement() {
        return statisticElement.getElementById("div-mini-dashboard-expanded");
    }
}
