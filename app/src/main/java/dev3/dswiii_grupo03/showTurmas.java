package dev3.dswiii_grupo03;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import cls.Turma;

public class showTurmas extends ManagerActivity {

    private String dia;
    private List<Turma> turmas;
    private ArrayAdapter<Turma> adapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Turmas");
        setContentView(R.layout.activity_show_turmas);   // referencia a atividade em questão
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);   // identifica a toolbar sendo usada
        setSupportActionBar(myToolbar);
        this.dia = getIntent().getStringExtra("dia");
        this.turmas = new ArrayList<>();
        showBar((RelativeLayout)findViewById(R.id.display));
        getAllTurmas();

        FloatingActionButton flt = (FloatingActionButton) findViewById(R.id.fab);
        if(!this.admin) flt.setVisibility(View.GONE);

        flt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuIntent = new Intent(showTurmas.this, createTurma.class).putExtra("dia", dia);
                startActivity(menuIntent);
            }
        });


        ListView listaDeTurmas = (ListView) findViewById(R.id.lista);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, turmas);
        listaDeTurmas.setAdapter(adapter);

        listaDeTurmas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //userNewTurma(i)
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(showTurmas.this);
                builder.setMessage("Quer se inscrever nessa turma?").setPositiveButton("Sim", dialogClickListener)
                        .setNegativeButton("Não", dialogClickListener).show();
            }
        });

    }

    private void getAllTurmas(){
        dbTurma.getTurma(dia).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp : dataSnapshot.getChildren()){
                    turmas.clear();
                    turmas.add(dsp.getValue(Turma.class));
                    adapter.notifyDataSetChanged();
                }
               unShowBar();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
