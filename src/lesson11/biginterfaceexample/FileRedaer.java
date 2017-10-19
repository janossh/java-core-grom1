package lesson11.biginterfaceexample;

public class FileRedaer implements Readable {


    @Override
    public void readFilesFromStorage(Storage storage) {
        printFile(findMaxFileSize(storage.getFiles()));
    }

    private File findMaxFileSize(File[] files) {
        File fileMaxSize = files[0];
        for (File file : files) {
            if (file != null && fileMaxSize.getSize() < file.getSize()) fileMaxSize = file;
        }
        return fileMaxSize;
    }

    private void printFile(File file) {
        System.out.println("Max file size will be printed now...");

        System.out.println(file.getName());
        System.out.println(file.getExtention());
        System.out.println(file.getPath());
        System.out.println(file.getSize());
        System.out.println();
    }
}
