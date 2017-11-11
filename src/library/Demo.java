package library;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Book book1 = new Book(121, "1@1", "Name1", "Pushkin", "Kiev", 1, new Date());
        Book book2 = new Book(122, "1@2", "Name2", "Pushkin", "Kiev", 5, new Date());
        Book book3 = new Book(12, "1@3", "Name3", "Pushkin", "Kiev", 5, new Date());
        Book book4 = new Book(124, "1@4", "Name4", "Pushkin", "Kiev", 5, new Date());
        Book book5 = new Book(125, "1@5", "Name5", "Pushkin", "Kiev", 5, new Date());

        User user0 = new User(100, "Name0", "123456", "1@1.com", "Qwerty str.", "Kiev", "01234568780");
        User user1 = new User(101, "Name1", "123456", "1@1.com", "Qwerty str.", "Kiev", "01234568781");
        User user2 = new User(102, "Name2", "123456", "1@1.com", "Qwerty str.", "Kiev", "01234568782");
        User user3 = new User(103, "Name3", "123456", "1@1.com", "Qwerty str.", "Kiev", "01234568783");
        User user4 = new User(104, "Name4", "123456", "1@1.com", "Qwerty str.", "Kiev", "01234568784");

        Controller controller = new Controller();

        controller.login("admin", "admin123");

        controller.addLibraian(user0);
        controller.addLibraian(user1);

        System.out.println(controller.getLibraians());

        controller.deleteLibraian(100L);

        System.out.println(controller.getLibraians());

        controller.deleteLibraian(105L);

        System.out.println(controller.getLibraians());

        controller.logout();
        controller.login("Name1", "123456");

        controller.addBooks(book1);
        controller.addBooks(book2);
        controller.addBooks(book3);
        controller.addBooks(book4);
        controller.addBooks(book5);

        System.out.println(controller.getBooks());

        controller.addVisitor(user2);
        controller.addVisitor(user3);
        controller.addVisitor(user4);

        System.out.println(controller.getVisitors());

        controller.issueBook(102L, "1@1");

        System.out.println(controller.getVisitors());
        System.out.println(controller.getIssuedBooks());

        controller.issueBook(103L, "1@1");

        System.out.println(controller.getVisitors());
        System.out.println(controller.getIssuedBooks());

        controller.returnBook(103L, "1@1");
        System.out.println(controller.getIssuedBooks());

        controller.returnBook(102L, "1@1");
        System.out.println(controller.getIssuedBooks());

    }
}
