/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import ConnexionHTTP.Callback;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import javax.swing.ImageIcon;

import ConnexionHTTP.ConnexionManager;
import ConnexionHTTP.ConnexionThread;
import com.mysql.cj.xdevapi.JsonParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author apeyt
 */
public class WeatherReport extends Observable implements Callback {
    String main, description;
    double temp, temp_min, temp_max;
    double lon, lat;
    ImageIcon icon;

    public WeatherReport() {
        temp=0.0;
        temp_min=0.0;
        temp_max=0.0;
        lon=0.0;
        lat=0.0;
        main = new String();
        description = new String();
        icon = null;
    }

    @Override
    public String toString() {
        return "WeatherReport{" + "main=" + main + ", description=" + description + ", temp=" + temp + ", temp_min=" + temp_min + ", temp_max=" + temp_max + ", lon=" + lon + ", lat=" + lat + '}';
    }

    public String getMain() {
        return main;
    }
    
    public String getDescription() {
        return description;
    }

    public double getTemp() {
        return temp;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }
    
    public ImageIcon getIcon() {
        return icon;
    }

    @Override
    public void onWorkDone(JSONObject jsonObj) throws JSONException{

        JSONObject mainJson = jsonObj.getJSONObject("main");
        JSONObject coordJson = jsonObj.getJSONObject("coord");
        JSONArray weatherJson = jsonObj.getJSONArray("weather");

        // Get main object data
        temp = mainJson.getDouble("temp");
        temp_min = mainJson.getDouble("temp_min");
        temp_max = mainJson.getDouble("temp_max");
        lon = coordJson.getDouble("lon");
        lat = coordJson.getDouble("lat");

        // Get weather object data
        main = weatherJson.getJSONObject(0).getString("main");
        description = weatherJson.getJSONObject(0).getString("description");

        System.out.println(this);

        setChanged();
        notifyObservers();
    }
}
