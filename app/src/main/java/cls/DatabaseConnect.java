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

    private DatabaseReference db;

    public DatabaseConnect() {
        this.db = FirebaseDatabase.getInstance().getReference("dev-iii-grupo-3");
    }

    public void teste(){

        DatabaseReference db = FirebaseDatabase.getInstance().getReference();
        DatabaseReference dbInstance = db.child("users").child("christianrp").child("Name");

        dbInstance.addListenerForSingleValueEvent(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot   dataSnapshot) {
                String email = dataSnapshot.getValue(String.class);
                Log.d("testedaporra", email);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
