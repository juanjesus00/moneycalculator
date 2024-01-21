package software.ulpgc.swing;

import software.ulpgc.moneycalculator.CurrencyCalculator;
import software.ulpgc.moneycalculator.Money;
import software.ulpgc.moneycalculator.MoneyLoader;
import software.ulpgc.moneycalculator.TsvFileMoneyLoader;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MoneyToClass{
    private String actualamount;
    private double newcurrency;
    private List<Money> money;
    private String currencyFrom;
    private String currencyTo;

    public MoneyToClass (){

        MoneyLoader moneyloader = new TsvFileMoneyLoader(new File("moneycalculator/currencies.tsv"));
        this.money =  moneyloader.load();
    }

    public void setamount(String actualamount) {
        this.actualamount = actualamount;
    }

    public void setCurrencyFrom(String valor){
        this.currencyFrom = valor;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public double getNewcurrency() {
        return newcurrency;
    }

    public void Calculate(){
        if(!this.actualamount.isEmpty()){
            System.out.println("se imprime");
            this.newcurrency = new CurrencyCalculator(new Money(Double.parseDouble(this.actualamount), this.currencyFrom), this.currencyTo, this.money).getCurrency();

        }else{
            System.out.println("esta vacio");
        }
    }
}
