package michael.acosta.movimientoderotacion.ProcesosParametrosAngulares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoFrecuencia2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_frecuencia2);

        TextView resultado=(TextView)findViewById(R.id.resultado);
        TextView velocidad=(TextView)findViewById(R.id.velocidad);

        Double f=getIntent().getDoubleExtra("f",0);
        Double w=getIntent().getDoubleExtra("w",0);
        //ubicacion de los valores en los textView
        resultado.setText(String.format("%.3f",f));
        velocidad.setText(String.format("%.3f",w));
    }
}
