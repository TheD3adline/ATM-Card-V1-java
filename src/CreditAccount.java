/*
    Author: Michael Fessler
    Date: 2023/01/17
    Version: 0.1
    Description:
            Sub-Class of account with methods and attributes for the credit type.
 */
public class CreditAccount extends Account {
    private double limit = 1500;
    private String type = "Credit Account";

    public CreditAccount(double balance) {
        super(new IBAN(), new BIC(), balance);
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    @Override
    public void deposit(double deposition) {
        balance = balance + deposition;
        System.out.println("Successfully deposited €" + df2.format(deposition) + " to your " + type + " " + iban);
    }

    @Override
    public void withdraw(double withdrawal) {
        if(withdrawal < (balance + limit)) {
            balance = balance - withdrawal;
            System.out.println("Successfully deposited €" + df2.format(withdrawal) + " to your " + type + " " + iban);
        }
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double getLimit() {
        return limit;
    }
}