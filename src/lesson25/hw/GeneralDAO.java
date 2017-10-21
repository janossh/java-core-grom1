package lesson25.hw;

public class GeneralDAO<T> {
    private T[] array = (T[]) new Object[10];

    public T save(T t) throws Exception {

        if (t == null)
            return null;

        int index = 0;
        for (T el : array) {
            if (el == null) {
                array[index] = t;
                return array[index];
            }
            index++;
        }
        throw new Exception("Can't save object " + t.toString());
    }

    public T[] getAll() {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                count++;
            }
        }

        T[] result = (T[]) new Object[count];

        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                result[count]=array[i];
                count++;
            }
        }

        return result;
    }

}
