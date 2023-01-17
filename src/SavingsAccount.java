/*
    Author: Michael Fessler
    Date: 2023/01/17
    Version: 0.1
    Description:
            Sub-Class of account with methods and attributes for the savings type.
 */
public class SavingsAccount extends Account {
    private double limit = 500;

    public SavingsAccount(User user, IBAN iban, BIC bic, double balance) {
        super(user, iban, bic, balance);
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}