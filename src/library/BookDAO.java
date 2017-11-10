package library;

import java.util.ArrayList;
import java.util.Date;

public class BookDAO {
    private ArrayList<Book> books = new ArrayList<>();

    public boolean addBook(Book book) {
        boolean flBook = false;
        if (book != null && findBookByCallNo(book.getCallNo()) == null) {
            books.add(book);
            return true;

        }
        System.err.println("Ошибка добавления книги в библиотеку");
        return flBook;
    }

    public Book findBookByCallNo(String callNo) {
        Book book = null;
        for (Book b : books) {
            if (b.getCallNo().equals(callNo))
                book = b;
        }
        return book;
    }

    private void issueBook(Book book) {
        book.setQuntity(book.getQuntity() - 1);
        book.setIssued(book.getIssued() + 1);
    }

    private boolean checkIssue(Book book) {
        boolean flBook = false;
        if (book.getQuntity() > 1) {
            flBook = true;
        }
        return flBook;
    }

    private boolean checkReturn(Book book) {
        boolean flBook = false;
        if (book.getIssued() > 1) {
            flBook = true;
        }
        return flBook;
    }

    private void returnBook(Book book) {
        book.setQuntity(book.getQuntity() + 1);
        book.setIssued(book.getIssued() - 1);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Book> getIssuedBooks() {
        ArrayList<Book> bookIssuedList = new ArrayList<>();
        for (Book book: books)
            if (book.getIssued()>0)
                bookIssuedList.add(book);
        return books;
    }

}
