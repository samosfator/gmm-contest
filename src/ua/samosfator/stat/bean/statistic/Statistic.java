package ua.samosfator.stat.bean.statistic;

public class Statistic {

    private TimePeriodStats timePeriodStats;
    private DashboardStats dashboardStats;

    public TimePeriodStats getTimePeriodStats() {
        return timePeriodStats;
    }

    public void setTimePeriodStats(TimePeriodStats timePeriodStats) {
        this.timePeriodStats = timePeriodStats;
    }

    public DashboardStats getDashboardStats() {
        return dashboardStats;
    }

    public void setDashboardStats(DashboardStats dashboardStats) {
        this.dashboardStats = dashboardStats;
    }
}
