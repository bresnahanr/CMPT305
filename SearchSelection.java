package cmpt305project;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class SearchSelection {
    final private Map<String, String> searchMap;
   

    public SearchSelection() {
        searchMap = new HashMap<>();
    }

    public void setbornCountryCode(String country) {
        searchMap.put("bornCountryCode", country);
    }
    public void setGender(String sex) {
        searchMap.put("gender", sex);
    }
    public void setdiedCountry(String country) {
        searchMap.put("diedCountry", country);
    }
    public void setCategory(String newCategory) {
        searchMap.put("category", newCategory);
    }
    public void setNumberOfLaureates(String number) {
        searchMap.put("numberOfLaureates", number);
    }
    public void setYear(String newYear) {
        searchMap.put("year", newYear);
    }
    public void setYearTo(String newYear) {
        searchMap.put("yearTo", newYear);
    }
    
    private String addToQueryString(String name, String variable) {
        return(name+"="+variable);
    }
    
    public String getQueryString() {
        StringBuilder finalBuildOfQueryString = new StringBuilder();
        Iterator<Map.Entry<String, String>> entries = searchMap.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry<String, String> entry = entries.next();
            finalBuildOfQueryString.append(addToQueryString(entry.getKey(), entry.getValue()));
            if (entries.hasNext()) {
                finalBuildOfQueryString.append("&");
            }
        }
        return(finalBuildOfQueryString.toString());
    }
    
    /*
    @Override
    public String toString()
    {
       
        
        
        return;
    }*/
    


}


