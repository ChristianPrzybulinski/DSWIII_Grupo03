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

    public DatabaseReference getUserTurma(String login,String dia) {
        return this.getCampoDB("users", login).child("Turmas").child(dia);
    }


    public DatabaseReference getUsers() {
        return this.getRoot().child("users");
    }

    public void newUser(String login, Person person) {
        getUser(login).setValue(person);

    }

    public void setPassword(String login, String password){
        getUser(login).child("password").setValue(password);
    }

    public void newTurma(String login, Turma turma, String dia) {
        getUser(login).child("Turmas").child(dia).push().setValue(turma);

    }


}
