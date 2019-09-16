package michael.acosta.movimientoderotacion.ProcesosInerciaRotacional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class Proceso_calculo_inercia_caso_especial extends AppCompatActivity {
    Double Inercia,masa,m1,m2;

    TextView denominadorFormula,denominadorValor,m1Formula,m2Formula,resultado,masaValor,m1Valor,m2Valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_calculo_inercia_caso_especial);

        m1Formula=(TextView)findViewById(R.id.m1Formula);
        m2Formula=(TextView)findViewById(R.id.m2Formula);
        m1Valor=(TextView)findViewById(R.id.m1Valor);
        m2Valor=(TextView)findViewById(R.id.m2Valor);
        denominadorFormula=(TextView)findViewById(R.id.denominadorFormula);
        denominadorValor=(TextView)findViewById(R.id.denominadorValor);

        resultado=(TextView)findViewById(R.id.resultado);
        masaValor=(TextView)findViewById(R.id.masa);


        int c= getIntent().getIntExtra("c",0);
        switch (c){
            case 1:
                m1Formula.setText(Html.fromHtml("R<sub>1</sub>"));
                m2Formula.setText(Html.fromHtml("R<sub>2</sub>"));
                masa=getIntent().getDoubleExtra("m",0);
                m1=getIntent().getDoubleExtra("r1",0);
                m2=getIntent().getDoubleExtra("r2",0);
                Inercia=getIntent().getDoubleExtra("I",0);
                denominadorValor.setText("2");
                denominadorFormula.setText("2");
                m1Valor.setText(String.format("%.3f",m1));
                m2Valor.setText(String.format("%.3f",m2));
                break;
            case 2:
                m1Formula.setText("a");
                m2Formula.setText("b");
                masa=getIntent().getDoubleExtra("m",0);
                m1=getIntent().getDoubleExtra("a",0);
                m2=getIntent().getDoubleExtra("b",0);
                Inercia=getIntent().getDoubleExtra("I",0);
                denominadorValor.setText("12");
                denominadorFormula.setText("12");
                m1Valor.setText(String.format("%.3f",m1));
                m2Valor.setText(String.format("%.3f",m2));
                break;
                 }


        masaValor.setText(String.format("%.3f",masa));
        resultado.setText(String.format("%.3f",Inercia));

    }
}
