package Database;

import com.google.firebase.database.DatabaseReference;

/**
 * Created by Chris on 04/11/2017.
 */

public class DatabaseUser extends DatabaseConnect{

    public DatabaseUser(){
        super();
    }

    protected DatabaseReference getUser(String sPrimaryKey){
        return this.getCampoDB("users", sPrimaryKey);
    }

    public String getPassword(String login){
        DatabaseListenerGET dbGet = new DatabaseListenerGET();
        this.getUser(login).child("Password").addListenerForSingleValueEvent(dbGet);
        return dbGet.getValue();
    }

    public boolean loginExists(String login){
        DatabaseListenerCHECK check = new DatabaseListenerCHECK();
        this.getUser(login).addListenerForSingleValueEvent(check);
        return check.hasChild();
    }
}
