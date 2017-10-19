package lesson18;

public class Task {
    public static void main(String[] args) {
        FileStorage fileStorage = new FileStorage();
        CodeStorage codeStorage = new CodeStorage();
        PictureStorage pictureStorage = new PictureStorage();

        String[] fileNames = {"test1", "test2"};
        String[] fileNames1 = {"test1", "test2","test1", "test2","test1", "test2"};
        String[] fileNames2 = {"test1", "test2","test1", "test2"};

        fileStorage.setFiles(fileNames);
        codeStorage.setFiles(fileNames1);
        pictureStorage.setFiles(fileNames2);

        printer(fileStorage);
        printer(codeStorage);
        printer(pictureStorage);

    }

    public static void printer(Storage storage) {
        try {
            System.out.println("5th name is " + storage.getFiles()[4]);
        } catch (Exception e) {
            System.out.println("5h name can not be found...");
        }
    }
}
