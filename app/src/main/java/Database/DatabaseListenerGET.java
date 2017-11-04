package Database;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Chris on 04/11/2017.
 */



public class DatabaseListenerGET implements ValueEventListener {

    protected String value;

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
       this.value = dataSnapshot.getValue(this.value.getClass());
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        this.value = "";
    }

    public String getValue(){return this.value;}
}
