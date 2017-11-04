package dev3.dswiii_grupo03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
    private DatabaseUser dbUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Perfil de Usuário");
        setContentView(R.layout.activity_profile);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);   // identifica a toolbar sendo usada
        setSupportActionBar(myToolbar);

        loadProfileInformation();
    }



    protected void loadProfileInformation(){
        String login = getIntent().getStringExtra("login");
        EditText name = (EditText) findViewById(R.id.edit_name);

        //GET INFORMATIONS
        dbUser.getUserName(login).addValueEventListener(new DatabaseListenerProfile(name));
        dbUser.getUserName(login).addValueEventListener(new DatabaseListenerProfile(name));

        //set editable Fields
        dbUser.getUserAdmin(login).addValueEventListener(new DatabaseListenerProfileEditable(name));
    }

}
