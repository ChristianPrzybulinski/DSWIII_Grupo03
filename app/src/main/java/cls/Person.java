package cls;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by gaelrech on 12/10/17.
 */

public class Person implements Serializable{

    public String name;
    public String gender;
    public String cpf;
    public String rg;
    public String birthDate;

    public boolean isAdmin;
    public boolean isActive;

    public String phoneNumber;
    public String email;
    public String login;
    public String password;

    public Person(){}

    public Person(String name, String gender, String cpf, String rg, String birthDate, boolean isAdmin, boolean isActive, String phoneNumber, String email, String login, String password) {
        this.name = name;
        this.gender = gender;
        this.cpf = cpf;
        this.rg = rg;
        this.birthDate = birthDate;
        this.isAdmin = isAdmin;
        this.isActive = isActive;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.login = login;
        this.password = password;
    }
}
