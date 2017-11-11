package library;

import java.util.ArrayList;

public class Controller {
    public static BookDAO bookDAO = new BookDAO();
    public static UserDAO userDAO = new UserDAO();

    public static User addLibraian(User user) {
        return userDAO.addLibraian(user);
    }

    public static User addVisitor(User user) {
        return userDAO.addVisitor(user);
    }

    public static void deleteLibraian(Long id) {
        userDAO.deleteLibraian(id);
    }

    public static ArrayList<User> getLibraians() {
        return userDAO.listOfUsersLibraian();
    }

    public static ArrayList<User> getVisitors() {
        return userDAO.listOfUsersVisitors();
    }

    public static ArrayList<Book> getBooks() {
        return bookDAO.getBooks();
    }

    public static boolean addBooks(Book book) {
        return bookDAO.addBook(book);
    }

    public static ArrayList<Book> getIssuedBooks() {
        return bookDAO.getIssuedBooks();
    }

    public static boolean issueBook(Long userId, String callNo) {
        boolean flag = false;
        if (userDAO.performCheckToIssueBook(userId, callNo) && bookDAO.checkIssue(callNo)) {
            userDAO.issueBook(userId, callNo);
            bookDAO.issueBook(callNo);
            flag = true;
        }
        return flag;
    }

    public static boolean returnBook(Long userId, String callNo) {
        boolean flag = false;
        if (userDAO.findIndexOfArrayIssuedBooks(userId, callNo) > (-1) && bookDAO.checkReturn(callNo)) {
            userDAO.returnBook(userId, callNo);
            bookDAO.returnBook(callNo);
            flag = true;
        }
        return flag;
    }

}
