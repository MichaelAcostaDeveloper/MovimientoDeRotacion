package michael.acosta.movimientoderotacion.ProcesosMomentoFuerza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoRadio extends AppCompatActivity {
TextView torque, fuerza, resultado;
Double T,F,r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_radio);

        String temaActivity = getIntent().getStringExtra("titulo");
        setTitle(temaActivity);



        torque = (TextView) findViewById(R.id.torque);
        fuerza = (TextView) findViewById(R.id.fuerza);
        resultado = (TextView) findViewById(R.id.resultado);

        T = getIntent().getDoubleExtra("T", 0);
        F = getIntent().getDoubleExtra("F", 0);
        r = getIntent().getDoubleExtra("r", 0);

        //ubicacion de los valores en los textView
        torque.setText(String.format("%.3f", T));
        fuerza.setText(String.format("%.3f", F));
        resultado.setText(String.format("%.3f", r));

    }
}
