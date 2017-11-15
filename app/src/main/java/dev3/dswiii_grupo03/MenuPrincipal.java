package dev3.dswiii_grupo03;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import android.widget.EditText;

import Database.DatabaseListenerAdministrador;
import Database.DatabaseListenerCheckBox;
import Database.DatabaseListenerProfile;


public class MenuPrincipal extends ManagerActivity {
    private String login;
    private EditText name;
    private EditText administrador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Inicio");
        setContentView(R.layout.activity_menu_principal);   // referencia a atividade em questão
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);   // identifica a toolbar sendo usada
        setSupportActionBar(myToolbar);

        this.login = getIntent().getStringExtra("login");
        this.name = (EditText) findViewById(R.id.edit_name);
        this.administrador = (EditText) findViewById(R.id.edit_tipoUsuario);

        loadProfileInformation();

    }


    protected void loadProfileInformation(){
        //GET INFORMATIONS
        dbUser.getUserName(this.login).addListenerForSingleValueEvent(new DatabaseListenerProfile(this.name));
        dbUser.getUserAdmin(this.login).addListenerForSingleValueEvent(new DatabaseListenerAdministrador(this.administrador));

    }



}
