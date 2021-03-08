package edu.neu.madcourse.numad21s_ashwinashok.models;

public class GetWeatherMessage {

    private String geocoding_url;
    private String geocoding_api_key;
    private String location;
    private String weather_url;
    private String weather_api_key;

    public GetWeatherMessage(String geocoding_url, String geocoding_api_key, String location, String weather_url, String weather_api_key) {
        this.geocoding_url = geocoding_url;
        this.geocoding_api_key = geocoding_api_key;
        this.location = location;
        this.weather_url = weather_url;
        this.weather_api_key = weather_api_key;
    }

    public String getGeocoding_url() {
        return geocoding_url;
    }

    public void setGeocoding_url(String geocoding_url) {
        this.geocoding_url = geocoding_url;
    }

    public String getGeocoding_api_key() {
        return geocoding_api_key;
    }

    public void setGeocoding_api_key(String geocoding_api_key) {
        this.geocoding_api_key = geocoding_api_key;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWeather_url() {
        return weather_url;
    }

    public void setWeather_url(String weather_url) {
        this.weather_url = weather_url;
    }

    public String getWeather_api_key() {
        return weather_api_key;
    }

    public void setWeather_api_key(String weather_api_key) {
        this.weather_api_key = weather_api_key;
    }
}
