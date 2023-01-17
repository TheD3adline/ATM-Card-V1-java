public class CreditAccount extends Account {
    private double limit;

    public CreditAccount(Owner owner, IBAN iban, BIC bic, double balance) {
        super(owner, iban, bic, balance);
        limit = 1500;
    }
}
