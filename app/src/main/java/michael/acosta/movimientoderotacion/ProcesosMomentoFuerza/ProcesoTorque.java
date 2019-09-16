package michael.acosta.movimientoderotacion.ProcesosMomentoFuerza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoTorque extends AppCompatActivity {
TextView magnitud1,magnitud2,magnitud1Formula,magnitud2Formula,magnitud1Valor,magnitud2Valor,resultado;
Double T,F,r,I,a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_torque);

        String temaActivity = getIntent().getStringExtra("titulo");
        setTitle(temaActivity);


        magnitud1=(TextView)findViewById(R.id.magnitud1);
        magnitud1Formula=(TextView)findViewById(R.id.magnitud1Formula);
        magnitud1Valor=(TextView)findViewById(R.id.magnitud1Valor);
        magnitud2=(TextView)findViewById(R.id.magnitud2);
        magnitud2Formula=(TextView)findViewById(R.id.magnitud2Formula);
        magnitud2Valor=(TextView)findViewById(R.id.magnitud2Valor);
        resultado=(TextView)findViewById(R.id.resultado);
        Intent recibir=getIntent();

        int c= recibir.getIntExtra("c",0);
        switch (c){
            case 1:
                //caso 1
                magnitud1.setText(Html.fromHtml("Fuerza"));
                magnitud1Formula.setText("F");
                F = getIntent().getDoubleExtra("F", 0);
                magnitud1Valor.setText(String.format("%.3f", F));
                magnitud2.setText(Html.fromHtml("Radio"));
                magnitud2Formula.setText("r");
                r = getIntent().getDoubleExtra("r", 0);
                magnitud2Valor.setText(String.format("%.3f", r));
                T=getIntent().getDoubleExtra("T",0);
                break;
            case 2:
                //caso 2
                magnitud1.setText(Html.fromHtml("Inercia"));
                magnitud1Formula.setText("I");
                I = getIntent().getDoubleExtra("I", 0);
                magnitud1Valor.setText(String.format("%.3f", I));
                magnitud2.setText(Html.fromHtml("Aceleracion"));
                magnitud2Formula.setText("a");
                a = getIntent().getDoubleExtra("a", 0);
                magnitud2Valor.setText(String.format("%.3f", a));
                T=getIntent().getDoubleExtra("T",0);
                break;
        }
        resultado.setText(String.format("%.3f", T));
    }
}
