public class CreditAccount extends Account {
    private double limit;

    public CreditAccount(User user, IBAN iban, BIC bic, double balance) {
        super(user, iban, bic, balance);
        limit = 1500;
    }
}
