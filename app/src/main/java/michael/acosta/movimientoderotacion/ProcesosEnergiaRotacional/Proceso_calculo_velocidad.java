package michael.acosta.movimientoderotacion.ProcesosEnergiaRotacional;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class Proceso_calculo_velocidad extends AppCompatActivity {
    Double Inercia,velocidad,Energia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_calculo_velocidad);

        TextView a=(TextView)findViewById(R.id.expA);
        TextView b=(TextView)findViewById(R.id.expB);
        TextView c=(TextView)findViewById(R.id.expC);
        TextView d =(TextView)findViewById(R.id.expD);
        a.setText(Html.fromHtml("<sup>0.5</sup>"));
        b.setText(Html.fromHtml("<sup>0.5</sup>"));
        c.setText(Html.fromHtml("<sup>0.5</sup>"));
        d.setText(Html.fromHtml("<sup>0.5</sup>"));

        TextView Eformula=(TextView)findViewById(R.id.energia_formula);
        TextView Evalor=(TextView)findViewById(R.id.energia_valor);
        TextView Ivalor=(TextView)findViewById(R.id.inercia_valor);
        TextView resultado=(TextView)findViewById(R.id.resultado);



        Intent recibir=getIntent();
        int caso= recibir.getIntExtra("c",0);
        switch (caso){
            case 1:
                //caso 1
                Eformula.setText(Html.fromHtml("2(E<sub>o</sub>)"));
                Inercia=getIntent().getDoubleExtra("I",0);
                velocidad=getIntent().getDoubleExtra("wo",0);
                Energia=getIntent().getDoubleExtra("Eo",0);
                break;
            case 2:
                //caso 2
                Eformula.setText(Html.fromHtml("2(E<sub>f</sub>)"));
                Inercia=getIntent().getDoubleExtra("I",0);
                velocidad=getIntent().getDoubleExtra("wf",0);
                Energia=getIntent().getDoubleExtra("Ef",0);
                break;
        }

        //ubicacion de los valores en los textView
        Ivalor.setText(String.format("%.3f",Math.pow(Inercia,0.5)));
        resultado.setText(String.format("%.3f",velocidad));
        Evalor.setText(String.format("%.3f",Math.pow((2*Energia),0.5)));
    }
}
