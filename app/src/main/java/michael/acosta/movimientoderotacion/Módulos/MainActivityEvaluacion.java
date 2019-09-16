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
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.tfb.fbtoast.FBToast;

import michael.acosta.movimientoderotacion.ItemListActivity;
import michael.acosta.movimientoderotacion.R;
import michael.acosta.movimientoderotacion.TareaProfeListActivity;

public class MainActivityEvaluacion extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        DrawerLayout drawerLayout;
        RadioButton radioEstudiante;
        RadioButton radioProfesor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow()
                .setStatusBarColor(ContextCompat.getColor(getBaseContext(), R.color.colorPrimary));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_evaluacion);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarEvaluacion);
        toolbar.setSubtitle("Módulo de evaluación");
        setSupportActionBar(toolbar);

        //codigo para el cajon de navegacion
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_evaluacion);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView =(NavigationView) findViewById(R.id.navegationViewEvaluacion);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }
        //seleccion del tipo de usuario
        //variables de los radioButtons
        radioEstudiante=(RadioButton)findViewById(R.id.radioEstudiante);
        radioProfesor=(RadioButton)findViewById(R.id.radioProfesor);
        //funcionamiento de cada radioButton
        radioEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accionLoginEstudiante();
            }
        });
        radioProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accionLoginProfesor();
            }
        });
    }

    private void accionLoginProfesor() {
        FBToast.successToast(MainActivityEvaluacion.this,"Se han seleccionado el status: profesor",FBToast.LENGTH_SHORT);
        Intent intent = new Intent(this, TareaProfeListActivity.class);
         intent.putExtra("s","Profesor");
        startActivity(intent);
    }
    private void accionLoginEstudiante() {
        FBToast.successToast(MainActivityEvaluacion.this,"Se han seleccionado el status: estudiante",FBToast.LENGTH_SHORT);
        Intent intent = new Intent(this, ItemListActivity.class);
        intent.putExtra("s","Estudiante");
        startActivity(intent);
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
                Toast.makeText(MainActivityEvaluacion.this,"Manual de usuario",Toast.LENGTH_SHORT).show();
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
}