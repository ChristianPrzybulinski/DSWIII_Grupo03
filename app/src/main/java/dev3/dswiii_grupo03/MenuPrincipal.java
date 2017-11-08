package dev3.dswiii_grupo03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import Database.DatabaseListenerCheckBox;
import Database.DatabaseListenerProfile;


public class MenuPrincipal extends ManagerActivity {
    private String login;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Inicio");
        setContentView(R.layout.activity_menu_principal);   // referencia a atividade em questão
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);   // identifica a toolbar sendo usada
        setSupportActionBar(myToolbar);

        this.login = getIntent().getStringExtra("login");
        this.name = (EditText) findViewById(R.id.edit_name);
        loadProfileInformation();
        this.name.setText("Bem vindo"+this.name);
    }


    protected void loadProfileInformation(){
        //GET INFORMATIONS
        dbUser.getUserName(this.login).addListenerForSingleValueEvent(new DatabaseListenerProfile(this.name));
    }



}
