package financetracker;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Account {
    private List<Transaction> transactions = new ArrayList<>();
    double startingBalance;
    double accountBalance;

    public Account() {
        transactions = new ArrayList<>();
        startingBalance = 0;
        accountBalance = 0;
    }
    public Account(double _startingBalance, List<Transaction> _transactions) {
        transactions = _transactions;
        startingBalance = _startingBalance;
        accountBalance = 0;
    }
    public void initializeBalance() {
        accountBalance = startingBalance;
        for (Transaction T : transactions) {
            if (T instanceof Spend) {
                accountBalance -= T.getAmount();
            } else if (T instanceof Receive) {
                accountBalance += T.getAmount();
            }
        }
   }

    public List<Transaction> getTransactionsList() {
        return transactions;
    }

    public double getBalance() {
        return accountBalance;
   }

   // Adds a transaction to the list, and actualizes it's value.
   public void addTransaction(Transaction T) {
        transactions.add(T);
        if (T instanceof Spend) {
            accountBalance -= T.getAmount();
        } else if (T instanceof Receive) {
            accountBalance += T.getAmount();
        }
   }

   // Sets starting value
   public void setStartingBalance(Scanner scan) {

        System.out.print("\n");
        System.out.print("Starting Balance: ");
        startingBalance = scan.nextDouble();
        accountBalance += startingBalance;
        scan.nextLine();
        

   }

   // Determines type
    public String returnType(int _type) {
        if (_type == 1) {
           return "Groceries";
        } else if (_type == 2) {
            return "Bills";
        } else if (_type == 3) {
            return "Personal";
        } else if (_type == 4) {
            return "Date";
        } else {
            return "Other";
        }
    }

    // Adds a new transaction to the list
    public void newtransaction(Scanner scan) {

        System.out.print("\n");

        System.out.print("+------------------------------------------------+\n");
        System.out.print("|             What type of transaction?          |\n");
        System.out.print("|                                                |\n");
        System.out.print("| 1. Expendature                                 |\n");
        System.out.print("| 2. Income                                      |\n");
        System.out.print("+------------------------------------------------+\n");
        System.out.print("\n");
        System.out.print("Selection: ");
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
            System.out.print("+------------------------------------------------+\n");
            System.out.print("|            What type of Expendature?           |\n");
            System.out.print("|                                                |\n");
            System.out.print("| 1. Groceries                                   |\n");
            System.out.print("| 2. Bills                                       |\n");
            System.out.print("| 3. Personal                                    |\n");
            System.out.print("| 4. Date                                        |\n");
            System.out.print("+------------------------------------------------+\n");

            System.out.print("\n");
            System.out.print("Type: ");

            int _type = scan.nextInt();
            scan.nextLine();

            System.out.print("Amount: ");
            double _amount = scan.nextDouble();
            scan.nextLine();
            System.out.print("Desciption: ");
            String _Description = scan.nextLine();
            Spend spend = new Spend(_amount, _Description, returnType(_type));
            addTransaction(spend);


        } else if (choice == 2) {
            System.out.print("Amount: ");
            double _amount = scan.nextDouble();
            scan.nextLine();
            System.out.print("Desciption: ");
            String _Description = scan.nextLine();
            Receive receive = new Receive(_amount, _Description);
            addTransaction(receive);
        }       
    }
    public double getStarting() {
        return startingBalance;
    }

    // Displays all transactions
    public void displayTransactions() {
        for (Transaction T : transactions) {
            T.display();
        }
    }

    
}
