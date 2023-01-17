public abstract class Account {

    private final Owner owner;
    private final IBAN iban;
    private final BIC bic;
    private double balance;

    public Account(Owner owner, IBAN iban, BIC bic, double balance) {
        this.owner = owner;
        this.iban = iban;
        this.bic = bic;
        this.balance = balance;
    }
}
