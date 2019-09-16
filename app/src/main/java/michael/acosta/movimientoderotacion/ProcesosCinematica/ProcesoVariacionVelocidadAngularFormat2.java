package michael.acosta.movimientoderotacion.ProcesosCinematica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoVariacionVelocidadAngularFormat2 extends AppCompatActivity {
TextView a_valor,t_valor,resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_variacion_velocidad_angular_format2);
        a_valor=(TextView)findViewById(R.id.a_valor);
        t_valor=(TextView)findViewById(R.id.t_valor);
        resultado=(TextView)findViewById(R.id.resultado);


        Double dv=getIntent().getDoubleExtra("dv",0);
        Double a=getIntent().getDoubleExtra("a",0);
        Double t=getIntent().getDoubleExtra("t",0);
        //ubicacion de los valores en los textView
        a_valor.setText(String.format("%.3f",a));
        t_valor.setText("("+String.format("%.3f",t)+")");
        resultado.setText(String.format("%.3f", dv));

    }
}
