package michael.acosta.movimientoderotacion.ProcesosParametrosAngulares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoFrecuencia1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_frecuencia1);

        TextView resultado=(TextView)findViewById(R.id.resultado);
        TextView periodo=(TextView)findViewById(R.id.periodo);

        Double f=getIntent().getDoubleExtra("f",0);
        Double T=getIntent().getDoubleExtra("T",0);
        //ubicacion de los valores en los textView
        resultado.setText(String.format("%.3f",f));
        periodo.setText(String.format("%.3f",T));


    }
}
