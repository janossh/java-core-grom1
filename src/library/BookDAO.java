package library;

import java.util.ArrayList;
import java.util.Date;

public class BookDAO {
    private ArrayList<Book> books = new ArrayList<>();

    public boolean addBook(Book book) throws Exception{
        boolean flBook = false;
        if (book != null) {
            books.add(book);
            return true;

        }
        throw new Exception("Ошибка добавления книги в библиотеку");
        //return flBook;
    }

    public Book findFreeBookByCallNo(String callNo) throws Exception{
        for (Book b : books) {
            if (b.getCallNo().equals(callNo) && !b.getIssued())
                return b;
        }

        throw new Exception("Нет свободных книг " + callNo);
        //return null;
    }

    public Book findIssuedBookByCallNo(String callNo) throws Exception{
        for (Book b : books) {
            if (b.getCallNo().equals(callNo) && b.getIssued())
                return b;
        }

        throw new Exception("Данная книга " + callNo + " не выдавалась");
        //return null;
    }

    public void issueBook(long userId, String callNo) throws Exception{
        Book book = findFreeBookByCallNo(callNo);

        book.setUserIdIssued(userId);
        book.setDateIssued(new Date());
        book.setIssued(true);
    }

    public boolean checkIssue(long userId, String callNo) throws Exception{
        Book book = findFreeBookByCallNo(callNo);
        User user = UserDAO.findUserById(userId);
        if (UserDAO.getCurentUser() != null && checkNonDoubleBook(user, callNo) && checkDates(user) && user != null && book != null && !book.getIssued()) {
            return true;
        }
        throw new Exception("Недостаточное количество для выдачи книг " + callNo);
        //return false;
    }

    public boolean checkReturn(long userId, String callNo) throws Exception{
        Book book = findIssuedBookByCallNo(callNo);
        User user = UserDAO.findUserById(userId);

        boolean flHaveThisBook = false;

        if (user != null) {
            ArrayList<Book> issuedBooks = getIssuedBooksByUserId(userId);

            for (int i = 0; i < issuedBooks.size(); i++) {
                if (issuedBooks.get(i).getCallNo().equals(callNo)) {
                    flHaveThisBook = true;
                }
            }
        } else {
            throw new Exception("Ошибка! Студента с номером ид " + callNo + " нет в системе ");
            //return false;
        }

        if (book != null && book.getIssued() && flHaveThisBook) {
            return true;
        }
        System.out.println("Недостаточное количество для возврата книг " + callNo);
        return false;
    }

    public void returnBook(Long userId, String callNo) throws Exception{
        Book book = findIssuedBookByCallNo(callNo);
        book.setDateIssued(null);
        book.setUserIdIssued(null);
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

    public ArrayList<Book> getIssuedBooksByUserId(Long userId) {
        ArrayList<Book> bookIssuedList = new ArrayList<>();
        for (Book book : books)
            if (book.getIssued() && book.getUserIdIssued() == userId && book.getDateIssued() != null)
                bookIssuedList.add(book);
        return bookIssuedList;
    }

    private boolean checkDates(User user) {
        boolean flBook = true;
        Date dateOfIssue = new Date();
        for (Book book : getIssuedBooksByUserId(user.getId())) {
            if (book.getDateIssued() != null && (dateOfIssue.getTime() - book.getDateIssued().getTime() > 31 * 86400 * 1000)) {
                flBook = false;
                return flBook;
            }
        }
        return flBook;
    }


    public boolean checkNonDoubleBook(User user, String callNo) throws Exception{
        boolean flBook = true;
        for (Book book : getIssuedBooksByUserId(user.getId())) {
            if (book.getCallNo().equals(callNo)) {
               // flBook = false;
                throw new Exception("Ошибка! У студент " + user.getName() + " уже есть данная книга " + callNo);
                //return flBook;
            }
        }
        return flBook;
    }


}
