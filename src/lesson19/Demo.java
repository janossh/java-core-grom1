package lesson19;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        File file0 = null;
        File file1 = null;
        File file2 = null;
        File file3 = null;
        File file4 = null;
        File file5 = null;
        File file6 = null;
        File file7 = null;
        File file8 = null;
        File file9 = null;
        File file10 = null;
        File file11 = null;
        File file12 = null;
        File file13 = null;
        File file14 = null;

        try {
            file0 = new File(654654654, "11111roman", "jpg", 456);
            file1 = new File(465465, "11111roman1", "jpg", 456);
            file2 = new File(65465, "11111roman2", "jpg", 456);
            file3 = new File(654654, "11111roman3", "jpg", 456);
            file4 = new File(6544654, "11111roman4", "jpg", 456);
            file5 = new File(6654654, "11111roman5", "jpg", 456);
            file6 = new File(54654654, "11111roman6", "jpg", 456);
            file7 = new File(44654654, "11111roman7", "txt", 456);
            file8 = new File(754654654, "11111roman8", "txt", 456);
            file9 = new File(954654654, "11111roman9", "txt", 456);
            file10 = new File(754654654, "11111roman10", "txt", 456);
            file11 = new File(454654654, "11111roman11", "txt", 456);
            file12 = new File(654, "11111roman12", "jpg", 456);
            file13 = new File(654, "11111roman12", "jpg", 456);
            file14 = new File(1654, "11111roman121", "doc", 456);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        File[] files1 = new File[]{file14, file0, file1, file1, file3, file4, file5, file6, file7};
        File[] files2 = new File[]{file8, file9, file10, file11, file12, file13, file14, file7};

        Storage storage1 = new Storage(54, new File[6], new String[]{"txt", "jpg"}, "Japan", 987987987987L);
        Storage storage2 = new Storage(55, new File[7], new String[]{"txt", "jpg", "doc"}, "Japan", 1987L);

        Controller controller = new Controller();

        System.out.println(storage1.toString());

        for (File file : files1) {
            try {
                controller.put(storage1, file);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        controller.delete(storage1, file0);
        controller.delete(storage1, file7);
        controller.delete(storage2, file12);

        controller.transferFile(storage1, storage2, 465465);
        controller.transferFile(storage1, storage2, 65);
        controller.transferFile(storage1, null, 650);

        controller.transferAll(storage1, null);
        controller.transferAll(null, storage1);
        controller.transferAll(storage1, storage2);

        System.out.println(storage1.toString());
        System.out.println(storage2.toString());

    }
}
