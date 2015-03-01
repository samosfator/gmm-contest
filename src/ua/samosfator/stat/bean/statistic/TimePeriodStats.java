package ua.samosfator.stat.bean.statistic;

public class TimePeriodStats {

    private int days;
    private int totalEdits;
    private int approvedEdits;
    private int reviews;

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getTotalEdits() {
        return totalEdits;
    }

    public void setTotalEdits(int totalEdits) {
        this.totalEdits = totalEdits;
    }

    public int getApprovedEdits() {
        return approvedEdits;
    }

    public void setApprovedEdits(int approvedEdits) {
        this.approvedEdits = approvedEdits;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }
}
