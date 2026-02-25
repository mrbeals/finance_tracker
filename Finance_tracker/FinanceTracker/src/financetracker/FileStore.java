package financetracker;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.*;

public class FileStore {
    private String fileName;

    public FileStore() {
        fileName = "src\\financetracker\\transactionsSave.txt";
    }
    public double startingBalanceLoad() throws Exception {
        List<String> lines = Files.readAllLines(Path.of(fileName));

        for (String line : lines) {
            String[] piece = line.split("<&>");
            if ("0".equals(piece[0])) {

                double startbalance = Double.parseDouble(piece[1]);
                return startbalance;
            }
        }
        return 0.0;
    }
    public List<Transaction> loadTransactions() throws Exception {
        List<Transaction> transactions = new ArrayList<>();
        List<String> lines = Files.readAllLines(Path.of(fileName));
        for (String line : lines) {
            String[] piece = line.split("<&>");
            if ("1".equals(piece[0])) {
                Spend spend = new Spend(Double.parseDouble(piece[2]),piece[1],piece[3]);
                transactions.add(spend);
            } else if ("2".equals(piece[0])) {
                Receive receive = new Receive(Double.parseDouble(piece[2]),piece[1]);
                transactions.add(receive);
            }
        }
        return transactions;
    }
    public void saveFile(double start, List<Transaction> transactions) throws Exception {
        String startString = String.format("0<&>%.2f", start);
        List<String> lines = new ArrayList<>();
        lines.add(startString);

        for (Transaction T : transactions) {
            lines.add(T.saveableMessage());
        }
        Files.write(Path.of(fileName), lines);
    }

}
