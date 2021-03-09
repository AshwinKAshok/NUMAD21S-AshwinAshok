package edu.neu.madcourse.numad21s_ashwinashok.models;

public class WeatherResponseMessage {
    private String temp;
    private String feels_like;
    private String description;
    private String location;

    public WeatherResponseMessage(String temp, String feels_like, String description, String location) {
        this.temp = temp;
        this.feels_like = feels_like;
        this.description = description;
        this.location = location;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(String feels_like) {
        this.feels_like = feels_like;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
