public class SavingsAccount extends Account {
    private double limit;

    public SavingsAccount(User user, IBAN iban, BIC bic, double balance) {
        super(user, iban, bic, balance);
        limit = 500;
    }
}
