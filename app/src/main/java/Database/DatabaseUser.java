package Database;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

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

    public void setUserName(String login, String name){
        this.getUserName(login).setValue(name);
    }
    public void setUserGender(String login, String name){
        this.getUserGender(login).setValue(name);
    }
    public void setUserCPF(String login, String name){
        this.getUserCPF(login).setValue(name);
    }
    public void setUserRG(String login, String name){
        this.getUserRG(login).setValue(name);
    }
    public void setUserPhone(String login, String name){
        this.getUserPhone(login).setValue(name);
    }
    public void setUserEmail(String login, String name){
        this.getUserEmail(login).setValue(name);
    }
    public void setUserBirth(String login, String name){
        this.getUserBirth(login).setValue(name);
    }
    public void setUserAdmin(String login, boolean name){
        this.getUserAdmin(login).setValue(name);
    }
    public void setUserAtivo(String login, boolean name){
        this.getUserAtivo(login).setValue(name);
    }
}
