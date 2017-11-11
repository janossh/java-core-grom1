package library;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private long id;
    private String name;
    private String password;
    private String email;
    private String address;
    private String city;
    private String contact;
    private TypeOfUser typeOfUser;
    private ArrayList<String> issuedBooks = new ArrayList<>();
    private ArrayList<Date> issuedDates = new ArrayList<>();

    public User(long id, String name, String password, String email, String address, String city, String contact) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.city = city;
        this.contact = contact;
    }

    public void setTypeOfUser(TypeOfUser typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getContact() {
        return contact;
    }

    public TypeOfUser getTypeOfUser() {
        return typeOfUser;
    }

    public ArrayList<String> getIssuedBooks() {
        return issuedBooks;
    }

    public ArrayList<Date> getIssuedDates() {
        return issuedDates;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", typeOfUser=" + typeOfUser +
                ", issuedBooks=" + issuedBooks +
                ", issuedDates=" + issuedDates +
                '}';
    }
}
