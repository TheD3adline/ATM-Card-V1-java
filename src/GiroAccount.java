/*
    Author: Michael Fessler
    Date: 2023/01/17
    Version: 0.1
    Description:
            Sub-Class of account with methods and attributes for the giro type.
 */
public class GiroAccount extends Account {
    private double limit = 1000;
    private String type = "Giro Account";

    public GiroAccount(double balance) {
        super(new IBAN(), new BIC(), balance);
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}