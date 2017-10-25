package lesson27.userRepository;

import java.util.ArrayList;

public class UserRepository {
    private ArrayList<User> users = new ArrayList<>();

    public UserRepository(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<String> getUserNames() {
        if (users != null) {

            ArrayList<String> userNames = new ArrayList<>();

            for (int i = 0; i < users.size(); i++) {
                if (users.get(i) != null) {
                    userNames.add(users.get(i).getName());
                }
            }

            return userNames;
        }
        return null;

    }

    public ArrayList<Long> getUserIds() {

        ArrayList<Long> userIds = new ArrayList<>();

        if (users != null) {

            for (int i = 0; i < users.size(); i++) {
                if (users.get(i) != null) {
                    userIds.add(users.get(i).getId());
                }
            }
        }
        return userIds;
    }


    public String getUserNameById(long id) {
        String name = "";
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

    public User save(User user) {
        if (users != null) {
            if (user.equals(findById(user.getId())))
                return null;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i) == null) {
                    users.add(user);
                    return user;
                }
            }
        }
        return null;
    }

    public User findById(long id) {

        if (users != null) {
            for (User user1 : users) {
                if (user1 != null)
                    if (user1.getId() == id)
                        return user1;
            }
        }
        return null;
    }

    public User update(User user) {
        if (user != null)
            if (users != null) {
                User myUser = findById(user.getId());
                if (myUser != null)
                    if (user.getId() == myUser.getId()) {
                        for (int i = 0; i < users.size(); i++) {
                            if (users.get(i) != null)
                                if (users.get(i).getId() == user.getId()) {
                                    users.add(user);
                                }
                        }
                        return user;
                    }

            }
        return null;
    }

    public void delete(long id) {
        if (users != null) {
            User myUser = findById(id);
            if (myUser != null)
                if (id == myUser.getId()) {
                    for (int i = 0; i < users.size(); i++) {
                        if (users.get(i) != null)
                            if (users.get(i).getId() == id) {
                                users.remove(i);
                            }
                    }
                }
        }
    }

}
