package Database;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by gaelrech on 03/11/17.
 */

public class DatabaseConnect {

    protected DatabaseReference db;

    public DatabaseConnect() {
        this.db = FirebaseDatabase.getInstance().getReference();
    }

    protected DatabaseReference getCampoDB(String sTable, String sPrimaryKey){
        return db.child(sTable).child(sPrimaryKey);
    }

}
