package michael.acosta.movimientoderotacion.ProcesosMomentoFuerza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoMasa extends AppCompatActivity {
TextView inercia,radio,resultado;
Double I,m,r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_masa);

        String temaActivity = getIntent().getStringExtra("titulo");
        setTitle(temaActivity);



        radio = (TextView) findViewById(R.id.radio);
        inercia = (TextView) findViewById(R.id.inercia);
        resultado = (TextView) findViewById(R.id.resultado);

        I = getIntent().getDoubleExtra("I", 0);
        r = getIntent().getDoubleExtra("r", 0);
        m = getIntent().getDoubleExtra("m", 0);

        //ubicacion de los valores en los textView
        inercia.setText(String.format("%.3f", I));
        radio.setText(String.format("%.3f", r));
        resultado.setText(String.format("%.3f", m));
    }
}
