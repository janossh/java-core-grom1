package library;

import java.util.ArrayList;
import java.util.Date;

public class BookDAO {
    private ArrayList<Book> books = new ArrayList<>();

    public boolean addBook(Book book) {
        boolean flBook = false;
        if (book != null && findBookByCallNo(book.getCallNo(), true) == null) {
            books.add(book);
            return true;

        }
        System.err.println("Ошибка добавления книги в библиотеку");
        return flBook;
    }

    public Book findBookByCallNo(String callNo, boolean thisAdd) {
        Book book = null;
        for (Book b : books) {
            if (b.getCallNo().equals(callNo))
                return b;
        }
        if (!thisAdd)
            System.err.println("Данная книга " + callNo + " не найдена в каталоге");
        return book;
    }

    public void issueBook(String callNo) {
        Book book = findBookByCallNo(callNo, false);
        book.setQuntity(book.getQuntity() - 1);
        book.setIssued(book.getIssued() + 1);
    }

    public boolean checkIssue(String callNo) {
        Book book = findBookByCallNo(callNo, false);
        if (book != null && book.getQuntity() >= 1) {
            return true;
        }
        System.out.println("Недостаточное количество для выдачи книг " + callNo);
        return false;
    }

    public boolean checkReturn(String callNo) {
        Book book = findBookByCallNo(callNo, false);
        if (book != null && book.getIssued() >= 1) {
            return true;
        }
        System.out.println("Недостаточное количество для возврата книг " + callNo);
        return false;
    }

    public void returnBook(String callNo) {
        Book book = findBookByCallNo(callNo, false);
        book.setQuntity(book.getQuntity() + 1);
        book.setIssued(book.getIssued() - 1);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Book> getIssuedBooks() {
        ArrayList<Book> bookIssuedList = new ArrayList<>();
        for (Book book : books)
            if (book.getIssued() > 0)
                bookIssuedList.add(book);
        return bookIssuedList;
    }

}
