package library;

import java.util.ArrayList;

public class Controller {
    public static BookDAO bookDAO;
    public static UserDAO userDAO;

    public Controller() throws Exception{
        bookDAO = new BookDAO();
        userDAO = new UserDAO();
        User userAdm = new User(999, "admin", "admin123", "1@1.com", "Qwerty str.", "Kiev", "01234568780");
        userAdm.setTypeOfUser(TypeOfUser.ADMIN);
        userDAO.getUsers().add(userAdm);
    }


    public static User addLibraian(User user) throws Exception {
        return userDAO.addLibraian(user);
    }

    public static User addVisitor(User user)throws Exception {
        return userDAO.addVisitor(user);
    }

    public static void deleteLibraian(Long id)throws Exception {
        userDAO.deleteLibraian(id);
    }

    public static ArrayList<User> getLibraians()throws Exception {
        return userDAO.listOfUsersLibraian();
    }

    public static ArrayList<User> getVisitors()throws Exception {
        return userDAO.listOfUsersVisitors();
    }

    public static ArrayList<Book> getBooks() {
        return bookDAO.getBooks();
    }

    public static boolean addBooks(Book book) throws Exception{
        if (userDAO.getCurentUser() != null && userDAO.getCurentUser().getTypeOfUser() == TypeOfUser.LIBRAIAN) {
            return bookDAO.addBook(book);
        } else {
            throw new Exception("У вас не достаточно прав доступа");
            //return false;
        }

    }

    public static ArrayList<Book> getIssuedBooks() throws Exception{
        if (userDAO.getCurentUser() != null && userDAO.getCurentUser().getTypeOfUser() == TypeOfUser.LIBRAIAN) {
            return bookDAO.getIssuedBooks();
        } else {
            throw new Exception("У вас не достаточно прав доступа");
            //return new ArrayList<Book>();
        }
    }

    public static boolean issueBook(Long userId, String callNo) throws Exception{
        boolean flag = false;
        if (userDAO.getCurentUser() != null && bookDAO.checkIssue(userId, callNo) && bookDAO.checkIssue(userId, callNo)) {
            bookDAO.issueBook(userId, callNo);
            flag = true;
        }
        return flag;
    }

    public static boolean returnBook(Long userId, String callNo) throws Exception{
        boolean flag = false;
        if (userDAO.getCurentUser() != null &&bookDAO.checkReturn(userId, callNo)) {
            bookDAO.returnBook(userId, callNo);
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
