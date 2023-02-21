/*
    Author: Michael Fessler
    Date: 2023/02/15
    Version: 0.1
    Description:
            Datatype for transactions.
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private double amount;
    private TransactionType transactionType;
    private LocalDateTime dateTime;
    private DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    public Transaction(double amount, TransactionType transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        if(transactionType == TransactionType.DEPOSITION) {
            return dateTime.format(dateTimeFormat) + " - " + ANSI_GREEN + amount + ANSI_RESET;
        } else if(transactionType == TransactionType.WITHDRAWAL) {
            return dateTime.format(dateTimeFormat) + " - " + ANSI_RED + amount + ANSI_RESET;
        }
        return dateTime.format(dateTimeFormat) + " - " + amount + "";
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}