/*
    Author: Michael Fessler
    Date: 2023/01/17
    Version: 0.1
    Description:
            Class with account relevant attributes and methods.
 */
import java.text.DecimalFormat;

public abstract class Account {
    protected IBAN iban;
    protected BIC bic;
    protected double balance;
    protected static DecimalFormat df2 = new DecimalFormat();

    public Account(IBAN iban, BIC bic, double balance) {
        this.iban = iban;
        this.bic = bic;
        this.balance = balance;
    }

    public abstract void deposit(double deposition);
    public abstract void withdraw(double withdrawal);
    public abstract String getType();
    public abstract double getLimit();
}