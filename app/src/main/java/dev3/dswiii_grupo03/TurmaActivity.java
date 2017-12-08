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

    Button segbtn, terbtn,quabtn,quibtn,sexbtn,sabbtn, dombtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Turmas");

        setContentView(R.layout.activity_turma);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);   // identifica a toolbar sendo usada
        setSupportActionBar(myToolbar);

        dombtn = (Button) findViewById(R.id.btn_sunday);
        segbtn = (Button) findViewById(R.id.btn_monday);
        terbtn = (Button) findViewById(R.id.btn_tuesday);
        quabtn = (Button) findViewById(R.id.btn_wednesday);
        quibtn = (Button) findViewById(R.id.btn_thursday);
        sexbtn = (Button) findViewById(R.id.btn_friday);
        sabbtn = (Button) findViewById(R.id.btn_saturday);

        dombtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedButton("Domingo");
            }
        });
        segbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedButton("Segunda");
            }
        });
        terbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedButton("Terça");
            }
        });
        quabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedButton("Quarta");
            }
        });
        quibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedButton("Quinta");
            }
        });
        sexbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedButton("Sexta");
            }
        });
        sabbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedButton("Sabado");
            }
        });
    }

    private void clickedButton(String dia) {
        Intent menuIntent = new Intent(this, showTurmas.class).putExtra("dia",dia);
        startActivity(menuIntent);
    }

}
