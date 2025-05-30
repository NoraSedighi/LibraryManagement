package management;

import datastructures.interfaces.Map;
import datastructures.maps.CustomHashMap;
import library.Book;
import library.Member;

public class BookManager {
    private Map<String, Book> books;
    private MemberManager memberManager;

    public BookManager(MemberManager memberManager) {
        this.books = new CustomHashMap<>();
        this.memberManager = memberManager;
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new NullPointerException("book must not be null");
        }
        books.put(book.getIsbn(), book);
    }

    public Book getBookByIsbn(String isbn) {
        return books.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {
        Book myBook = books.get(isbn);
        return myBook != null && myBook.isAvailable();
    }

    public void setBookAvailability(String isbn, boolean available) {
        Book b = books.get(isbn);
        if (b != null) {
            b.setAvailable(available);
        }
    }

    public void addToWaitlist(String isbn, String memberId) {
        Book b = books.get(isbn);
        Member m = memberManager.getMember(memberId);
        if (b != null && m != null)
            b.addToWaitlist(m);
    }

    public Member getNextFromWaitlist(String isbn) {
        Book b = books.get(isbn);
        if (b == null)
            return null;
        else
            return b.getNextInWaitlist();
    }

    public boolean hasWaitlist(String isbn) {
        Book b = books.get(isbn);
        return  b != null && b.hasWaitlist();
    }
}