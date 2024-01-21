package software.ulpgc.swing;
import software.ulpgc.swing.MenuDisplay;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private MenuDisplay menu;
    public MainFrame () throws HeadlessException {
        setTitle("MoneyCalculator");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //cargamos el logo de la carpeta sources
        ImageIcon logoIcon = new ImageIcon("D:\\TERCERO\\PRIMER SEMESTRE\\IS2\\Practicas de aula\\moneycalculator v1-20231018\\moneycalculator\\sources\\Fyxa8k_WIAYeOLD.jpeg");
        setIconImage(logoIcon.getImage());

        add(CreateMenuDisplay());

    }

    private Component CreateMenuDisplay(){
        MenuDisplay display = new MenuDisplay();
        menu = display;
        return display;
    }

    public MenuDisplay menuDisplay(){
        return menu;
    }

}
