package software.ulpgc.moneycalculator;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class TsvFileMoneyLoader implements MoneyLoader{
    private final File file;


    public TsvFileMoneyLoader(File file) {
        this.file = file;
    }
    @Override
    public List<Money> load() {
        try {
            return load(new FileReader(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Money> load(FileReader reader) throws IOException {
        return load(new BufferedReader(reader));
    }

    private List<Money> load(BufferedReader reader) throws IOException {
        List<Money> result = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            result.add(toMoney(line));
        }
        return result;
    }

    private Money toMoney(String line) {
        return toMoney(line.split(" "));
    }

    private Money toMoney(String[] fields) {
        return new Money(Double.parseDouble(fields[1]), fields[0]);
    }
}
