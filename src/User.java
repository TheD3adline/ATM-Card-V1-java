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
    private String pin;
    private ArrayList<GiroAccount> giroList;
    private ArrayList<CreditAccount> creditList;
    private ArrayList<SavingsAccount> savingsList;


    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = assignPin();
        this.giroList = new ArrayList<>();
        this.creditList = new ArrayList<>();
        this.savingsList = new ArrayList<>();
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
        if(Main.userMap.containsKey(userNumber)) {
            if(pin.equals(Main.userMap.get(userNumber).getPin())) {
                System.out.println("Login successful! Welcome back " + Main.userMap.get(userNumber).getFirstName() + "!");
                Main.activeUser = Main.userMap.get(userNumber);
                return true;
            }
        }
        System.out.println("User number or pin incorrect!");
        return false;
    }

    public void makeNewAccount() {
        System.out.println("1. Giro Account \n2. Credit Account \n3. Savings Account \n4. Return");
        switch (UserInput.getMenuInput(1, 3)) {
            case 1 -> giroList.add(new GiroAccount(0));
            case 2 -> creditList.add(new CreditAccount(0));
            case 3 -> savingsList.add(new SavingsAccount(0));
            default -> System.err.println("Unknown Error!");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPin() {
        return pin;
    }
}