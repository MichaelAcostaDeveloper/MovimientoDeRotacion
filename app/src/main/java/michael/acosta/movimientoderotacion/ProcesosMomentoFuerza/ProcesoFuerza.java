package michael.acosta.movimientoderotacion.ProcesosMomentoFuerza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoFuerza extends AppCompatActivity {
    TextView torque, radio, resultado;
    Double F, T, r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_fuerza);
        String temaActivity = getIntent().getStringExtra("titulo");
        setTitle(temaActivity);



        torque = (TextView) findViewById(R.id.torque);
        radio = (TextView) findViewById(R.id.radio);
        resultado = (TextView) findViewById(R.id.resultado);

        F = getIntent().getDoubleExtra("F", 0);
        T = getIntent().getDoubleExtra("T", 0);
        r = getIntent().getDoubleExtra("r", 0);

        //ubicacion de los valores en los textView
        torque.setText(String.format("%.3f", T));
        radio.setText(String.format("%.3f", r));
        resultado.setText(String.format("%.3f", F));

    }
}
