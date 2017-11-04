package dev3.dswiii_grupo03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Inicio");
        setContentView(R.layout.activity_menu_principal);   // referencia a atividade em questão
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);   // identifica a toolbar sendo usada
        setSupportActionBar(myToolbar);
    }



    /*
     * A seção abaixo cria o menu lateral da action bar dentro da activity
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        getMenuInflater().inflate(R.menu.menu_main, menu);   // referencia ao layout criado no path res/menu
        return super.onCreateOptionsMenu(menu);
    }

    /*
     * código comentado porque a conexão dos itens do menu e suas respectivas ações ainda não foi feita
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch(item.getItemId()) {
        case R.id.ImInicio:
            intent = new Intent(this, MenuPrincipal.class);
            this.startActivity(intent);
            break;
        case R.id.ImPerfil:
            intent = new Intent(this, Profile.class);
            this.startActivity(intent);
            break;
        default:
            return super.onOptionsItemSelected(item);
        }

        return true;
    }

}
