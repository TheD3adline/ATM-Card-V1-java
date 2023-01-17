public class SavingsAccount extends Account {
    private double limit;

    public SavingsAccount(Owner owner, IBAN iban, BIC bic, double balance) {
        super(owner, iban, bic, balance);
        limit = 500;
    }
}
