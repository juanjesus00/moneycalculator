package software.ulpgc.swing;

import software.ulpgc.moneycalculator.Money;
import software.ulpgc.moneycalculator.MoneyLoader;
import software.ulpgc.moneycalculator.TsvFileMoneyLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CurrenciesList {
    private List<String> Currencies;
    public CurrenciesList(){
        this.Currencies = new ArrayList<>();
        MoneyLoader moneyloader = new TsvFileMoneyLoader(new File("moneycalculator/currencies.tsv"));
        for (int i = 0; i < moneyloader.load().size(); i++){
            this.Currencies.add(moneyloader.load().get(i).getCurrency());
        }
    }

    public List<String> getCurrencies() {
        return Currencies;
    }
}
