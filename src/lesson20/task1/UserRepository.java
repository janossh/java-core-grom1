package lesson20.task1;

import lesson20.task1.exeption.BadRequestExeption;
import lesson20.task1.exeption.InternalServerExeption;
import lesson20.task1.exeption.UserNotFoundExeption;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames() {
        if (users != null) {
            int aa = 0;
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null) {
                    aa++;
                }
            }

            String[] userNames = new String[aa];

            aa = 0;

            for (int i = 0; i < users.length; i++) {
                if (users[i] != null) {
                    userNames[aa] = users[i].getName();
                    aa++;
                }
            }

            return userNames;
        }
        return null;

    }

    public long[] getUserIds() {
        if (users != null) {

            int aa = 0;
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null) {
                    aa++;
                }
            }
            long[] userIds = new long[aa];

            aa = 0;

            for (int i = 0; i < users.length; i++) {
                if (users[i] != null) {
                    userIds[aa] = users[i].getId();
                    aa++;
                }
            }

            return userIds;
        }
        return null;
    }


    public String getUserNameById(long id) {
        String name = null;
        if (users != null) {
            for (User user : users) {
                if (user != null)
                    if (user.getId() == id)
                        name = user.getName();
            }
        }
        return name;
    }

    public User getUserByName(String name) {

        if (users != null) {
            for (User user : users) {
                if (user != null)
                    if (user.getName() == name)
                        return user;
            }
        }
        return null;
    }

    public User getUserById(long id) {

        if (users != null) {
            for (User user : users) {
                if (user != null)
                    if (user.getId() == id)
                        return user;
            }
        }
        return null;
    }

    public User getUserBySessionId(String sessionId) {

        if (users != null) {
            for (User user : users) {
                if (user != null)
                    if (user.getSessionId() == sessionId)
                        return user;
            }
        }
        return null;
    }

    public User save(User user) throws Exception {
        if (user == null)
            throw new BadRequestExeption("Can't save null user");
        try {
            findById(user.getId());
            throw new BadRequestExeption("User with id: " + user.getId() + " already exist");
        } catch (UserNotFoundExeption e) {
            System.out.println("User with id: " + user.getId() + " not found. Will be saved");
        }


        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return user;
            }
        }

        throw new InternalServerExeption("Not enought space to save user with id " + user.getId());
    }

    public User findById(long id) throws UserNotFoundExeption {

        if (users != null) {
            for (User user1 : users) {
                if (user1 != null && user1.getId() == id)
                    return user1;
            }
        }
        throw new UserNotFoundExeption("User with id " + id + " not found");
    }

    public User update(User user) throws Exception {
        if (user == null)
            throw new BadRequestExeption("Can't save null user");

        findById(user.getId());

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == user.getId()) {
                users[i] = user;
                return users[i];
            }
        }

        throw new InternalServerExeption("Unexpected error");
    }

    public void delete(long id) throws Exception {

        findById(id);

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == id) {
                users[i] = null;
                break;
            }
        }
    }

}
