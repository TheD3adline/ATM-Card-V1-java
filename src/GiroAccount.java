public class GiroAccount extends Account {
    private double limit;

    public GiroAccount(Owner owner, IBAN iban, BIC bic, double balance) {
        super(owner, iban, bic, balance);
        limit = 1000;
    }
}
