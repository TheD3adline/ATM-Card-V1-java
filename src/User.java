/*
    Author: Michael Fessler
    Date: 2023/01/17
    Version: 0.1
    Description:
            Class with user data and relevant methods, such as stored accounts.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class User {
    private String firstName;
    private String lastName;
    private UserNumber userNumber;
    private String pin;
    private ArrayList<GiroAccount> giroList;
    private ArrayList<CreditAccount> creditList;
    private ArrayList<SavingsAccount> savingsList;
    private static HashMap<String, User> userMap = new HashMap<>();

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userNumber = assignUserNumber();
        this.pin = assignPin();
        this.giroList = new ArrayList<>();
        this.creditList = new ArrayList<>();
        this.savingsList = new ArrayList<>();
        userMap.put(this.userNumber.toString(), this);
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

    public static boolean checkLogin(String userNumber, String pin) {
        if(userMap.containsKey(userNumber)) {
            if(pin.equals(userMap.get(userNumber).getPin())) {
                System.out.println("Login successful! Welcome back " + userMap.get(userNumber).getFirstName() + "!");
                return true;
            }
        }
        System.out.println("User number or pin incorrect!");
        return false;
    }

    public boolean makeNewAccount() {
        System.out.println("1. Giro Account \n2. Credit Account \n3. Savings Account \n4. Return");
        switch(UserInput.getInputInt(1, 4)) {
            case 1: giroList.add(new GiroAccount(0)); return true;
            case 2: creditList.add(new CreditAccount(0)); return true;
            case 3: savingsList.add(new SavingsAccount(0)); return true;
            case 4: return false;
            default: System.err.println("Unknown Error!"); return false;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UserNumber getUserNumber() {
        return userNumber;
    }

    public String getPin() {
        return pin;
    }
}