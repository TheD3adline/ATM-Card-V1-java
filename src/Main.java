/*
    Author: Michael Fessler
    Date: 2023/01/17
    Version: 0.1
    Description:
            Bank account practice app.
 */
import java.util.HashMap;

public class Main {
    public static HashMap<String, User> userMap = new HashMap<>();
    public static User activeUser;

    public static void main(String[] args) {

        while(true) {
            UserInterface.printMainUI();
            switch(UserInput.getMenuInput(1,3)) {
                case 1:
                    String userNum = new UserNumber().toString();
                    userMap.put(userNum, new User(UserInput.getStringInput("Enter First Name: "),
                            UserInput.getStringInput("Enter Last Name: ")));
                    System.out.println("Successfully registered user! Welcome " + userMap.get(userNum).getFirstName() +
                            " " + userMap.get(userNum).getLastName() + "! Your user number is: " + userNum +
                            " and your pin: " + userMap.get(userNum).getPin() + " \nPlease write them down " +
                            "as retrieval can only be done via official photo ID! ");
                    break;
                case 2:
                    boolean flag;
                    if (User.checkLogin(UserInput.getStringInput("Enter User Number: "),
                            UserInput.getStringInput("Enter Pin: "))) {
                        flag = false;
                        do {
                            UserInterface.printUserUI();
                            switch (UserInput.getMenuInput(1, 7)) {
                                case 1 -> activeUser.makeNewAccount();
                                case 2 -> activeUser.accountsMenu("Enter amount to deposit: ",
                                                                    TransactionType.DEPOSITION);
                                case 3 -> activeUser.accountsMenu("Enter amount to withdraw (min €10,-): ",
                                                                    TransactionType.WITHDRAWAL);
                                //case 4 -> account statement;
                                //case 5 -> suspend account;
                                case 6 -> {
                                    System.out.println("Logging out...");
                                    flag = true;
                                }
                                case 7 -> System.exit(0);
                            }
                        } while (!flag);
                        activeUser = null;
                    }
                    break;
                case 3: System.exit(0);
            }
        }
    }
}