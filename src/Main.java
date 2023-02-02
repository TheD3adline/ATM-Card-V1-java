/*
    Author: Michael Fessler
    Date: 2023/01/17
    Version: 0.1
    Description:
            Bank account practice app.
 */
public class Main {
    public static void main(String[] args) {

        User user = new User("Michael", "Fessler");
        System.out.println("Hello " + user.getFirstName() + " " + user.getLastName() + "!\n" +
                "For practice purposes: Your user number is " + user.getUserNumber() + ", " +
                "and your pin for the login is " + user.getPin());

        if (User.checkLogin(UserInput.getStringInput("Enter User Number: "),
                UserInput.getStringInput("Enter Pin: "))) {
            if(user.makeNewAccount()) {
                System.out.println("yay");
            } else {
                System.out.println("nay");
            }
        }
    }
}