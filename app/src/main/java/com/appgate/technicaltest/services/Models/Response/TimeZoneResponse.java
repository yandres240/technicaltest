package com.appgate.technicaltest.services.Models.Response;

public class TimeZoneResponse {
    private String sunrise;
    private String lng;
    private String countryCode;
    private int gmtOffset;
    private int rawOffset;
    private String sunset;
    private String timezoneId;
    private int dstOffset;
    private String countryName;
    private String time;
    private String lat;

    public TimeZoneResponse(String sunrise, String lng, String countryCode, int gmtOffset, int rawOffset, String sunset, String timezoneId, int dstOffset, String countryName, String time, String lat) {
        this.sunrise = sunrise;
        this.lng = lng;
        this.countryCode = countryCode;
        this.gmtOffset = gmtOffset;
        this.rawOffset = rawOffset;
        this.sunset = sunset;
        this.timezoneId = timezoneId;
        this.dstOffset = dstOffset;
        this.countryName = countryName;
        this.time = time;
        this.lat = lat;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getGmtOffset() {
        return gmtOffset;
    }

    public void setGmtOffset(int gmtOffset) {
        this.gmtOffset = gmtOffset;
    }

    public int getRawOffset() {
        return rawOffset;
    }

    public void setRawOffset(int rawOffset) {
        this.rawOffset = rawOffset;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(String timezoneId) {
        this.timezoneId = timezoneId;
    }

    public int getDstOffset() {
        return dstOffset;
    }

    public void setDstOffset(int dstOffset) {
        this.dstOffset = dstOffset;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
