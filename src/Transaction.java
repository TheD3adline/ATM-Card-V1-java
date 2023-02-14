/*
    Author: Michael Fessler
    Date: 2023/01/17
    Version: 0.1
    Description:
            Class with account relevant attributes and methods.
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private double transaction;
    private LocalDateTime dateTime;
    private DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    public Transaction(double transaction) {
        this.transaction = transaction;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        if(transaction > 0) {
            return dateTime.format(dateTimeFormat) + " - " + ANSI_GREEN + transaction + ANSI_RESET;
        } else if(transaction < 0) {
            return dateTime.format(dateTimeFormat) + " - " + ANSI_RED + transaction + ANSI_RESET;
        }
        return dateTime.format(dateTimeFormat) + " - " + transaction + "";
    }
}