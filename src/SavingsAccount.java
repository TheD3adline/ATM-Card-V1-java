/*
    Author: Michael Fessler
    Date: 2023/01/17
    Version: 0.1
    Description:
            Sub-Class of account with methods and attributes for the savings type.
 */
public class SavingsAccount extends Account {
    private double limit = 0;

    public SavingsAccount(double balance) {
        super(new IBAN(), new BIC(), balance);
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}