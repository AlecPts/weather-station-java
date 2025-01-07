/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import ConnexionHTTP.Callback;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import javax.swing.ImageIcon;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author apeyt
 */
public class WeatherReport implements Callback  {
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
 
    }
}
