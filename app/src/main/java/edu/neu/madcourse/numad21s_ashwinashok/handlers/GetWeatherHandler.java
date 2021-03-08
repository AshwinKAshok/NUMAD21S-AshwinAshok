package edu.neu.madcourse.numad21s_ashwinashok.handlers;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import edu.neu.madcourse.numad21s_ashwinashok.models.GetWeatherMessage;
import edu.neu.madcourse.numad21s_ashwinashok.models.WeatherResponseMessage;
import edu.neu.madcourse.numad21s_ashwinashok.utils.GetWeatherThread;
import edu.neu.madcourse.numad21s_ashwinashok.utils.NetworkUtils;
import edu.neu.madcourse.numad21s_ashwinashok.views.WebServiceActivity;

public class GetWeatherHandler extends Handler {

    private MainThreadHandler mainThreadHandler;

    public GetWeatherHandler(@NonNull Looper looper, MainThreadHandler mainThreadHandler) {
        super(looper);
        this.mainThreadHandler = mainThreadHandler;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        GetWeatherMessage getWeatherMessage = (GetWeatherMessage) msg.obj;
        GetWeatherDataProcessor(getWeatherMessage);
    }

    private void GetWeatherDataProcessor(GetWeatherMessage getWeatherMessage) {

        String geocoding_url = getWeatherMessage.getGeocoding_url()
                + "/geocode/v1/json?q"
                + getLocationInCorrectFormat(getWeatherMessage.getLocation())
                + "&key="
                + getWeatherMessage.getGeocoding_api_key();

        Log.d("GEOCODING_URL", geocoding_url);

        try {
            URL geocoding_url_final = new URL(geocoding_url);
            String resp = NetworkUtils.httpResponse(geocoding_url_final);

            Log.d("GEOCODING RESPONSE..............:", resp);

            JSONObject jsonObject = new JSONObject(resp);
            JSONArray location_details_array = new JSONArray(jsonObject.getJSONArray("results"));

            if(location_details_array.length() == 0) {

            } else {
                JSONObject location_details = location_details_array.getJSONObject(0);
                JSONObject geomtric_details = location_details.getJSONObject("geometry");
                double latitude = location_details.getDouble("lat");
                double longitude = location_details.getDouble("lng");

                String weather_url = getWeatherMessage.getWeather_url()
                        + "/data/2.5/onecall?lat="
                        + Double.toString(latitude)
                        + "&lon="
                        + Double.toString(longitude)
                        + "&units=imperical"
                        + "&appid="
                        + getWeatherMessage.getWeather_api_key();

                URL weather_url_final = new URL(weather_url);
                String weather_resp = NetworkUtils.httpResponse(weather_url_final);

                Log.d("WEATHER URL........:", weather_url);
                Log.d("WEATHER RESP..............:", weather_resp);

                JSONObject weather_details_json_object = new JSONObject(weather_resp);
                JSONObject current_weather_json_object = weather_details_json_object.getJSONObject("current");

                String temp = current_weather_json_object.getString("temp");
                String feels_like = current_weather_json_object.getString("feels_like");

                JSONObject weather_description_json_object = current_weather_json_object.getJSONObject("weather");

                String weather_description = weather_description_json_object.getString("description");

                Message weather_data_message = Message.obtain();
                weather_data_message.obj = new WeatherResponseMessage(temp, feels_like, weather_description);
                mainThreadHandler.sendMessage(weather_data_message);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String getLocationInCorrectFormat(String location) {
        String[] parts = location.split(" ");
        return String.join("+", parts);
    }
}
