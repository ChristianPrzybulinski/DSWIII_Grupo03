package Database;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import dev3.dswiii_grupo03.R;

/**
 * Created by Chris on 04/11/2017.
 */

public class DatabaseListenerProfile implements ValueEventListener {

    private EditText text;

    public DatabaseListenerProfile(EditText text){
        this.text = text;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        text.setText(dataSnapshot.getValue().toString());
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
