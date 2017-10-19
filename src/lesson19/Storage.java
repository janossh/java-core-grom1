package lesson19;

import java.util.Arrays;

public class Storage {
    private long id;
    private File[] files;
    private String[] formatsSupported;
    private String storageCountry;
    private long storageSize;

    public Storage(long id, File[] files, String[] formatsSupported, String storageCountry, long storageSize) {
        this.id = id;
        this.files = files;
        this.formatsSupported = formatsSupported;
        this.storageCountry = storageCountry;
        this.storageSize = storageSize;
    }

    public long getId() {
        return id;
    }

    public File[] getFiles() {
        return files;
    }

    public String getStorageCountry() {
        return storageCountry;
    }

    public long getStorageSize() {
        return storageSize;
    }

    public long getFreeSpace()  {
        long freeSpace = storageSize;

        if (files != null) {
            for (File file : files)
                if (file != null)
                    freeSpace -= file.getSize();
        } else freeSpace = 0;



        return freeSpace;
    }

    public int getFreeInnerSpace()  {
        int count = 0;
        if (files != null) {
            for (File file : files)
                if (file != null)
                    count++;
            count = files.length - count;
        }


        return count;
    }

    public boolean isSupportFormat(String formatIn)  {
        boolean flag = false;
        if (formatIn != null)
            if (formatsSupported != null)
                for (String format : formatsSupported)
                    if (format != null && !format.isEmpty() && format.equals(formatIn)) {
                        flag = true;
                        break;
                    }




        return flag;
    }

    public boolean findDoobleFile(File fileIn)  {
        boolean flag = false;

        if (files != null && fileIn != null) {
            for (File file : files)
                if (file != null && file.equals(fileIn))
                    flag = true;
        }


        return flag;
    }

    public boolean putFile(File file) {
        boolean flag = false;
        if (file != null) {
            //try {
                if (files != null && isSupportFormat(file.getFormat())
                        && getFreeInnerSpace() >= 1 && getFreeSpace() >= file.getSize()
                        && !findDoobleFile(file))
                    for (int i = 0; i < files.length; i++)
                        if (files[i] == null) {
                            files[i] = file;
                            flag = true;
                            break;
                        }
//            } catch (Exception e) {
//                System.out.println(e.getMessage() + " can't put file " + file.getId());
//            }
        }
        return flag;
    }

    public boolean deleteFile(File file)  {
        boolean flag = false;
        if (file != null)
            if (files != null)
                for (int i = 0; i < files.length; i++)
                    if (files[i] != null && files[i].equals(file)) {
                        files[i] = null;
                        flag = true;
                    }


        return flag;
    }

    public boolean deleteAllFile() {
        boolean flag = false;
        if (files != null) {
            flag = true;
            for (File file : files)
                file = null;
        }

        return flag;
    }

    public File getFileById(long id) {

        if (files != null)
            for (File file : files)
                if (file != null)
                    if (file.getId() == id)
                        return file;

        return null;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", files=" + Arrays.toString(files) +
                ", formatsSupported=" + Arrays.toString(formatsSupported) +
                ", storageCountry='" + storageCountry + '\'' +
                ", storageSize=" + storageSize +
                '}';
    }
}
