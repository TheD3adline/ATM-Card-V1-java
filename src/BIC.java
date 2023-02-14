/*
    Author: Michael Fessler
    Date: 2023/01/17
    Version: 0.1
    Description:
            Class with methods for BIC number creation.
 */
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class BIC {
    private final String bic;

    public BIC() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
        LocalDateTime year = LocalDateTime.now();
        this.bic = "AUTBBRZ" + dtf.format(year);
    }

    @Override
    public String toString() {
        return bic;
    }
}