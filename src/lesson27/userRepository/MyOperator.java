package lesson27.userRepository;

import java.util.function.UnaryOperator;

public class MyOperator<T> implements UnaryOperator<T> {
    private T varc1;

    public void setVarc1(T varc1) {
        this.varc1 = varc1;
    }

    public T apply(T varc) {
        return ((User) varc).getId() == ((User) varc1).getId() ? varc1 : varc;
    }

}