/*
    Author: Michael Fessler
    Date: 2023/01/19
    Version: 0.1
    Description:
            Class to handle all user inputs.
 */
import java.util.Scanner;
public class UserInput {
    private static final Scanner sc = new Scanner(System.in);

    public static int getInputInt(int cLow, int cHigh) {
        int num;
        do {
            while(!sc.hasNextInt()) {
                sc.next();
                System.err.println("Invalid Input!");
            }
            num = sc.nextInt();
            if(num < cLow || num > cHigh) {
                System.err.println("Invalid Input!");
            }
        } while(num < cLow || num > cHigh);
        return num;
    }
    public static int getMenuInput(int cLow, int cHigh) {
        int num;
        do {
            System.out.print("\nPlease select menu point! (Input ");
            for(int i = cLow; i <= cHigh; i++) {
                System.out.print(i + ", ");
            }
            System.out.print("): ");
            while(!sc.hasNextInt()) {
                sc.next();
                System.err.println("Invalid Input!");
                System.out.print("\nPlease select menu point! (Input ");
                for(int i = cLow; i <= cHigh; i++) {
                    System.out.print(i + ", ");
                }
                System.out.print("): ");
            }
            num = sc.nextInt();
            if(num < cLow || num > cHigh) {
                System.err.println("Invalid Input!");
            }
        } while(num < cLow || num > cHigh);
        return num;
    }

    public static String getStringInput(String prompt) {
        System.out.print("\n" + prompt);
        return sc.next();
    }
}
