package lesson11.biginterfaceexample;

public class Demo {
    public static void main(String[] args) {
        File file1 = new File("test", "C:/user/home", "txt", 11);
        File file2 = new File("test", "C:/user/home", "txt", 11);
        File file3 = new File("test", "C:/user/home", "txt", 11);
        File file4 = new File("test", "C:/user/home", "txt", 11);
        File file5 = new File("test", "C:/user/home", "txt", 11);

        File[] files = new File[]{file1, file2, file3, file4, file5};
        Storage storage =new Storage(files);

        FileRedaer fileRedaer = new FileRedaer();
        SimpleReader simpleReader = new SimpleReader();

        read(storage, fileRedaer);
        read(storage, simpleReader);
    }

    private static void read(Storage storage, Readable readable){
        readable.readFilesFromStorage(storage);
    }
}
