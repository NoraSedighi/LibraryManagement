package library;

import datastructures.interfaces.LinkedList;
import datastructures.lists.CustomLinkedList;

public class Member {
    private String memberId;
    private String name;
    private LinkedList<Transaction> transactions;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.transactions = new CustomLinkedList<>();
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public void addTransaction(Transaction transaction) {
        if (transaction == null) {
            throw new NullPointerException("transaction must not be null");
        }
        transactions.addLast(transaction);
    }

    public Transaction getLastTransaction() {
        if (transactions.isEmpty())
            return null;
        else
            return transactions.getLast();
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
