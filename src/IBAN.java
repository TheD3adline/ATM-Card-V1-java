/*
    Author: Michael Fessler
    Date: 2023/01/17
    Version: 0.1
    Description:
            Class with methods for IBAN number creation.
 */
import java.util.ArrayList;
import java.util.Random;

public class IBAN {
    private static ArrayList<String> IBANReg = new ArrayList<>();
    private final String iban;

    public IBAN() {
        this.iban = getIban();
        IBANReg.add(this.iban);
    }

    private String getIban() {
        Random rng = new Random();
        StringBuilder sb = new StringBuilder();
        do {
            sb.append("AT00");
            for(int i = 0; i < 4; i++) {
                sb.append(rng.nextInt(10));
            }
            sb.append("0000");
            for(int i = 0; i < 8; i++) {
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
        for(int i = 0; i < IBANReg.size(); i++) {
            if(userNumber.equals(IBANReg.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return iban;
    }
}