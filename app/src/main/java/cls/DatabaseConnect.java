package cls;

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
    private String sCampo;
    private DatabaseReference db;

    public DatabaseConnect() {
        this.db = FirebaseDatabase.getInstance().getReference();
    }

    public String GetUser(String sPrimaryKey, String sChild){
       GetCampoDB("users", sPrimaryKey, sChild);
       return this.sCampo;
    }

    public void GetCampoDB(String sTable, String sPrimaryKey, String sChild){
        DatabaseReference dbInstance = db.child(sTable).child(sPrimaryKey).child(sChild);

        dbInstance.addListenerForSingleValueEvent(new ValueEventListener(){
            @Override

            public void onDataChange(DataSnapshot   dataSnapshot) {
                sCampo = dataSnapshot.getValue(String.class);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
