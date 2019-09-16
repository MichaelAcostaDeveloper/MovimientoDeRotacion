package michael.acosta.movimientoderotacion.ProcesosMomentoFuerza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoAceleracion extends AppCompatActivity {
    TextView torque, inercia, resultado;
    Double I, T, a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme);
        setContentView(R.layout.activity_proceso_aceleracion);
        super.onCreate(savedInstanceState);

        String temaActivity = getIntent().getStringExtra("titulo");
        setTitle(temaActivity);



        torque = (TextView) findViewById(R.id.torque);
        inercia = (TextView) findViewById(R.id.inercia);
        resultado = (TextView) findViewById(R.id.resultado);

        I = getIntent().getDoubleExtra("I", 0);
        T = getIntent().getDoubleExtra("T", 0);
        a = getIntent().getDoubleExtra("a", 0);

        //ubicacion de los valores en los textView
        torque.setText(String.format("%.3f", T));
        inercia.setText(String.format("%.3f", I));
        resultado.setText(String.format("%.3f", a));
    }
}
