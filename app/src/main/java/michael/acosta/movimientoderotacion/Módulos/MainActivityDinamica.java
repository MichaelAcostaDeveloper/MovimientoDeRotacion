package michael.acosta.movimientoderotacion.Módulos;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
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
import michael.acosta.movimientoderotacion.RecyclerAdapterDinamica;
import michael.acosta.movimientoderotacion.dialogoModuloDinamica;

public class MainActivityDinamica extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(), R.color.colorPrimary));
        dialogo();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_d);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarD);
        toolbar.setSubtitle("Dinámica de rotación");
        setSupportActionBar(toolbar);
        //codigo para el cajon de navegacion
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_dinamica);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navegationViewD);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }
        //codigo para el recyclerview
        RecyclerAdapterDinamica adapter = new RecyclerAdapterDinamica(this);
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewContenidosDinamica);
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
               Toast.makeText(MainActivityDinamica.this,
                        "Manual de usuario", Toast.LENGTH_SHORT).show();
               String MY_URL = "https://drive.google.com/open?id=1d-GsdZnKKWs-sCgVB2jljUaNLRVMcvqP";
               startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(MY_URL)));
               return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int idItem = item.getItemId();
        switch (idItem) {
            case R.id.cinematica:
                Intent e = new Intent(this, MainActivityCinematica.class);
                startActivity(e);
                break;

            case R.id.dinamica:
                Intent f = new Intent(this, MainActivityDinamica.class);
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

    public void dialogo() {
        dialogoModuloDinamica db = new dialogoModuloDinamica();
        db.show(getFragmentManager(), "MainActivityDinamica");
    }
}

