package software.ulpgc.moneycalculator;

import java.util.Map;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class ExchangeRatesData {
    private final String json;
    public ExchangeRatesData(String json){
        this.json = json;
    }
    public JsonObject getJson(){
        return JsonParser.parseString(json).getAsJsonObject().getAsJsonObject("data");
    }
}

