package dev3.dswiii_grupo03;

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
        setTitle("Academia ABC");
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
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);   // referencia ao layout criado no path res/menu
        return super.onCreateOptionsMenu(menu);
    }


    /*
     * código comentado porque a conexão dos itens do menu e suas respectivas ações ainda não foi feita
     *
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_compose:
                composeMessage();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    */
}
