package financetracker;


public class Receive extends Transaction {

    public Receive(double _amount, String _desc) {
        super(_amount, _desc);
    }

    // Polymorphism
    @Override
    public void display() {
        String output = String.format("%s: +$%.2f", getDescription(), getAmount());
        System.out.println(output);
      }
    
    // Polymorphism
    @Override
    public String saveableMessage() {
        String message = String.format("2<&>%s<&>%.2f", getDescription(), getAmount());
        return message;
   }
}
