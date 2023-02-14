/*
    Author: Michael Fessler
    Date: 2023/01/17
    Version: 0.1
    Description:
            Class with user data and relevant methods, such as stored accounts.
 */
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class User {
    private String firstName;
    private String lastName;
    private String pin;
    private ArrayList<GiroAccount> giroList;
    private ArrayList<CreditAccount> creditList;
    private ArrayList<SavingsAccount> savingsList;
    private static DecimalFormat df2 = new DecimalFormat();


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
                System.out.println("Login successful! Welcome back " +
                                    Main.userMap.get(userNumber).getFirstName() + "!");
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

    public void accountsMenu() {
        System.out.println("""
                Select account type:\s
                1. Giro Accounts\s
                2. Credit Accounts\s
                3. Savings Accounts""");
        switch(UserInput.getMenuInput(1,3)) {
            case 1 -> {
                if(giroList.size() > 0) {
                    accessGiroAccounts(giroList);
                } else {
                    System.out.println("You do not have any giro accounts!");
                }
            }
            case 2 -> {
                if(creditList.size() > 0) {
                    accessCreditAccounts(creditList);
                } else {
                    System.out.println("You do not have any credit accounts!");
                }
            }
            case 3 -> {
                if(savingsList.size() > 0) {
                    accessSavingsAccounts(savingsList);
                } else {
                    System.out.println("You do not have any savings accounts!");
                }
            }
        }
    }

    public void accessGiroAccounts(ArrayList<GiroAccount> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            System.out.println((i + 1) + ". " + list.get(i).getType() + " " + list.get(i).iban.toString() +
                                " Balance: €" + df2.format(list.get(i).balance) + "|| Limit: €" +
                                (df2.format(list.get(i).getLimit() * -1)) +
                                "|| Total: €" + df2.format(list.get(i).balance + list.get(i).getLimit()));
        }
    }

    public void accessCreditAccounts(ArrayList<CreditAccount> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            System.out.println((i + 1) + ". " + list.get(i).getType() + " " + list.get(i).iban.toString() +
                                " Balance: €" + df2.format(list.get(i).balance) + "|| Limit: €" +
                                (df2.format(list.get(i).getLimit() * -1)) +
                                "|| Total: €" + df2.format(list.get(i).balance + list.get(i).getLimit()));
        }
    }

    public void accessSavingsAccounts(ArrayList<SavingsAccount> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            System.out.println((i + 1) + ". " + list.get(i).getType() + " " + list.get(i).iban.toString() +
                    " Balance: €" + df2.format(list.get(i).balance));
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