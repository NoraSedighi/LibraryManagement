package management;

import library.Book;
import library.Member;
import library.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionManager {
    private List<Transaction> transactions;

    public TransactionManager() {
        this.transactions = new ArrayList<>();
    }

    public Transaction addTransaction(String bookTitle, String memberName, String type) {

        Transaction transaction = new Transaction(
                "TXN-" + new Date().getTime(),
                bookTitle,
                memberName,
                type
        );

        transactions.add(transaction);
        return transaction;
    }

    public Transaction getTransactionByIndex(int index) {
        if (index < 0 || index >= transactions.size())
            return null;
        else
            return transactions.get(index);
    }
}
