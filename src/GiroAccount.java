public class GiroAccount extends Account {
    private double limit;

    public GiroAccount(User user, IBAN iban, BIC bic, double balance) {
        super(user, iban, bic, balance);
        limit = 1000;
    }
}
