package library;

import java.util.ArrayList;
import java.util.Date;

public class BookDAO {
    private ArrayList<Book> books = new ArrayList<>();

    public boolean addBook(Book book) {
        boolean flBook = false;
        if (book != null) {
            books.add(book);
            return true;

        }
        System.err.println("Ошибка добавления книги в библиотеку");
        return flBook;
    }

    public Book findFreeBookByCallNo(String callNo) {
        for (Book b : books) {
            if (b.getCallNo().equals(callNo) && !b.getIssued())
                return b;
        }

        System.out.println("Нет свободных книг " + callNo);
        return null;
    }

    public Book findIssuedBookByCallNo(String callNo) {
        for (Book b : books) {
            if (b.getCallNo().equals(callNo) && b.getIssued())
                return b;
        }

        System.out.println("Данная книга " + callNo + " не выдавалась");
        return null;
    }

    public void issueBook(String callNo) {
        Book book = findFreeBookByCallNo(callNo);
        book.setIssued(true);
    }

    public boolean checkIssue(String callNo) {
        Book book = findFreeBookByCallNo(callNo);
        if (book != null && !book.getIssued()) {
            return true;
        }
        System.out.println("Недостаточное количество для выдачи книг " + callNo);
        return false;
    }

    public boolean checkReturn(String callNo) {
        Book book = findIssuedBookByCallNo(callNo);
        if (book != null && book.getIssued()) {
            return true;
        }
        System.out.println("Недостаточное количество для возврата книг " + callNo);
        return false;
    }

    public void returnBook(String callNo) {
        Book book = findIssuedBookByCallNo(callNo);
        book.setIssued(false);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Book> getIssuedBooks() {
        ArrayList<Book> bookIssuedList = new ArrayList<>();
        for (Book book : books)
            if (book.getIssued())
                bookIssuedList.add(book);
        return bookIssuedList;
    }

}
