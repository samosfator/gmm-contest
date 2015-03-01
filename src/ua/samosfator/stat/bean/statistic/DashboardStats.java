package ua.samosfator.stat.bean.statistic;

public class DashboardStats {

    private double roadLength;
    private int poi;
    private int businessListings;
    private double regions;
    private int featureEdits;

    public double getRoadLength() {
        return roadLength;
    }

    public void setRoadLength(double roadLength) {
        this.roadLength = roadLength;
    }

    public int getPoi() {
        return poi;
    }

    public void setPoi(int poi) {
        this.poi = poi;
    }

    public int getBusinessListings() {
        return businessListings;
    }

    public void setBusinessListings(int businessListings) {
        this.businessListings = businessListings;
    }

    public double getRegions() {
        return regions;
    }

    public void setRegions(double regions) {
        this.regions = regions;
    }

    public int getFeatureEdits() {
        return featureEdits;
    }

    public void setFeatureEdits(int featureEdits) {
        this.featureEdits = featureEdits;
    }
}
