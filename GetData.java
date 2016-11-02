package cmpt305project;

import java.io.*;
import java.net.*;


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
        //Will require the stringbuilder class to construct a url. Currently hardcoded for female from Canada
        
        String urlToRead = "http://api.nobelprize.org/v1/laureate.json?";
        SearchSelection howToJava  = new SearchSelection();
        howToJava.setGender("male");
        howToJava.setbornCountryCode("ca");
        urlToRead+=howToJava.getQueryString();
        System.out.println(getData(urlToRead));
    }
}
