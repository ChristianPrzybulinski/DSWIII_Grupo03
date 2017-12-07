package dev3.dswiii_grupo03;

/**
 * Created by Thales on 06/12/2017.
 */


import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterUser extends ManagerActivity {

    private EditText login;
    private EditText password;
    private EditText name;
    private EditText genero;
    private EditText cpf;
    private EditText rg;
    private EditText dtnascimento;
    private EditText email;
    private EditText telefone;
    private CheckBox instrutor;
    private CheckBox ativo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Registrar usuário");
        setContentView(R.layout.activity_profile);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);   // identifica a toolbar sendo usada
        setSupportActionBar(myToolbar);


        this.login = (EditText) findViewById(R.id.edit_registerid);
        this.password = (EditText) findViewById(R.id.edit_registerpassword);
        this.name = (EditText) findViewById(R.id.edit_registername);
        this.genero = (EditText) findViewById(R.id.edit_registergender);
        this.cpf = (EditText) findViewById(R.id.edit_registercpf);
        this.rg = (EditText) findViewById(R.id.edit_registerrg);
        this.dtnascimento = (EditText) findViewById(R.id.edit_registerbirth);
        this.email = (EditText) findViewById(R.id.edit_registeremail);
        this.telefone = (EditText) findViewById(R.id.edit_registerphone);
        this.instrutor = (CheckBox) findViewById(R.id.edit_registerinstrutor);
        this.ativo = (CheckBox) findViewById(R.id.edit_registeractive);

        Button salvar = (Button) findViewById(R.id.if_save);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveInformation();
            }
        });
    }

    protected void saveInformation(){
        //falta lançar msg e bloquear pra não salvar caso campos sejam vazios
        if (this.login.getText().toString() == "") {};
        if (this.password.getText().toString() == "") {};
        if (this.name.getText().toString() == "") {};
        if (this.genero.getText().toString() == "") {};
        if (this.cpf.getText().toString() == "") {};
        if (this.rg.getText().toString() == "") {};
        if (this.email.getText().toString() == "") {};
        if (this.telefone.getText().toString() == "") {};
        if (this.dtnascimento.getText().toString() == "") {};

        dbUser.setUser(this.login.getText().toString());
        dbUser.setUserPassword(this.login.getText().toString(), this.password.getText().toString());
        dbUser.setUserName(this.login.getText().toString(), this.name.getText().toString());
        dbUser.setUserGender(this.login.getText().toString(), this.genero.getText().toString());
        dbUser.setUserCPF(this.login.getText().toString(), this.cpf.getText().toString());
        dbUser.setUserRG(this.login.getText().toString(), this.rg.getText().toString());
        dbUser.setUserEmail(this.login.getText().toString(), this.email.getText().toString());
        dbUser.setUserPhone(this.login.getText().toString(), this.telefone.getText().toString());
        dbUser.setUserBirth(this.login.getText().toString(), this.dtnascimento.getText().toString());
        dbUser.setUserAdmin(this.login.getText().toString(), this.instrutor.isChecked());
        dbUser.setUserAtivo(this.login.getText().toString(), this.ativo.isChecked());

        CharSequence text = "Profile saved!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
        finish();
    }

}
