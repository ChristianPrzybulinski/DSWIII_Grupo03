package Database;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Chris on 04/11/2017.
 */



public class DatabaseListenerCHECK implements ValueEventListener {

    protected boolean hasChild = false;

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.exists()) this.hasChild = true;
        else this.hasChild = false;
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        this.hasChild = false;
    }

    public boolean hasChild() {return hasChild;}
}
