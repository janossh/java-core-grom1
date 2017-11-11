package library;

import java.util.ArrayList;
import java.util.Date;

public class UserDAO {
    private ArrayList<User> users = new ArrayList<>();
    private User curentUser;

    private User addUser(User user, TypeOfUser typeOfUser) {
        user.setTypeOfUser(typeOfUser);
        users.add(user);
        return user;
    }

    public User getCurentUser() {
        return curentUser;
    }

    public User addLibraian(User user) {
        if (curentUser != null && curentUser.getTypeOfUser() == TypeOfUser.ADMIN) {
            return addUser(user, TypeOfUser.LIBRAIAN);
        } else {
            System.out.println("У вас не достаточно прав доступа");
            return null;
        }
    }

    public User addVisitor(User user) {
        if (curentUser != null && (curentUser.getTypeOfUser() == TypeOfUser.ADMIN || curentUser.getTypeOfUser() == TypeOfUser.LIBRAIAN)) {
            return addUser(user, TypeOfUser.VISITOR);
        } else {
            System.out.println("У вас не достаточно прав доступа");
            return null;
        }
    }

    public ArrayList<User> getUsers() {
        if (curentUser == null || (curentUser.getTypeOfUser() == TypeOfUser.ADMIN || curentUser.getTypeOfUser() == TypeOfUser.LIBRAIAN)) {
            return users;
        } else {
            System.out.println("У вас не достаточно прав доступа");
            return null;
        }
    }

    private boolean checkDates(User user) {
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

    public void issueBook(long userId, String callNo) {
        if (curentUser != null) {
            User user = findUserById(userId);

            user.getIssuedBooks().add(callNo);
            user.getIssuedDates().add(new Date());
        }
    }

    public void returnBook(Long userId, String callNo) {
        if (curentUser != null) {
            User user = findUserById(userId);

            int indexOfBook = findIndexOfArrayIssuedBooks(userId, callNo);

            user.getIssuedBooks().remove(indexOfBook);
            user.getIssuedDates().remove(indexOfBook);
        }
    }


    public boolean checkNonDoubleBook(User user, String callNo) {
        boolean flBook = true;
        for (String no : user.getIssuedBooks()) {
            if (no.equals(callNo)) {
                flBook = false;
                System.out.println("Ошибка! У студент " + user.getName() + " уже есть данная книга " + callNo);
                return flBook;
            }
        }
        return flBook;
    }

    private boolean checkArrays(User user) {
        boolean flag = user.getIssuedDates().size() == user.getIssuedBooks().size();
        if (!flag)
            System.out.println("Ошибка! Что то пошло не так), не соответствие БД у студента " + user.getName());
        return flag;
    }

    public boolean performCheckToIssueBook(long userId, String callNo) {
        User user = findUserById(userId);
        return user != null ? checkArrays(user) && checkNonDoubleBook(user, callNo) && checkDates(user) : false;
    }

    public int findIndexOfArrayIssuedBooks(Long userId, String callNo) {
        int index = -1;
        if (curentUser != null) {
            User user = findUserById(userId);

            if (user != null) {
                ArrayList<String> callNos = user.getIssuedBooks();
                for (int i = 0; i < callNos.size(); i++) {
                    if (callNos.get(i).equals(callNo)) {
                        return i;
                    }
                }
            } else {
                System.out.println("Ошибка! Студента с номером ид " + callNo + " нет в системе ");
                return index;
            }
            System.out.println("Ошибка! Студент " + user.getName() + " не брал книгу " + callNo);
            return index;
        } else {
            System.out.println("Ошибка доступа! ");
            return index;
        }
    }

    public ArrayList<User> listOfUsersLibraian() {
        ArrayList<User> listOfLibraian = new ArrayList<>();
        if (curentUser != null && curentUser.getTypeOfUser() == TypeOfUser.ADMIN) {
            for (User user : users) {
                if (user.getTypeOfUser() == TypeOfUser.LIBRAIAN)
                    listOfLibraian.add(user);
            }
        } else {
            System.out.println("У вас не достаточно прав доступа");
        }
        return listOfLibraian;
    }

    public ArrayList<User> listOfUsersVisitors() {
        ArrayList<User> listOfLibraian = new ArrayList<>();
        if (curentUser != null && (curentUser.getTypeOfUser() == TypeOfUser.ADMIN || curentUser.getTypeOfUser() == TypeOfUser.LIBRAIAN)) {
            for (User user : users) {
                if (user.getTypeOfUser() == TypeOfUser.VISITOR)
                    listOfLibraian.add(user);
            }
        } else {
            System.out.println("У вас не достаточно прав доступа");
        }
        return listOfLibraian;
    }

    public void deleteLibraian(Long id) {
        if (curentUser != null && curentUser.getTypeOfUser() == TypeOfUser.ADMIN) {
            User user = findUserById(id);
            if (user != null && user.getTypeOfUser() == TypeOfUser.LIBRAIAN)
                users.remove(user);
        } else {
            System.out.println("У вас не достаточно прав доступа");
        }
    }

    private User findUserById(Long id) {
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    public boolean login(String name, String password) {
        for (User user : users) {
            if (curentUser == null && user != null && user.getName().equals(name) && user.getPassword().equals(password)) {
                curentUser = user;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        curentUser = null;
    }

}
