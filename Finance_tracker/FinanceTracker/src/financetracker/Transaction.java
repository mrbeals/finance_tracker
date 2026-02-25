package financetracker;

public class Transaction {
   private double amount;
   private String description;

   public Transaction(double _amount, String _description) {
      amount = _amount;
      description = _description;
   }

   public void setAmount(double _amount) {
      amount = _amount;
   }
   public double getAmount() {
      return amount;
   }
   public void setDescription(String _desc) {
      description = _desc;
   }
   public String getDescription() {
      return description;
   }

   // provides a display
   public void display() {
      String output = String.format("%s: $%.2f", getDescription(), getAmount());
      System.out.println(output);
   }

   // Writes the information in a format that can be saved and loaded into a txt file.
   public String saveableMessage() {
      String message = String.format("2<&>%s<&>%.2f", getDescription(), getAmount());
      return message;
   }
}
