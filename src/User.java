/*
    Author: Michael Fessler
    Date: 2023/01/17
    Version: 0.1
    Description:
            Class with user data and relevant methods, such as stored accounts.
 */
import java.util.ArrayList;

public class User {
    private static ArrayList<String> userNumbers;
    private String userNum;
    private String pin;
    private String firstName;
    private String lastName;
    private ArrayList<GiroAccount> giro;
    private ArrayList<CreditAccount> credit;
    private ArrayList<SavingsAccount> savings;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private static void assignUserNum() { //HERE I AM

    }
}