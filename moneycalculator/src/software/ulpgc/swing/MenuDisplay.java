package software.ulpgc.swing;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MenuDisplay extends JPanel {
    private JTextField actualcurrency;
    private JTextField newcurrency;

    private JComboBox<String> menuactualcurreny;
    private JComboBox<String> menunewcurreny;

    private List<String> CurrenciesList;
    public MenuDisplay(){

        this.CurrenciesList = new ArrayList<>();
        this.CurrenciesList = new CurrenciesList().getCurrencies();
        JPanel panel = new JPanel(new GridLayout(2, 2));

        add(panel);

        panel.add(ActualCurrency());
        panel.add(MenuActualcurreny());
        panel.add(NewCurrency());
        panel.add(MenuNewcurreny());



        getCurrenciesAmount(this.actualcurrency);
        getCurrenciesAmount(this.newcurrency);
        Changecurrency(this.menuactualcurreny);
        Changecurrency(this.menunewcurreny);


    }




    public JTextField getNewcurrency(){
        return this.newcurrency;
    }

    private Component NewCurrency() {
        this.newcurrency = new JTextField(20);
        this.newcurrency.setName("newcurrency");
        this.newcurrency.setEditable(false);
        return this.newcurrency;
    }

    private Component ActualCurrency() {
        this.actualcurrency = new JTextField(20);
        this.actualcurrency.setName("actualcurrency");
        return this.actualcurrency;
    }

    private Component MenuActualcurreny(){
        this.menuactualcurreny = new JComboBox<>(this.CurrenciesList.toArray(new String[0]));
        return this.menuactualcurreny;
    }

    private Component MenuNewcurreny(){
        this.menunewcurreny = new JComboBox<>(this.CurrenciesList.toArray(new String[0]));
        return this.menunewcurreny;
    }

    private void getCurrenciesAmount(JTextField valor) {
        valor.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizacontenido();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizacontenido();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizacontenido();
            }

            private void actualizacontenido(){
                if(valor.getName().equals(actualcurrency.getName())){
                    MoneyToClass money = new MoneyToClass();
                    money.setamount(valor.getText());
                    money.setCurrencyFrom((String) menuactualcurreny.getSelectedItem());
                    money.setCurrencyTo((String) menunewcurreny.getSelectedItem());
                    money.Calculate();
                    newcurrency.setText(Double.toString(money.getNewcurrency()));
                }
            }

        });
    }

    private void Changecurrency(JComboBox<String> menu){
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MoneyToClass money = new MoneyToClass();
                money.setamount(actualcurrency.getText());
                money.setCurrencyFrom((String) menuactualcurreny.getSelectedItem());
                money.setCurrencyTo((String) menunewcurreny.getSelectedItem());
                money.Calculate();
                newcurrency.setText(Double.toString(money.getNewcurrency()));
            }
        });
    }
}
