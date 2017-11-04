package dev3.dswiii_grupo03;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import Database.DatabaseListenerProfile;
import Database.DatabaseListenerProfileEditable;
import Database.DatabaseUser;

public class Profile extends ManagerActivity {

    private String login;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Perfil de Usuário");
        setContentView(R.layout.activity_profile);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);   // identifica a toolbar sendo usada
        setSupportActionBar(myToolbar);


        this.login = getIntent().getStringExtra("login");
        this.name = (EditText) findViewById(R.id.edit_name);
        loadProfileInformation();
    }

    protected void loadProfileInformation(){
        //GET INFORMATIONS
        dbUser.getUserName(this.login).addListenerForSingleValueEvent(new DatabaseListenerProfile(this.name));

        //set editable Fields
        dbUser.getUserAdmin(this.login).addValueEventListener(new DatabaseListenerProfileEditable(this.name));
    }

    protected void saveInformation(){
        dbUser.setUserName(this.login, this.name.getText().toString());
    }

}
