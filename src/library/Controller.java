package library;

import java.util.ArrayList;

public class Controller {
    public static BookDAO bookDAO;
    public static UserDAO userDAO;

    public Controller() {
        bookDAO = new BookDAO();
        userDAO = new UserDAO();
        User userAdm = new User(999, "admin", "admin123", "1@1.com", "Qwerty str.", "Kiev", "01234568780");
        userAdm.setTypeOfUser(TypeOfUser.ADMIN);
        userDAO.getUsers().add(userAdm);
    }


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
        if (userDAO.getCurentUser() != null && userDAO.getCurentUser().getTypeOfUser() == TypeOfUser.LIBRAIAN) {
            return bookDAO.addBook(book);
        } else {
            System.out.println("У вас не достаточно прав доступа");
            return false;
        }

    }

    public static ArrayList<Book> getIssuedBooks() {
        if (userDAO.getCurentUser() != null && userDAO.getCurentUser().getTypeOfUser() == TypeOfUser.LIBRAIAN) {
            return bookDAO.getIssuedBooks();
        } else {
            System.out.println("У вас не достаточно прав доступа");
            return new ArrayList<Book>();
        }
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

    public static boolean login(String name, String password) {
        return userDAO.login(name, password);
    }

    public static void logout() {
        userDAO.logout();
    }
}
