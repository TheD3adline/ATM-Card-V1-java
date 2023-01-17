import java.util.ArrayList;

public class User {

    private String firstName;
    private String lastName;
    private ArrayList<GiroAccount> giro;
    private ArrayList<CreditAccount> credit;
    private ArrayList<SavingsAccount> savings;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
