package michael.acosta.movimientoderotacion.ProcesosCinematica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoVelocidadAngularMediaFormat2 extends AppCompatActivity {
TextView vm1,vm2,vm3,vmResultado,valDesplaza,valTiempo,resultado,unidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_velocidad_angular_media_format2);
        //casteo de los editext y boton
        TextView vm1=(TextView) findViewById(R.id.vm1);
        TextView vm2=(TextView) findViewById(R.id.vm2);
        TextView vm3=(TextView) findViewById(R.id.vm3);
        TextView vmResultado=(TextView) findViewById(R.id.vm_resultado);
        TextView valDesplaza=(TextView) findViewById(R.id.valorDesplaza);
        TextView valTiempo=(TextView) findViewById(R.id.valorTiempo);
        TextView resultado=(TextView) findViewById(R.id.resultado);
        TextView unidad=(TextView) findViewById(R.id.unidad);

        vm1.setText(Html.fromHtml("ω<sub>m</sub>"));
        vm2.setText(Html.fromHtml("ω<sub>m</sub>"));
        vm3.setText(Html.fromHtml("ω<sub>m</sub>"));
        vmResultado.setText(Html.fromHtml("ω<sub>m</sub>"));
        unidad.setText("[rad/s]");

        //paso de valores del Resultados_Cinematica al ProcesoVelocidadAngularMediaFormat2
        Double vm=getIntent().getDoubleExtra("vm",0);
        Double d=getIntent().getDoubleExtra("d",0);
        Double t=getIntent().getDoubleExtra("t",0);
        //ubicacion de los valores en los textView
        valDesplaza.setText(String.format("%.3f",d));
        valTiempo.setText(String.format("%.3f",t));
        resultado.setText(String.format("%.3f", vm));
    }
}
