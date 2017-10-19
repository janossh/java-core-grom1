package lesson20.task1.exeption;

public class UserNotFoundExeption extends Exception{
    public UserNotFoundExeption(String message) {
        super(message);
    }
}
