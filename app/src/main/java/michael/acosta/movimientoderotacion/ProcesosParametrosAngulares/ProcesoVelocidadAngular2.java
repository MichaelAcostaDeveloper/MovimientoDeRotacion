package michael.acosta.movimientoderotacion.ProcesosParametrosAngulares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoVelocidadAngular2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_velocidad_angular2);

        TextView resultado=(TextView)findViewById(R.id.resultado);
        TextView frecuencia=(TextView)findViewById(R.id.frecuencia);

        Double f=getIntent().getDoubleExtra("f",0);
        Double w=getIntent().getDoubleExtra("w",0);
        //ubicacion de los valores en los textView
        resultado.setText(String.format("%.3f",w));
        frecuencia.setText(String.format("%.3f",f));
    }
}
