package cls;

import java.util.Date;

/**
 * Created by gaelrech on 12/10/17.
 */

public class Student extends Person {

    public Student(String name, char gender, int id, int cpf, int rg, Date birthDate, boolean isAdmin, boolean isActive, int phoneNumber, String email, String address, String CEP) {
        super(name, gender, id, cpf, rg, birthDate, isAdmin, isActive, phoneNumber, email, address, CEP);
    }

}
