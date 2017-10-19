package lesson22.UserRepository;

public class UserRepository {
    private static User[] users = new User[10];

//    public UserRepository(User[] users) {
//        this.users = users;
//    }

    public static User[] getUsers() {
        return users;
    }

    public static String[] getUserNames() {
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

    public static long[] getUserIds() {
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


    public static String getUserNameById(long id) {
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

    public static User getUserByName(String name) {

        if (users != null) {
            for (User user : users) {
                if (user != null)
                    if (user.getName() == name)
                        return user;
            }
        }
        return null;
    }

    public static User getUserById(long id) {

        if (users != null) {
            for (User user : users) {
                if (user != null)
                    if (user.getId() == id)
                        return user;
            }
        }
        return null;
    }

    public static User getUserBySessionId(String sessionId) {

        if (users != null) {
            for (User user : users) {
                if (user != null)
                    if (user.getSessionId() == sessionId)
                        return user;
            }
        }
        return null;
    }

    public static User save(User user) {
        if (user != null) {
            if (user.equals(findById(user.getId())))
                return null;
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = user;
                    return user;
                }
            }
        }
        return null;
    }

    public static User findById(long id) {

        if (users != null) {
            int aa = 0;
            for (User user1 : users) {
                if (user1 != null)
                    if (user1.getId() == id)
                        return user1;
            }
        }
        return null;
    }

    public static User update(User user) {
        if (user != null)
            if (users != null) {
                User myUser = findById(user.getId());
                if (myUser != null)
                    if (user.getId() == myUser.getId()) {
                        for (int i = 0; i < users.length; i++) {
                            if (users[i] != null)
                                if (users[i].getId() == user.getId()) {
                                    users[i] = user;
                                }
                        }
                        return user;
                    }

            }
        return null;
    }

    public static void delete(long id) {
        if (users != null) {
            User myUser = findById(id);
            if (myUser != null)
                if (id == myUser.getId()) {
                    for (int i = 0; i < users.length; i++) {
                        if (users[i] != null)
                            if (users[i].getId() == id) {
                                users[i] = null;
                            }
                    }

                }
        }
    }

}
