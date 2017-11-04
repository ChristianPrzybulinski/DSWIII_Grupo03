package Database;

import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Chris on 04/11/2017.
 */

public class DatabaseListenerCheckBox implements ValueEventListener {

    private CheckBox text;

    public DatabaseListenerCheckBox(CheckBox text){
        this.text = text;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.exists())
            text.setChecked(dataSnapshot.getValue(boolean.class));
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
