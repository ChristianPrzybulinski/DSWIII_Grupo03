package dev3.dswiii_grupo03;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Database.DatabaseListenerAdministrador;
import Database.DatabaseListenerCheckBox;
import Database.DatabaseListenerProfile;
import cls.Turma;


public class MenuPrincipal extends ManagerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Inicio");
        setContentView(R.layout.activity_menu_principal);   // referencia a atividade em questão
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);   // identifica a toolbar sendo usada
        setSupportActionBar(myToolbar);

        TextView name = (TextView) findViewById(R.id.text_name);
        //this.administrador = (EditText) findViewById(R.id.edit_tipoUsuario);

        loadProfileInformation(name);
        getAllTurmas();
    }


    protected void loadProfileInformation(final TextView name){
        //GET INFORMATION
        dbUser.getUserName(this.login).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String output = dataSnapshot.getValue(String.class);
                name.setText(output);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
       // dbUser.getUserAdmin(this.login).addListenerForSingleValueEvent(new DatabaseListenerAdministrador(this.administrador));

    }

    protected void getAllTurmas(){

        String dia = "Segunda";
        final List<Turma> turmas = new ArrayList<>();

        dbTurma.getTurma(dia).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp : dataSnapshot.getChildren()){
                    turmas.clear();
                    turmas.add(dsp.getValue(Turma.class));
                }
                unShowBar();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
