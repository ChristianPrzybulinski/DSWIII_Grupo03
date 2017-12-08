package dev3.dswiii_grupo03;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import Database.DatabaseListenerAdministrador;
import Database.DatabaseListenerCheckBox;
import Database.DatabaseListenerProfile;
import cls.Person;
import cls.Turma;


public class MenuPrincipal extends ManagerActivity {

    private ArrayAdapter<Turma> adapter;
    private List<Turma> turmas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Inicio");
        setContentView(R.layout.activity_menu_principal);   // referencia a atividade em questão
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);   // identifica a toolbar sendo usada
        setSupportActionBar(myToolbar);



        TextView name = (TextView) findViewById(R.id.text_name);
        name.setText(user.name);

        this.turmas = new ArrayList<>();
        getAllTurmas();


        ListView listaDeTurmas = (ListView) findViewById(R.id.et_list);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, turmas);
        listaDeTurmas.setAdapter(adapter);

        FloatingActionButton newuser = (FloatingActionButton) findViewById(R.id.flt_newuser);
        if (!user.isAdmin) newuser.setVisibility(View.GONE);
        else {
            newuser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent menuIntent = new Intent(MenuPrincipal.this, Profile.class).putExtra("user", user).putExtra("newUser", true);
                    startActivity(menuIntent);
                    finish();
                }
            });
        }
    }

    private String getDay(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        String dia = "Domingo";
        switch (day) {
            case Calendar.SUNDAY:
                dia = "Domingo";
                break;
            case Calendar.MONDAY:
                dia = "Segunda";
                break;
            case Calendar.TUESDAY:
                dia = "Terça";
                break;
            case Calendar.WEDNESDAY:
                dia = "Quarta";
                break;
            case Calendar.THURSDAY:
                dia = "Quinta";
                break;
            case Calendar.FRIDAY:
                dia = "Sexta";
                break;
            case Calendar.SATURDAY:
                dia = "Sabado";
                break;
        }
        return dia;
    }

    protected void getAllTurmas(){


        dbUser.getUserTurma(this.user.login, getDay()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp : dataSnapshot.getChildren()){
                    turmas.clear();
                    turmas.add(dsp.getValue(Turma.class));
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
