package lesson25.hw;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        GeneralDAO<Long> longDAO = new GeneralDAO<>();
        GeneralDAO<String> stringDAO = new GeneralDAO<>();
        GeneralDAO<Integer> intDAO = new GeneralDAO<>();


        try {
            longDAO.save(null);
            longDAO.save(1L);
            longDAO.save(2L);
            longDAO.save(3L);
            longDAO.save(4L);
            longDAO.save(5L);
            longDAO.save(6L);
            longDAO.save(7L);
            longDAO.save(8L);
            longDAO.save(9L);
            longDAO.save(10L);
            //longDAO.save(11L);

            stringDAO.save(null);
            stringDAO.save("1L");
            stringDAO.save("2L");
            stringDAO.save("3L");
            stringDAO.save("4L");
            stringDAO.save("5L");
            stringDAO.save("6L");
            stringDAO.save("7L");
            stringDAO.save("8L");
            stringDAO.save("9L");
            stringDAO.save("10L");
            //stringDAO.save("11L");

            intDAO.save(null);

            System.out.println(Arrays.toString(longDAO.getAll()));
            System.out.println(Arrays.toString(stringDAO.getAll()));
            System.out.println(Arrays.toString(intDAO.getAll()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}
