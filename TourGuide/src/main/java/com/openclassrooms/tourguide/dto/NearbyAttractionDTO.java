package com.openclassrooms.tourguide.dto;

import gpsUtil.location.Location;

public class NearbyAttractionDTO {
    private String attractionName;
    private Location attractionLocation;
    private Location userLocation;
    private double distanceMiles;
    private int rewardPoints;

    /**
     * Data Transfer Object (DTO) representing a nearby attraction for a user.
     * It contains the attraction details, the user's location, the distance between
     * them,
     * and the reward points associated with the attraction.
     */
    public NearbyAttractionDTO(String attractionName, Location attractionLocation, Location userLocation,
            double distanceMiles, int rewardPoints) {
        this.attractionName = attractionName;
        this.attractionLocation = attractionLocation;
        this.userLocation = userLocation;
        this.distanceMiles = distanceMiles;
        this.rewardPoints = rewardPoints;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public Location getAttractionLocation() {
        return attractionLocation;
    }

    public void setAttractionLocation(Location attractionLocation) {
        this.attractionLocation = attractionLocation;
    }

    public Location getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(Location userLocation) {
        this.userLocation = userLocation;
    }

    public double getDistanceMiles() {
        return distanceMiles;
    }

    public void setDistanceMiles(double distanceMiles) {
        this.distanceMiles = distanceMiles;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
}