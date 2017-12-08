package dev3.dswiii_grupo03;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import cls.Turma;

public class createTurma extends ManagerActivity {

    private String dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Nova Turma");
        setContentView(R.layout.activity_create_turma);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);   // identifica a toolbar sendo usada
        setSupportActionBar(myToolbar);

        Button cancelar = (Button) findViewById(R.id.btnCancelarTurma);
        Button salvar = (Button) findViewById(R.id.btnSalvarNewTurma);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        this.dia = getIntent().getStringExtra("dia");

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nome = (EditText) findViewById(R.id.txtNomeTurma);
                EditText instrutor = (EditText) findViewById(R.id.txtInstrutor);
                EditText inicio = (EditText) findViewById(R.id.txtHoraInicio);
                EditText termino = (EditText) findViewById(R.id.txtHoraTermino);
                if (!isEmptyText(nome)) {
                    if (!isEmptyText(instrutor)) {
                        if (!isEmptyText(inicio)) {
                            if (!isEmptyText(termino)) {
                                dbTurma.newTurma(dia,nome.getText().toString()
                                        ,inicio.getText().toString(),termino.getText().toString()
                                        ,instrutor.getText().toString());
                                showText("Turma criada com sucesso");
                                finish();
                            }
                        }
                    }
                }
            }
        });
    }

    private boolean isEmptyText(EditText etText) {
        if (etText.getText().toString().trim().length() <= 0) {
            etText.setError("Preencha este campo!");
            View focusView = etText;
            focusView.requestFocus();
            return true;
        }
        return false;
    }
}

