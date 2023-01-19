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
                System.err.println("Invalid Input!");
                sc.next();
            }
            num = sc.nextInt();
            if(num < cLow || num > cHigh) {
                System.err.println("Invalid Input!");
            }
        } while(num < cLow || num > cHigh);
        return num;
    }
}
