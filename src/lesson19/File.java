package lesson19;

public class File {
    private long id;
    private String name;
    private String format;
    private long size;

    public File (long id, String name, String format, long size) throws Exception {
        if (name != null && name.length() <= 10) {
            this.id = id;
            this.name = name;
            this.format = format;
            this.size = size;
        } else {
            throw new Exception("cant create file, file name to short");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        if (id != file.id) return false;
        return name.equals(file.name);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public long getSize() {
        return size;
    }
}
