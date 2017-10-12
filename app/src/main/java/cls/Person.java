package cls;

import java.util.Date;

/**
 * Created by gaelrech on 12/10/17.
 */

public class Person {

    private String name;
    private char gender;
    private int id;
    private int cpf;
    private int rg;
    private Date birthDate;

    private boolean isAdmin;
    private boolean isActive;

    private int phoneNumber;
    private String Email;
    private String address;
    private String CEP;

    public Person(String name, char gender, int id, int cpf, int rg, Date birthDate, boolean isAdmin, boolean isActive, int phoneNumber, String email, String address, String CEP) {
        this.name = name;
        this.gender = gender;
        this.id = id;
        this.cpf = cpf;
        this.rg = rg;
        this.birthDate = birthDate;
        this.isAdmin = isAdmin;
        this.isActive = isActive;
        this.phoneNumber = phoneNumber;
        Email = email;
        this.address = address;
        this.CEP = CEP;
    }

    // Get & Set

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
}
