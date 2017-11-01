package HWArray;

public class Solution <T>{

    public static boolean compareIntArrays(int[] first, int[] second) {

        if (first == second)
            return true;
        if (first == null || second == null)
            return false;

        if (second.length != first.length)
            return false;

        for (int i = 0; i < first.length; i++)
            if (first[i] != second[i])
                return false;

        return true;

    }

    public static boolean compareStringArrays(String[] first, String[] second) {

        if (first == second)
            return true;
        if (first == null || second == null)
            return false;

        if (second.length != first.length)
            return false;

        for (int i = 0; i < first.length; i++)
            if (!first[i].equals(second[i]))
                return false;

        return true;

    }

    public boolean compareArrays(T[] first, T[] second) {

        if (first == second)
            return true;
        if (first == null || second == null)
            return false;

        if (second.length != first.length)
            return false;

        for (int i = 0; i < first.length; i++)
            if (!((T)first[i]).equals((T)second[i]))
                return false;

        return true;

    }
}
