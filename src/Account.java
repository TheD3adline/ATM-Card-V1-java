/*
    Author: Michael Fessler
    Date: 2023/01/17
    Version: 0.1
    Description:
            Class with account relevant attributes and methods.
 */
public abstract class Account {
    private IBAN iban;
    private BIC bic;
    private double balance;

    public Account(IBAN iban, BIC bic, double balance) {
        this.iban = iban;
        this.bic = bic;
        this.balance = balance;
    }

    public void deposit(double deposition) {
        balance = balance + deposition;
        System.out.println("Successfully deposited ");
    }
}