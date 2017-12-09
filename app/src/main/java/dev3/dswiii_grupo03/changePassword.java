package dev3.dswiii_grupo03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class changePassword extends ManagerActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Change Password");
        setContentView(R.layout.activity_change_password);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);   // identifica a toolbar sendo usada
        setSupportActionBar(myToolbar);

        Button btnsave = (Button) findViewById(R.id.btn_change_pw);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(convertPassMd5(((EditText) findViewById(R.id.old_password)).getText().toString()).equals(user.password)){
                    dbUser.setPassword(user.login,
                            convertPassMd5(((EditText) findViewById(R.id.new_password1)).getText().toString()));
                    user.password =  convertPassMd5(((EditText) findViewById(R.id.new_password1)).getText().toString());
                    showText("Password changed!");
                    Intent menuIntent = new Intent(changePassword.this, MenuPrincipal.class).putExtra("user",user);
                    startActivity(menuIntent);
                    finish();
                }
                else{
                    ((EditText)findViewById(R.id.old_password)).setError("Senha invalida");
                    View focusView = findViewById(R.id.old_password);
                    focusView.requestFocus();
                }
            }
        });


    }
}

