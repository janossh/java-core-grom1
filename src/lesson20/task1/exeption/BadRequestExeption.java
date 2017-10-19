package lesson20.task1.exeption;

public class BadRequestExeption extends Exception {
    public BadRequestExeption(String message) {
        super(message);
    }
}
