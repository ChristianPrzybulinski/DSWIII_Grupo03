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
import cls.Person;

public class Profile extends ManagerActivity {

    private boolean newUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);   // identifica a toolbar sendo usada
        setSupportActionBar(myToolbar);

        this.newUser = getIntent().getBooleanExtra("newUser", true);
        if(this.newUser)  setTitle("Criar usuário");
        else setTitle("Perfil");


        Button salvar = (Button) findViewById(R.id.if_save);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveInformation();
            }
        });
    }

    protected void saveInformation(){
        Person p = new Person(
                ((EditText)findViewById(R.id.edit_name)).getText().toString(),
                ((EditText)findViewById(R.id.edit_gender)).getText().toString(),
                ((EditText)findViewById(R.id.edit_cpf)).getText().toString(),
                ((EditText)findViewById(R.id.edit_rg)).getText().toString(),
                ((EditText)findViewById(R.id.edit_birth)).getText().toString(),
                ((CheckBox)findViewById(R.id.edit_active)).isChecked(),
                ((CheckBox)findViewById(R.id.edit_instrutor)).isChecked(),
                ((EditText)findViewById(R.id.edit_phone)).getText().toString(),
                ((EditText)findViewById(R.id.edit_email)).getText().toString(),
                ((EditText)findViewById(R.id.edit_id)).getText().toString(),
                convertPassMd5(((EditText)findViewById(R.id.edit_password)).getText().toString())
        );

        dbUser.newUser(((EditText)findViewById(R.id.edit_id)).getText().toString(), p);

        showText("Profile saved!");
        finish();
    }

}
