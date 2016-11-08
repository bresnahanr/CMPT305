package GetData;

import com.google.gson.Gson;
import java.io.*;
import java.net.*;
import org.json.simple.JSONObject;


public class GetData {
    public static String getData(String urlToRead) throws MalformedURLException, IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();
    }
    
    public static void main(String[] args) throws MalformedURLException, IOException {
        //Laureate examples:
        String urlToRead = "http://api.nobelprize.org/v1/laureate.json?bornCountry=Canada&gender=female";
        System.out.println(getData(urlToRead));
        Gson gson = new Gson();
        String urlToRead2 = "http://api.nobelprize.org/v1/laureate.json?bornCountry=ireland&gender=male";
        System.out.println(getData(urlToRead2));
        //Prize examples:
        String urlToRead3 = "http://api.nobelprize.org/v1/prize.json?year=1996&numberOfLaureates=3";
        System.out.println(getData(urlToRead3));
        String urlToRead4 = "http://api.nobelprize.org/v1/prize.json?year=1996&yearTo=2016&category=physics&numberOfLaureates=3";
        System.out.println(getData(urlToRead4));
        //Country code
        String urlToRead5 = "http://api.nobelprize.org/v1/country.json";
        System.out.println(getData(urlToRead5));

        //gson.fromJson(getData(urlToRead), String);
        //JSONObject json = new JSONObject(getData(urlToRead));
    }
}
