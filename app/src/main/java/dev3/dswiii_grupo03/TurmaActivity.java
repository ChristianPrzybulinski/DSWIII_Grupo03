package dev3.dswiii_grupo03;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import cls.Turma;

public class TurmaActivity extends ManagerActivity {

    private String login;
    private boolean admin;
    ArrayAdapter<Turma> adapter;
    Button segbtn;
    Button terbtn;
    Button quabtn;
    Button quibtn;
    Button sexbtn;
    Button sabbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Turmas");

        setContentView(R.layout.activity_turma);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);   // identifica a toolbar sendo usada
        setSupportActionBar(myToolbar);

        this.login = getIntent().getStringExtra("login");
        this.admin = getIntent().getBooleanExtra("admin",true);


        ListView listaDeCursos = (ListView) findViewById(R.id.listaTurma);
        adapter= new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, new ArrayList<Turma>());
        listaDeCursos.setAdapter(adapter);


        FloatingActionButton flotbtn = (FloatingActionButton) findViewById(R.id.btnNewTurma);
        segbtn = (Button) findViewById(R.id.btnsegunda);
        terbtn = (Button) findViewById(R.id.btnterca);
        quabtn = (Button) findViewById(R.id.btnquarta);
        quibtn = (Button) findViewById(R.id.btnquinta);
        sexbtn = (Button) findViewById(R.id.btnsexta);
        sabbtn = (Button) findViewById(R.id.btnsabado);
        resetColors();
        //se nao for adm
        if(!this.admin) flotbtn.setVisibility(View.GONE);
        flotbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuIntent = new Intent(TurmaActivity.this, createTurma.class);
                startActivity(menuIntent);
            }
        });
        segbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todasTurmas("Segunda", view);
            }
        });
        terbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todasTurmas("Terça", view);
            }
        });
        quabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todasTurmas("Quarta", view);
            }
        });
        quibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todasTurmas("Quinta", view);
            }
        });
        sexbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todasTurmas("Sexta", view);
            }
        });
        sabbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todasTurmas("Sabado", view);
            }
        });

        listaDeCursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setBackgroundColor(Color.DKGRAY);
            }
        });

    }


    private void resetColors(){
        segbtn.setBackgroundColor(Color.GRAY);
        terbtn.setBackgroundColor(Color.GRAY);
        quabtn.setBackgroundColor(Color.GRAY);
        quibtn.setBackgroundColor(Color.GRAY);
        sexbtn.setBackgroundColor(Color.GRAY);
        sabbtn.setBackgroundColor(Color.GRAY);
    }
    private void todasTurmas(String dia, View view) {
        adapter.clear();
        resetColors();
        view.setBackgroundColor(Color.YELLOW);
        dbTurma.getTurma(dia).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    String turma = postSnapshot.child("name").getValue().toString();
                    String horaInicio = postSnapshot.child("horaInicio").getValue().toString();
                    String horaTermino = postSnapshot.child("horaTermino").getValue().toString();
                    String instrutor = postSnapshot.child("instrutor").getValue().toString();
                    adapter.add(new Turma(horaInicio,horaTermino,instrutor,turma));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

}
