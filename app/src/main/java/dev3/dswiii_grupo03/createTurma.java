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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Turma");
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

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nome = (EditText) findViewById(R.id.txtNomeTurma);
                EditText instrutor = (EditText) findViewById(R.id.txtInstrutor);
                EditText inicio = (EditText) findViewById(R.id.txtHoraInicio);
                EditText termino = (EditText) findViewById(R.id.txtHoraTermino);

                CheckBox seg = (CheckBox) findViewById(R.id.cbSegunda);
                CheckBox ter = (CheckBox) findViewById(R.id.cbTerca);
                CheckBox qua = (CheckBox) findViewById(R.id.cbQuarta);
                CheckBox qui = (CheckBox) findViewById(R.id.cbQuinta);
                CheckBox sex = (CheckBox) findViewById(R.id.cbSexta);
                CheckBox sab = (CheckBox) findViewById(R.id.cbSabado);
                int contador = 0;

                if(!isEmptyText(nome))
                    if(!isEmptyText(inicio))
                        if(!isEmptyText(termino))
                            if(!isEmptyText(instrutor)){
                                if (seg.isChecked()) {
                                    dbTurma.newTurma("Segunda",
                                            nome.getText().toString(), inicio.getText().toString(), termino.getText().toString(),
                                            instrutor.getText().toString());
                                    contador++;
                                }
                                if (ter.isChecked()) {
                                    dbTurma.newTurma("Terça",
                                            nome.getText().toString(), inicio.getText().toString(), termino.getText().toString(),
                                            instrutor.getText().toString());
                                    contador++;
                                }
                                if (qua.isChecked()) {
                                    dbTurma.newTurma("Quarta",
                                            nome.getText().toString(), inicio.getText().toString(), termino.getText().toString(),
                                            instrutor.getText().toString());
                                    contador++;
                                }
                                if (qui.isChecked()) {
                                    dbTurma.newTurma("Quinta",
                                            nome.getText().toString(), inicio.getText().toString(), termino.getText().toString(),
                                            instrutor.getText().toString());
                                    contador++;
                                }
                                if (sex.isChecked()) {
                                    dbTurma.newTurma("Sexta",
                                            nome.getText().toString(), inicio.getText().toString(), termino.getText().toString(),
                                            instrutor.getText().toString());
                                    contador++;
                                }
                                if (sab.isChecked()) {
                                    dbTurma.newTurma("Sabado",
                                            nome.getText().toString(), inicio.getText().toString(), termino.getText().toString(),
                                            instrutor.getText().toString());
                                    contador++;
                                }
                            }
                if(contador == 0){
                    CharSequence text = "Selecione pelo menos um dia!!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(createTurma.this, text, duration);
                    toast.show();
                }else{
                    CharSequence text = "Turma criada com sucesso!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(createTurma.this, text, duration);
                    toast.show();
                    finish();
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
