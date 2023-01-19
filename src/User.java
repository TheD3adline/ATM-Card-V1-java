/*
    Author: Michael Fessler
    Date: 2023/01/17
    Version: 0.1
    Description:
            Class with user data and relevant methods, such as stored accounts.
 */
import java.util.ArrayList;
import java.util.Random;

public class User {
    private String firstName;
    private String lastName;
    private UserNumber userNumber;
    private String pin;
    private ArrayList<GiroAccount> giro;
    private ArrayList<CreditAccount> credit;
    private ArrayList<SavingsAccount> savings;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userNumber = assignUserNumber();
        this.pin = assignPin();
    }

    private UserNumber assignUserNumber() {
        return new UserNumber();
    }

    private String assignPin() {
        Random rng = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++) {
            sb.append(rng.nextInt(10));
        }
        return sb.toString();
    }

    public boolean makeNewAccount() {
        System.out.println("1. Giro Account \n2. Credit Account \n3. Savings Account \n4. Return");
        switch(UserInput.getInputInt(1, 4)) {
            case 1: giro.add(new GiroAccount(0)); return true;
            case 2: credit.add(new CreditAccount(0)); return true;
            case 3: savings.add(new SavingsAccount(0)); return true;
            case 4: return false;
            default: System.err.println("Unknown Error!"); return false;
        }
    }
}