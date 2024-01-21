package software.ulpgc.moneycalculator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonElement;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import software.ulpgc.swing.MainFrame;
import software.ulpgc.swing.MoneyToClass;

public class Main {
    public static void main(String[] args) {

        MainFrame frame = new MainFrame();
        frame.menuDisplay();
        frame.setVisible(true);
        MoneyToClass moneytoclass = new MoneyToClass();


        MoneyLoader moneyloader = new TsvFileMoneyLoader(new File("moneycalculator/currencies.tsv"));
        List<Money> money = moneyloader.load();

        //probar en enviar la lista de currencies a menu display y luego a money to class 






        //fragmento de código para  la obtencion de los datos para la api, a parte de pasarlos a aun archivo .tsv

        /*OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://api.freecurrencyapi.com/v1/latest?apikey=fca_live_U7q9960B9Sezwqtka8pHO7hSHi4JXO5ZRzuHkugf").build();
        String fileName = "moneycalculator/currencies.tsv";
        try {
            FileWriter fileWriter = new FileWriter(fileName);

            // Crea un BufferedWriter para escribir datos de manera eficiente
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String json = response.body().string();
                Gson gson = new Gson();
                ExchangeRatesData exchangeRatesData = new ExchangeRatesData(json);

                Set<Map.Entry<String, JsonElement>> entrySet = exchangeRatesData.getJson().entrySet();
                for(Map.Entry<String, com.google.gson.JsonElement> entry : entrySet){
                    String key = entry.getKey();
                    com.google.gson.JsonElement value = entry.getValue();
                    bufferedWriter.write(key + " " + value + "\n");
                }
                bufferedWriter.close();
                fileWriter.close();
            } else {
                System.err.println("Failed to fetch exchange rates: " + response.code() + " - " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
