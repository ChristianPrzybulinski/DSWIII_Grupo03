package Database;

/**
 * Created by Thales on 15/11/2017.
 */

import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Chris on 04/11/2017.
 */

public class DatabaseListenerAdministrador implements ValueEventListener {

    private EditText administrador;

    public DatabaseListenerAdministrador(EditText administrador){
        this.administrador = administrador;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.exists()) {
            if (dataSnapshot.getValue(boolean.class)) {
                this.administrador.setText("instrutor");
            } else
                this.administrador.setText("aluno");
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
