package library;

import java.util.ArrayList;
import java.util.Date;

public class UserDAO {
    private ArrayList<User> users = new ArrayList<>();


    private User addUser(User user, TypeOfUser typeOfUser) {
        user.setTypeOfUser(typeOfUser);
        users.add(user);
        return user;
    }

    public User addLibraian(User user) {
        return addUser(user, TypeOfUser.LIBRAIAN);
    }

    public User addVisitor(User user) {
        return addUser(user, TypeOfUser.VISITOR);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public boolean checkDates(User user) {
        boolean flBook = true;
        Date dateOfIssue = new Date();
        for (Date date : user.getIssuedDates()) {
            if (date != null && (dateOfIssue.getTime() - date.getTime() > 31 * 86400 * 1000)) {
                flBook = false;
                return flBook;
            }
        }
        return flBook;
    }

    private void issueBook(User user, String callNo) {
        user.getIssuedBooks().add(callNo);
        user.getIssuedDates().add(new Date());
    }

    private void returnBook(User user, String callNo) {
        int indexOfBook = findIndexOfArrayIssuedBooks(user, callNo);

        user.getIssuedBooks().remove(indexOfBook);
        user.getIssuedDates().remove(indexOfBook);

    }


    public boolean checkNonDoubleBook(User user, String callNo) {
        boolean flBook = true;
        for (String no : user.getIssuedBooks()) {
            if (no.equals(callNo)) {
                flBook = false;
                System.err.println("Ошибка! У студент " + user.getName() + " уже есть данная книга " + callNo);
                return flBook;
            }
        }
        return flBook;
    }

    public boolean checkArrays(User user) {
        boolean flag = user.getIssuedDates().size() == user.getIssuedBooks().size();
        if (!flag)
            System.err.println("Ошибка! Что то пошло не так), не соответствие БД у студента " + user.getName());
        return flag;
    }

    public boolean performCheckToIssueBook(User user, String callNo) {
        return checkArrays(user) && checkNonDoubleBook(user, callNo) && checkDates(user);
    }

    public int findIndexOfArrayIssuedBooks(User user, String callNo) {
        int index = -1;
        ArrayList<String> callNos = user.getIssuedBooks();
        for (int i = 0; i < callNos.size(); i++) {
            if (callNos.get(i).equals(callNo)) {
                return i;
            }
        }
        System.err.println("Ошибка! Студент " + user.getName() + " не брал книгу " + callNo);
        return index;
    }

    public ArrayList<User> listOfUsersLibraian() {
        ArrayList<User> listOfLibraian = new ArrayList<>();
        for (User user : users) {
            if (user.getTypeOfUser() == TypeOfUser.LIBRAIAN)
                listOfLibraian.add(user);
        }
        return listOfLibraian;
    }

    public void deleteLibraian(Long id) {
        User user = findUserById(id);
        if (user != null && user.getTypeOfUser() == TypeOfUser.LIBRAIAN)
            users.remove(user);
    }

    private User findUserById(Long id) {
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

}
