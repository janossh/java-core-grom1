package lesson19;

import lesson19.Storage;

public class Controller {

    public void put(Storage storage, File file) throws Exception{

        if (storage != null && file != null) {
            try {
                storage.putFile(file);
            } catch (Exception e) {
                System.out.println("Can't put, " + e.getMessage() + " " + file.getId());
                throw new Exception("put() Controller");
            }
        }
    }

    public void delete(Storage storage, File file) {
        if (storage != null && file != null) {
            try {
                storage.deleteFile(file);
            } catch (Exception e) {
                System.out.println("Can't delete, " + e.getMessage() + " " + file.getId());
            }
        }
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) {
        if (storageFrom != null && storageTo != null) {
            File file = storageFrom.getFileById(id);
            if (file != null) {
                try {
                    if (storageTo.putFile(file))
                        storageFrom.deleteFile(file);
                } catch (Exception e) {
                    System.out.println(e.getMessage() + " can't transfer file " + id);
                }
            } else System.out.println("Can't transfer, file doesn't exist " + id);
        }
    }

    public void transferAll(Storage storageFrom, Storage storageTo) {
        if (storageFrom != null && storageTo != null) {
            try {
                if (storageTo.getFreeInnerSpace() >= storageFrom.getFiles().length - storageFrom.getFreeInnerSpace()
                        && storageTo.getFreeSpace() >= storageFrom.getStorageSize() - storageFrom.getFreeSpace()) {
                    for (File file : storageFrom.getFiles())
                        if (file != null)
                            put(storageTo, file);

                    storageFrom.deleteAllFile();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() + "can't transfer files");
            }
        }
    }
}
