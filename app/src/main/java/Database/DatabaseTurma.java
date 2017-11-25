package Database;

import com.google.firebase.database.DatabaseReference;

/**
 * Created by Chris on 04/11/2017.
 */

public class DatabaseTurma extends DatabaseConnect {

    public DatabaseTurma() {
        super();
    }

    public DatabaseReference getTurma(String dia) {
        return this.getCampoDB("turmas", dia);
    }

    public DatabaseReference getTurmas() {
        return this.getRoot().child("turmas");
    }

}
