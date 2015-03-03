package ua.samosfator.stat.bean.statistic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StatsSnapshot {

    private TimePeriodStats timePeriodStats;
    private DashboardStats dashboardStats;
    private String updateTime;

    public StatsSnapshot() {
        this.updateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
    }

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

    public String getUpdateTime() {
        return updateTime;
    }
}
