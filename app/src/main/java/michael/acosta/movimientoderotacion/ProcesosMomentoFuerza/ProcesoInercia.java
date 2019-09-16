package michael.acosta.movimientoderotacion.ProcesosMomentoFuerza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoInercia extends AppCompatActivity {
TextView resultado,torque,aceleracion;
Double T,a,I;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_inercia);

        String temaActivity = getIntent().getStringExtra("titulo");
        setTitle(temaActivity);



        torque = (TextView) findViewById(R.id.torque);
        aceleracion = (TextView) findViewById(R.id.aceleracion);
        resultado = (TextView) findViewById(R.id.resultado);

        I = getIntent().getDoubleExtra("I", 0);
        T = getIntent().getDoubleExtra("T", 0);
        a = getIntent().getDoubleExtra("a", 0);

        //ubicacion de los valores en los textView
        torque.setText(String.format("%.3f", T));
        aceleracion.setText(String.format("%.3f", a));
        resultado.setText(String.format("%.3f", I));

    }
}
