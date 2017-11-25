package dev3.dswiii_grupo03;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import cls.Turma;

public class TurmaActivity extends ManagerActivity {

    private List<Turma> todasTurmas;
    private String login;
    private boolean admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Turmas");
        setContentView(R.layout.activity_turma);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);   // identifica a toolbar sendo usada
        setSupportActionBar(myToolbar);

        this.login = getIntent().getStringExtra("login");
        this.admin = getIntent().getBooleanExtra("admin",true);

        /*ListView listaDeCursos = (ListView) findViewById(R.id.listaTurma);

        ArrayAdapter<Turma> adapter = new ArrayAdapter<Turma>(this,
                android.R.layout.simple_list_item_1, todasTurmas);

        listaDeCursos.setAdapter(adapter);*/

        FloatingActionButton flotbtn = (FloatingActionButton) findViewById(R.id.btnNewTurma);
        //se nao for adm
        if(!this.admin) flotbtn.setVisibility(View.GONE);
        flotbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //popup para cadastro de nova turma colocando as informações necessários conforme classe turma
            }
        });

    }


    private void todasTurmas() {
        dbTurma.getTurmas().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //String turma = postSnapshot.getKey().toString();
                    String turma = postSnapshot.child("nome").getValue().toString();
                    String horaInicio = postSnapshot.child("horaInicio").getValue().toString();
                    String horaTermino = postSnapshot.child("horaTermino").getValue().toString();
                    String instrutor = postSnapshot.child("instrutor").getValue().toString();
                    todasTurmas.add(new Turma(horaInicio,horaTermino,instrutor,turma));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
