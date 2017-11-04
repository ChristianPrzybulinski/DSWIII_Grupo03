package dev3.dswiii_grupo03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import Database.DatabaseUser;

/**
 * Created by Chris on 04/11/2017.
 */

public class ManagerActivity extends AppCompatActivity {

    protected MyApp mMyApp;
    protected DatabaseUser dbUser;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMyApp = (MyApp)this.getApplicationContext();
        dbUser = new DatabaseUser();
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
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

}
