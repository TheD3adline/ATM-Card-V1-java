/*
    Author: Michael Fessler
    Date: 2023/01/19
    Version: 0.1
    Description:
            Data type for the user number and methods to generate unique ones.
 */
import java.util.ArrayList;
import java.util.Random;

public class UserNumber {
    private static ArrayList<String> UserNumberReg = new ArrayList<>();
    private final String userNumber;

    public UserNumber() {
        this.userNumber = getUserNumber();
        UserNumberReg.add(this.userNumber);
    }

    private String getUserNumber() {
        Random rng = new Random();
        StringBuilder sb = new StringBuilder();
        do {
            for(int i = 0; i < 9; i++) {
                sb.append(rng.nextInt(10));
            }
            if(!isUnique(sb.toString())) {
                sb.delete(0, sb.length() - 1);
                sb.deleteCharAt(0);
            }
        } while(!isUnique(sb.toString()));
        return sb.toString();
    }

    private boolean isUnique(String userNumber) {
        for(int i = 0; i < UserNumberReg.size(); i++) {
            if(userNumber.equals(UserNumberReg.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return userNumber;
    }
}