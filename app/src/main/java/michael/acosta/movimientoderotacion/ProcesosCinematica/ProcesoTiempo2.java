package michael.acosta.movimientoderotacion.ProcesosCinematica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoTiempo2 extends AppCompatActivity {
TextView dv_valor,a_valor,resultado,unidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_tiempo2);

        dv_valor=(TextView)findViewById(R.id.dv_valor);
        a_valor=(TextView)findViewById(R.id.a_valor);
        resultado=(TextView)findViewById(R.id.resultado);
        unidad=(TextView)findViewById(R.id.unidad);


        unidad.setText("[s]");

        Double dv=getIntent().getDoubleExtra("dv",0);
        Double a=getIntent().getDoubleExtra("a",0);
        Double t=getIntent().getDoubleExtra("t",0);
        //ubicacion de los valores en los textView
        dv_valor.setText(String.format("%.3f",dv));
        a_valor.setText(String.format("%.3f",a));
        resultado.setText(String.format("%.3f", t));
    }
}
