package Database;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import cls.Person;
import cls.Turma;

/**
 * Created by Chris on 04/11/2017.
 */

public class DatabaseUser extends DatabaseConnect {

    public DatabaseUser() {
        super();
    }

    public DatabaseReference getUser(String login) {
        return this.getCampoDB("users", login);
    }

    public DatabaseReference getUsers() {
        return this.getRoot().child("users");
    }

    public DatabaseReference getUserPassword(String login){
        return this.getCampoDB("users", login).child("password");
    }

    public DatabaseReference getUserAdmin(String login){
        return this.getCampoDB("users", login).child("isAdmin");
    }
    public DatabaseReference getUserAtivo(String login){
        return this.getCampoDB("users", login).child("ativo");
    }
    public DatabaseReference getUserName(String login){
        return this.getCampoDB("users", login).child("name");
    }
    public DatabaseReference getUserGender(String login){
        return this.getCampoDB("users", login).child("gender");
    }
    public DatabaseReference getUserCPF(String login){
        return this.getCampoDB("users", login).child("cpf");
    }
    public DatabaseReference getUserRG(String login){
        return this.getCampoDB("users", login).child("rg");
    }
    public DatabaseReference getUserBirth(String login){
        return this.getCampoDB("users", login).child("birth");
    }
    public DatabaseReference getUserEmail(String login){
        return this.getCampoDB("users", login).child("email");
    }
    public DatabaseReference getUserPhone(String login){
        return this.getCampoDB("users", login).child("phone");
    }

    public void newUser(String login, Person person) {
        getUser(login).setValue(person);

    }


}
