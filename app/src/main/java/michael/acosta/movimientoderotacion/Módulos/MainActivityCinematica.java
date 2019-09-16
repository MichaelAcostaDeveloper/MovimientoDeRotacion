package michael.acosta.movimientoderotacion.Módulos;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import michael.acosta.movimientoderotacion.R;
import michael.acosta.movimientoderotacion.RecyclerAdapterCinematica;

public class MainActivityCinematica extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    RecyclerView recyclerView;//creamos la variable recyclerView de tipo RecyclerView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(), R.color.colorPrimary));
        SnackBarB();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_c);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setSubtitle("Cinemática de rotación");
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navegationView);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }
        //instancia de la clase RecyclerAdapterCinematica
        RecyclerAdapterCinematica adapter = new RecyclerAdapterCinematica(this);
        //identificamos la variable recyclerView con el elemento xml RecyclerViewContenidos
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewContenidos);
        //ponemos en la variable el objeto adapter
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    //submenu para el manual de usuario
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_manual, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_manual:
                Toast.makeText(MainActivityCinematica.this,
                        "Manual de usuario", Toast.LENGTH_SHORT).show();
                //Reemplazar la url por la de tu documento.
                String MY_URL = "https://drive.google.com/open?id=1d-GsdZnKKWs-sCgVB2jljUaNLRVMcvqP";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(MY_URL)));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //menu de navegacion principal
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int idItem = item.getItemId();
        switch (idItem) {
            case R.id.dinamica:
                Intent e = new Intent(this, MainActivityDinamica.class);
                startActivity(e);
                break;
            case R.id.cinematica:
                Intent f = new Intent(this, MainActivityCinematica.class);
                startActivity(f);
                break;
            case R.id.nav_practica:
                Intent g = new Intent(this, MainActivityPractica.class);
                startActivity(g);
                break;
            case R.id.nav_evaluacion:
                Intent h = new Intent(this, MainActivityEvaluacion.class);
                startActivity(h);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    //metodo para el mensaje de bienvenida e indicaciones
    public void SnackBarB() {
        Snackbar.make(getWindow().getDecorView().getRootView(),
                "Cálculos sobre cinemática de rotación.", Snackbar.LENGTH_LONG).show();
    }
}
