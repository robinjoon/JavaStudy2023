package week3;

import week3.dto.EmailData;
import week3.dto.WeatherData;

public class WeatherService {
    WeatherData getWeatherData(){
        return new WeatherData();
    }
    EmailData convertToEmailData(WeatherData weather){
        return new EmailData();
    }
}
