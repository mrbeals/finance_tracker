package financetracker;
import java.util.List;
import java.util.Scanner;
public class Program {


    public static void main(String[] args) throws Exception {
        FileStore file = new FileStore();
        double startingBalance = file.startingBalanceLoad();
        List<Transaction> startingtransactions = file.loadTransactions(); 
        Account account = new Account(startingBalance, startingtransactions);
        account.initializeBalance();
        Scanner scanner = new Scanner(System.in);
        System.out.print("+------------------------------------------------+\n");
        System.out.print("|                  Welcome User                  |\n");
        System.out.print("+------------------------------------------------+\n");
        System.out.print("                                                  \n");
        wait(scanner);
        mainLoop(account, scanner);
        file.saveFile(account.getStarting(), account.getTransactionsList());


    }
    public static void mainLoop(Account account, Scanner scanner) {

        int input = 0;
        while (input != 5) {

            clearScreen();
            System.out.print("+------------------------------------------------+\n");
            System.out.print("|           What would you like to do?           |\n");
            System.out.print("|                                                |\n");
            System.out.print("| 1. First Time                                  |\n");
            System.out.print("| 2. Add Transaction                             |\n");
            System.out.print("| 3. View Balance                                |\n");
            System.out.print("| 4. View Transactions                           |\n");
            System.out.print("| 5. Exit                                        |\n");
            System.out.print("+------------------------------------------------+\n");
            System.out.print("                                                  \n");
            System.out.print("Selection: ");

            input = scanner.nextInt();
            scanner.nextLine();
            if (input == 1) {
                account.setStartingBalance(scanner);
            } else if (input == 2) {
                clearScreen();
                account.newtransaction(scanner);
            } else if (input == 3) {
                String output = String.format("Account Balance: $%.2f", account.getBalance());
                System.out.println(output);
                wait(scanner);
            } else if (input == 4) {
                account.displayTransactions();
                wait(scanner);
            } else if (input == 5) {
                return;
            }


        }
    }
    public static void clearScreen() {  

        // Clears terminal and returns home
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }  

    public static void wait(Scanner scanner) {

        // allows user to view output before terminal is cleared once again.
        scanner.nextLine();
    }

}
