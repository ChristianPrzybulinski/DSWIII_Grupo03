package Database;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Chris on 04/11/2017.
 */

public class DatabaseUser extends DatabaseConnect {

    private boolean exists;
    private boolean mudou = false;

    public DatabaseUser() {
        super();
    }

    public DatabaseReference getUser(String sPrimaryKey) {
        return this.getCampoDB("users", sPrimaryKey);
    }

    public String getPassword(String login) {
        DatabaseListenerGET dbGet = new DatabaseListenerGET();
        this.getUser(login).child("Password").addListenerForSingleValueEvent(dbGet);
        return dbGet.getValue();
    }

    public boolean loginExists(String login){
        DatabaseReference ref = this.getUser(login);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                exists = dataSnapshot.exists();
                mudou = true;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                exists = false;
                mudou = true;
            }
        });

        while(!mudou){
        }
        return exists;
    }
}
