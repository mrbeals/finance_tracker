package financetracker;


public class Spend extends Transaction {
    private String type;


    public Spend(double _amount, String _desc, String _type) {
        super(_amount, _desc);
        type = _type;
    }


    public void setType(int _type) {
        if (_type == 1) {
            type = "Groceries";
        } else if (_type == 2) {
            type = "Bills";
        } else if (_type == 3) {
            type = "Personal";
        } else if (_type == 4) {
            type = "Date";
        } else {
            type = "Other";
        }
    }

    public String getType() {
        return type;
    }

    // Polymorphism
    @Override
    public void display() {
        String output = String.format("%s: %s: -$%.2f", type, getDescription(), getAmount());
        System.out.println(output);
      }

    // Polymorphism
    @Override
    public String saveableMessage() {
        String message = String.format("1<&>%s<&>%.2f<&>%s", getDescription(), getAmount(), type);
        return message;
   }
}
