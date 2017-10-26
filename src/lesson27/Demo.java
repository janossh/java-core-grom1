package lesson27;

import lesson27.userRepository.User;
import lesson27.userRepository.UserRepository;

public class Demo {
    public static void main(String[] args) {
        User user = new User(45,"Roman", "456546546545");
        User user1 = new User(4,"A", "1");
        User user2 = new User(5,"B", "2");
        User user3 = new User(45,"C", "3");
        User user4 = new User(75,"D", "4");

        UserRepository userRepository = new UserRepository();
        userRepository.save(user);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user4);
//        userRepository.save(user);
//        userRepository.save(user);
        System.out.println(userRepository.getUserNames());
        userRepository.update(user3);

        System.out.println(userRepository.getUserNames());
        userRepository.delete(45);
        System.out.println(userRepository.getUserNames());
    }
}
