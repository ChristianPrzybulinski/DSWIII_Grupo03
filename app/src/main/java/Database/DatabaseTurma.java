package Database;

import android.util.Log;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.Map;

import cls.Turma;

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

    public void newTurma(String dia, String nome, String horaI, String horaT, String instrutor) {
        getTurma(dia).push().setValue(new Turma(horaI, horaT, instrutor, nome));

    }
}
