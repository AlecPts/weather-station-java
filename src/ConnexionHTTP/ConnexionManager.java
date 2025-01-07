/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnexionHTTP;
/**
 *
 * @author apeyt
 */
public class ConnexionManager {
    
    public static final String URL_Weather = "https://api.openweathermap.org/data/2.5/weather?q=lyon,fr&units=metric&lang=fr&appid=xxxxx";
    private static ConnexionManager manager = null;
    private final Callback callWeather;

    private ConnexionManager(Callback callWeather){
        this.callWeather = callWeather;
    }
        
    public static ConnexionManager getConnexionManager(Callback callW){  // Point d'entrée du singleton : une seule instance possible
        if (manager==null){
            manager = new ConnexionManager(callW); // Appel du contructeur privé
        }
        return manager;
    }
    
    public void loadWeather() {
        ConnexionThread connexionThread = new ConnexionThread(callWeather, URL_Weather);
        connexionThread.start(); 
    }
}
