package Database;

import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Chris on 04/11/2017.
 */

public class DatabaseListenerProfileEditable implements ValueEventListener {

    private EditText text;

    public DatabaseListenerProfileEditable(EditText text){
        this.text = text;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(!dataSnapshot.getValue(boolean.class))
            text.setEnabled(false);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
