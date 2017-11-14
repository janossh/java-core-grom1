package library;

import java.util.Date;

public class Book {
    private long id;
    private String callNo;
    private String name;
    private String author;
    private String publisher;
    //private int quntity;
    //private int issued;
    private boolean issued;
    private Date addedDate;

    public Book(long id, String callNo, String name, String author, String publisher, Date addedDate) {
        this.id = id;
        this.callNo = callNo;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        //this.quntity = quntity;
        this.addedDate = addedDate;
    }

    //public void setQuntity(int quntity) {
//        this.quntity = quntity;
//    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public long getId() {
        return id;
    }

    public String getCallNo() {
        return callNo;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

//    public int getQuntity() {
//        return quntity;
//    }

    public boolean getIssued() {
        return issued;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", callNo='" + callNo + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                //", quntity=" + quntity +
                ", issued=" + issued +
                ", addedDate=" + addedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!callNo.equals(book.callNo)) return false;
        if (!name.equals(book.name)) return false;
        if (!author.equals(book.author)) return false;
        return publisher.equals(book.publisher);
    }

    @Override
    public int hashCode() {
        int result = callNo.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + publisher.hashCode();
        return result;
    }
}
