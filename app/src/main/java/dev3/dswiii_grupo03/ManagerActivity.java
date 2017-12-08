package dev3.dswiii_grupo03;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Database.DatabaseTurma;
import Database.DatabaseUser;

/**
 * Created by Chris on 04/11/2017.
 */

public class ManagerActivity extends AppCompatActivity {

    protected MyApp mMyApp;
    protected DatabaseUser dbUser;
    protected DatabaseTurma dbTurma;
    protected String login;
    protected boolean admin;
    protected ProgressBar progressBar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMyApp = (MyApp)this.getApplicationContext();
        dbUser = new DatabaseUser();
        dbTurma = new DatabaseTurma();
        this.login = getIntent().getStringExtra("login");
        this.admin = getIntent().getBooleanExtra("admin", true);
    }

    protected void onResume() {
        super.onResume();
        mMyApp.setCurrentActivity(this);
    }
    protected void onPause() {
        clearReferences();
        super.onPause();
    }
    protected void onDestroy() {
        clearReferences();
        super.onDestroy();
    }

    private void clearReferences(){
        AppCompatActivity currActivity = mMyApp.getCurrentActivity();
        if (this.equals(currActivity))
            mMyApp.setCurrentActivity(null);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        getMenuInflater().inflate(R.menu.menu_main, menu);   // referencia ao layout criado no path res/menu
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch(item.getItemId()) {
            case R.id.ImInicio:
                if(!mMyApp.getCurrentActivity().getClass().equals(MenuPrincipal.class)) {
                    intent = new Intent(this, MenuPrincipal.class).putExtra("login", getIntent().getStringExtra("login"));
                    this.startActivity(intent);
                }
                break;
            case R.id.ImPerfil:
                if(!mMyApp.getCurrentActivity().getClass().equals(Profile.class)) {
                    intent = new Intent(this, Profile.class).putExtra("login", getIntent().getStringExtra("login"));
                    this.startActivity(intent);
                }
                break;
            case R.id.ImTurma:
                if(!mMyApp.getCurrentActivity().getClass().equals(TurmaActivity.class)) {
                    intent = new Intent(this, TurmaActivity.class).putExtra("login", getIntent().getStringExtra("login"));
                    this.startActivity(intent);
                }
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }


    protected void showText(String t){
        CharSequence text = t;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
    }


    protected void showBar(RelativeLayout layout){
        progressBar = new ProgressBar(this,null,android.R.attr.progressBarStyleSmall);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100,100);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        layout.addView(progressBar,params);
        progressBar.setVisibility(View.VISIBLE);  //To show ProgressBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    protected void unShowBar(){
        progressBar.setVisibility(View.GONE);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    public static String convertPassMd5(String pass) {
        String password = null;
        MessageDigest mdEnc;
        try {
            mdEnc = MessageDigest.getInstance("MD5");
            mdEnc.update(pass.getBytes(), 0, pass.length());
            pass = new BigInteger(1, mdEnc.digest()).toString(16);
            while (pass.length() < 32) {
                pass = "0" + pass;
            }
            password = pass;
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        return password;
    }

}
