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

    public static ArrayList<Book> getBooks(){
        return bookDAO.getBooks();
    }

    public static boolean addBooks(Book book){
        return bookDAO.addBook(book);
    }

    public static ArrayList<Book> getIssuedBooks(){
        return bookDAO.getIssuedBooks();
    }

}
