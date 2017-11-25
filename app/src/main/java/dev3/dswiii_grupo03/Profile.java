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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import Database.DatabaseListenerCheckBox;
import Database.DatabaseListenerCheckBoxEditable;
import Database.DatabaseListenerProfile;
import Database.DatabaseListenerProfileEditable;
import Database.DatabaseUser;

public class Profile extends ManagerActivity {

    private String login;
    private EditText name;
    private EditText genero;
    private EditText cpf;
    private EditText username;
    private EditText rg;
    private EditText dtnascimento;
    private EditText email;
    private EditText telefone;
    private CheckBox instrutor;
    private CheckBox ativo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Perfil de Usuário");
        setContentView(R.layout.activity_profile);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);   // identifica a toolbar sendo usada
        setSupportActionBar(myToolbar);


        this.login = getIntent().getStringExtra("login");
        this.name = (EditText) findViewById(R.id.edit_name);
        this.genero = (EditText) findViewById(R.id.edit_gender);
        this.cpf = (EditText) findViewById(R.id.edit_cpf);
        this.rg = (EditText) findViewById(R.id.edit_rg);
        this.username = (EditText) findViewById(R.id.edit_id);
        this.dtnascimento = (EditText) findViewById(R.id.edit_birth);
        this.email = (EditText) findViewById(R.id.edit_email);
        this.telefone = (EditText) findViewById(R.id.edit_phone);
        this.instrutor = (CheckBox) findViewById(R.id.edit_instrutor);
        this.ativo = (CheckBox) findViewById(R.id.edit_active);
        loadProfileInformation();

        Button salvar = (Button) findViewById(R.id.if_save);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveInformation();
            }
        });
    }

    protected void loadProfileInformation(){
        //GET INFORMATIONS
        dbUser.getUserName(this.login).addListenerForSingleValueEvent(new DatabaseListenerProfile(this.name));
        dbUser.getUserGender(this.login).addListenerForSingleValueEvent(new DatabaseListenerProfile(this.genero));
        dbUser.getUserCPF(this.login).addListenerForSingleValueEvent(new DatabaseListenerProfile(this.cpf));
        dbUser.getUserRG(this.login).addListenerForSingleValueEvent(new DatabaseListenerProfile(this.rg));
        dbUser.getUserBirth(this.login).addListenerForSingleValueEvent(new DatabaseListenerProfile(this.dtnascimento));
        dbUser.getUserEmail(this.login).addListenerForSingleValueEvent(new DatabaseListenerProfile(this.email));
        dbUser.getUserPhone(this.login).addListenerForSingleValueEvent(new DatabaseListenerProfile(this.telefone));
        dbUser.getUserAdmin(this.login).addListenerForSingleValueEvent(new DatabaseListenerCheckBox(this.instrutor));
        dbUser.getUserAtivo(this.login).addListenerForSingleValueEvent(new DatabaseListenerCheckBox(this.ativo));
        this.username.setText(this.login);


        //set editable Fields - only admins
        dbUser.getUserAdmin(this.login).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                genero.setEnabled(dataSnapshot.getValue(boolean.class));
                cpf.setEnabled(dataSnapshot.getValue(boolean.class));
                rg.setEnabled(dataSnapshot.getValue(boolean.class));
                dtnascimento.setEnabled(dataSnapshot.getValue(boolean.class));
                instrutor.setEnabled(dataSnapshot.getValue(boolean.class));
                ativo.setEnabled(dataSnapshot.getValue(boolean.class));
                username.setEnabled(dataSnapshot.getValue(boolean.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    protected void saveInformation(){
        dbUser.setUserName(this.login, this.name.getText().toString());
        dbUser.setUserGender(this.login, this.genero.getText().toString());
        dbUser.setUserCPF(this.login, this.cpf.getText().toString());
        dbUser.setUserRG(this.login, this.rg.getText().toString());
        dbUser.setUserEmail(this.login, this.email.getText().toString());
        dbUser.setUserPhone(this.login, this.telefone.getText().toString());
        dbUser.setUserBirth(this.login, this.dtnascimento.getText().toString());
        dbUser.setUserAdmin(this.login, this.instrutor.isChecked());
        dbUser.setUserAtivo(this.login, this.ativo.isChecked());

        CharSequence text = "Profile saved!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
        finish();
    }

}
