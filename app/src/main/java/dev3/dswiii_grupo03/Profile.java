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
import android.widget.RelativeLayout;
import android.widget.ScrollView;
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
        if(this.newUser) salvar.setText("Criar");
        else salvar.setText("Salvar");

        if(!this.newUser){
            loadInformation();
        }

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveInformation();
            }
        });
    }


    protected void loadInformation(){
        ((EditText)findViewById(R.id.edit_name)).setText(this.user.name);
        ((EditText)findViewById(R.id.edit_gender)).setText(this.user.gender);
        ((EditText)findViewById(R.id.edit_cpf)).setText(this.user.cpf);
        ((EditText)findViewById(R.id.edit_rg)).setText(this.user.rg);
        ((EditText)findViewById(R.id.edit_birth)).setText(this.user.birthDate);
        ((CheckBox)findViewById(R.id.edit_active)).setChecked(this.user.isActive);
        ((CheckBox)findViewById(R.id.edit_instrutor)).setChecked(this.user.isAdmin);
        ((EditText)findViewById(R.id.edit_phone)).setText(this.user.phoneNumber);
        ((EditText)findViewById(R.id.edit_email)).setText(this.user.email);
        ((EditText)findViewById(R.id.edit_id)).setText(this.user.login);

        //esconder password
        findViewById(R.id.edit_password).setVisibility(View.GONE);
        findViewById(R.id.edt_password).setVisibility(View.GONE);

        //ajusta caso nao for admin nao tem permissão
        findViewById(R.id.edit_cpf).setEnabled(this.user.isAdmin);
        findViewById(R.id.edit_rg).setEnabled(this.user.isAdmin);
        findViewById(R.id.edit_birth).setEnabled(this.user.isAdmin);
        findViewById(R.id.edit_active).setEnabled(this.user.isAdmin);
        findViewById(R.id.edit_instrutor).setEnabled(this.user.isAdmin);
        findViewById(R.id.edit_id).setEnabled(this.user.isAdmin);
    }

    protected void saveInformation(){
        String password;
        if(this.newUser) password = convertPassMd5(((EditText)findViewById(R.id.edit_password)).getText().toString());
        else password = this.user.password;


        if(validInfos()) {
            Person p = new Person(
                    ((EditText) findViewById(R.id.edit_name)).getText().toString(),
                    ((EditText) findViewById(R.id.edit_gender)).getText().toString(),
                    ((EditText) findViewById(R.id.edit_cpf)).getText().toString(),
                    ((EditText) findViewById(R.id.edit_rg)).getText().toString(),
                    ((EditText) findViewById(R.id.edit_birth)).getText().toString(),

                    ((CheckBox) findViewById(R.id.edit_instrutor)).isChecked(),
                    ((CheckBox) findViewById(R.id.edit_active)).isChecked(),
                    
                    ((EditText) findViewById(R.id.edit_phone)).getText().toString(),
                    ((EditText) findViewById(R.id.edit_email)).getText().toString(),
                    ((EditText) findViewById(R.id.edit_id)).getText().toString(),
                    password
            );

            dbUser.newUser(((EditText) findViewById(R.id.edit_id)).getText().toString(), p);

            if (this.newUser)
                showText("User created!");
            else {
                showText("Profile Saved");
                this.user = p;
            }
            Intent menuIntent = new Intent(Profile.this, MenuPrincipal.class).putExtra("user", this.user);
            startActivity(menuIntent);
            finish();
        }
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


    private boolean validInfos(){
        if(!isEmptyText((EditText)findViewById(R.id.edit_name)))
            if(!isEmptyText((EditText)findViewById(R.id.edit_gender)))
                if(!isEmptyText((EditText)findViewById(R.id.edit_cpf)))
                    if(!isEmptyText((EditText)findViewById(R.id.edit_rg)))
                        if(!isEmptyText((EditText)findViewById(R.id.edit_birth)))
                            if(!isEmptyText((EditText)findViewById(R.id.edit_phone)))
                                if(!isEmptyText((EditText)findViewById(R.id.edit_email)))
                                    if(!isEmptyText((EditText)findViewById(R.id.edit_id)))
                                        if(!isEmptyText((EditText)findViewById(R.id.edit_name)))
                                                return true;
        return false;
    }

}
