package cls;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by gaelrech on 03/11/17.
 */

public class DatabaseConnect {

    private DatabaseReference db;

    public DatabaseConnect() {
        this.db = FirebaseDatabase.getInstance().getReference("dev-iii-grupo-3");
    }

    public void teste(){
        //Log.d(String.valueOf(this.db.getRef), "kkk");
    }

}
