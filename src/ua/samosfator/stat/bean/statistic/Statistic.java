package ua.samosfator.stat.bean.statistic;

import java.util.ArrayList;
import java.util.List;

public class Statistic {
    private List<StatsSnapshot> statsSnapshots = new ArrayList<>();

    public List<StatsSnapshot> getStatsSnapshots() {
        return statsSnapshots;
    }

    public void setStatsSnapshots(List<StatsSnapshot> statsSnapshots) {
        this.statsSnapshots = statsSnapshots;
    }

    public StatsSnapshot getFirstStatsSnapshot() {
        return statsSnapshots.get(0);
    }

    public StatsSnapshot getLastStatsSnapshot() {
        return statsSnapshots.get(statsSnapshots.size() - 1);
    }
}
