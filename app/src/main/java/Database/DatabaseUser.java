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

    public DatabaseReference getUser(String login) {
        return this.getCampoDB("users", login);
    }

    public DatabaseReference getUserPassword(String login){
        return this.getCampoDB("users", login).child("pass");
    }
}
