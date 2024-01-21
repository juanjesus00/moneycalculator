package software.ulpgc.moneycalculator;
import software.ulpgc.swing.*;

import javax.swing.*;
import java.util.List;

public class CurrencyCalculator{

    private double newcurrency;


    public CurrencyCalculator(Money from, String to, List<Money> moneyList){
        Calculator(from, to, moneyList);
    }


    private void Calculator(Money from, String to, List<Money> moneyList) {
        double amountFrom = 0;
        double amountTo = 0;

        for(Money dinero: moneyList){
            if(to.equals(dinero.getCurrency())) {
                amountTo = dinero.getAmount();

            }
        }

        for(Money dinero: moneyList){
            if(from.getCurrency().equals(dinero.getCurrency())) {
                amountFrom = dinero.getAmount();

            }
        }

        amountTo = from.getAmount() * (amountTo / amountFrom);

        System.out.println(from.getAmount() + " " + from.getCurrency() + " SON: " + amountTo + " " + to);
        this.newcurrency = amountTo;

        //new MenuDisplay().SetNewCurrency(Double.toString(this.newcurrency));

    }

    public double getCurrency() {
        return this.newcurrency;
    }


}
