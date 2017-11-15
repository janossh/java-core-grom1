package library;

import java.util.ArrayList;
import java.util.Date;

public class UserDAO {
    static private ArrayList<User> users = new ArrayList<>();
    private static User curentUser;

    private User addUser(User user, TypeOfUser typeOfUser) {
        user.setTypeOfUser(typeOfUser);
        users.add(user);
        return user;
    }

    public static User getCurentUser() {
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

    public static User findUserById(Long id) {
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
