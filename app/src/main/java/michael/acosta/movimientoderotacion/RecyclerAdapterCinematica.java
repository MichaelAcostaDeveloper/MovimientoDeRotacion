package michael.acosta.movimientoderotacion;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tfb.fbtoast.FBToast;

import michael.acosta.movimientoderotacion.ContextosCinematicos.CinematicaMovimiento;
import michael.acosta.movimientoderotacion.ContextosCinematicos.ParametrosAngulares;
public class RecyclerAdapterCinematica extends RecyclerView.Adapter<RecyclerViewHolderCinematica> {
    //variables
    String[] tituloArreglo;
    Context context;
    LayoutInflater inflater;
    LayoutInflater inf;
    Drawable icono;
    String texto;
    Intent e;
    int posicion;
    public RecyclerAdapterCinematica(Context context) {
        this.context = context;
        tituloArreglo = new String[]{
                context.getResources().getString(R.string.particula),
                context.getResources().getString(R.string.parametros_angulares)};
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public RecyclerViewHolderCinematica onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.card_view_cinematica, parent, false);
        RecyclerViewHolderCinematica view = new RecyclerViewHolderCinematica(v);
        return view;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolderCinematica holder, int position) {
        switch (position) {
            case 0:
                holder.t1.setText(context.getResources().getString(R.string.particula));
                holder.imagen.setOnClickListener(clickInfo);
                holder.imagen.setImageResource(R.drawable.movcinematica);
                holder.t1.setTag(holder);
                holder.t1.setOnClickListener(clickActiviy);
                holder.imagen.setTag(holder);
                break;
            case 1:
                holder.t1.setText(context.getResources().getString(R.string.parametros_angulares));
                holder.imagen.setOnClickListener(clickInfo);
                holder.imagen.setImageResource(R.drawable.frecuencia_periodo);
                holder.t1.setTag(holder);
                holder.t1.setOnClickListener(clickActiviy);
                holder.imagen.setTag(holder);
                break;
        }
    }
    @Override
    public int getItemCount() {
        return tituloArreglo.length;
    }

    View.OnClickListener clickInfo;
    {
    clickInfo=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String MY_URL = "https://es.wikipedia.org/wiki/Movimiento_de_rotaci%C3%B3n";
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(MY_URL)));
        }
    };
    }
    View.OnClickListener clickActiviy;
    {
        clickActiviy = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RecyclerViewHolderCinematica vh = (RecyclerViewHolderCinematica) v.getTag();
                posicion = vh.getAdapterPosition();
                switch (posicion) {

                    case 0:
                        texto = "Partículas";
                        icono = ContextCompat.getDrawable(context, R.drawable.particulas);
                        e = new Intent(context, CinematicaMovimiento.class);
                        DialogoPersonalizadoCinematica();
                        break;
                    case 1:
                        texto = "Frecuencia y periodo";
                        icono = ContextCompat.getDrawable(context, R.drawable.particulas);
                        e = new Intent(context, ParametrosAngulares.class);
                        DialogoPersonalizadoFrecuenciaPeriodo();
                        break;
                }
            }

            public void AnalisisObjeto(Intent e, Integer n) {
                String image = "im";
                e.putExtra("id", texto);
                e.putExtra(image, n + 1);
                context.startActivity(e);
            }

            public Dialog dialogo_alerta_IngresoDatos() {
                final AlertDialog builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Dialog_Alert).create();
                builder.setCanceledOnTouchOutside(false);
                builder.setCancelable(false);
                builder.setIcon(icono);
                builder.setTitle("Información");
                builder.setMessage("Seleccione 3 valores numéricos.");
                builder.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        builder.cancel();
                    }
                });
                return builder;
            }

            public Dialog dialogo_alerta_IngresoDatos2() {
                final AlertDialog builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Dialog_Alert).create();
                builder.setCanceledOnTouchOutside(false);
                builder.setCancelable(false);
                builder.setIcon(icono);
                builder.setTitle("Información");
                builder.setMessage("Seleccione el valor numérico conocido.");

                builder.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        builder.cancel();
                    }
                });
                return builder;
            }

            public void DialogoPersonalizadoCinematica() {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                inf = LayoutInflater.from(context);
                View vista = inf.inflate(R.layout.dialogo_variables_cinematicas, null);
                builder.setCancelable(false);
                builder.setView(vista);

                final AlertDialog dialog = builder.create();
                dialog.show();
                //id de los text de simbolo
                TextView ts1 = (TextView) vista.findViewById(R.id.ts1);
                ts1.setText(Html.fromHtml("ω<sub>o</sub>"));
                TextView ts2 = (TextView) vista.findViewById(R.id.ts2);
                ts2.setText(Html.fromHtml("ω<sub>f</sub>"));
                TextView ts3 = (TextView) vista.findViewById(R.id.ts3);
                ts3.setText(Html.fromHtml("Δθ"));
                TextView ts4 = (TextView) vista.findViewById(R.id.ts4);
                ts4.setText(Html.fromHtml("Δt"));
                TextView ts5 = (TextView) vista.findViewById(R.id.ts5);
                ts5.setText(Html.fromHtml("α"));
                //id de los checkboxes
                final CheckBox c1 = (CheckBox) vista.findViewById(R.id.check1);
                final CheckBox c2 = (CheckBox) vista.findViewById(R.id.check2);
                final CheckBox c3 = (CheckBox) vista.findViewById(R.id.check3);
                final CheckBox c4 = (CheckBox) vista.findViewById(R.id.check4);
                final CheckBox c5 = (CheckBox) vista.findViewById(R.id.check5);
                //id de otros elementos
                Button btnOK = (Button) vista.findViewById(R.id.botonOK);
                Button btnCANCELAR = (Button) vista.findViewById(R.id.botonCancelar);
                ImageView imagen = (ImageView) vista.findViewById(R.id.grafico);
                TextView titulo = (TextView) vista.findViewById(R.id.titulo);
                //id de elementos graficos del dialogo
                imagen.setImageDrawable(icono);
                titulo.setText(texto);
                //codigo de funcionamiento del boton OK
                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (c1.isChecked() & c2.isChecked() & c3.isChecked() & c4.isChecked() & c5.isChecked()) {
                            dialogo_alerta_IngresoDatos().show();
                        } else if (c1.isChecked() & c2.isChecked() & c3.isChecked() & c4.isChecked()) {
                            dialogo_alerta_IngresoDatos().show();
                        } else if (c1.isChecked() & c2.isChecked() & c3.isChecked() & c5.isChecked()) {
                            dialogo_alerta_IngresoDatos().show();
                        } else if (c1.isChecked() & c2.isChecked() & c4.isChecked() & c5.isChecked()) {
                            dialogo_alerta_IngresoDatos().show();
                        } else if (c1.isChecked() & c3.isChecked() & c4.isChecked() & c5.isChecked()) {
                            dialogo_alerta_IngresoDatos().show();
                        } else if (c3.isChecked() & c2.isChecked() & c5.isChecked() & c4.isChecked()) {
                            dialogo_alerta_IngresoDatos().show();
                        } else if (c1.isChecked() & c2.isChecked() & c3.isChecked()) {
                            ///codigo
                            FBToast.infoToast(context, "Se han seleccionado las variables:\n velocidad angular incial y final" +
                                    "\n desplazamiento angular", FBToast.LENGTH_LONG);
                            e.putExtra("p", 4);
                            AnalisisObjeto(e, posicion);
                            dialog.dismiss();
                        } else if (c1.isChecked() & c2.isChecked() & c4.isChecked()) {
                            ///codigo
                            FBToast.infoToast(context, "Se han seleccionado las variables:\nVelocidad angular inicial y final" +
                                    "\nTiempo transcurrido", FBToast.LENGTH_LONG);
                            e.putExtra("p", 5);
                            AnalisisObjeto(e, posicion);
                            dialog.dismiss();
                        } else if (c1.isChecked() & c2.isChecked() & c5.isChecked()) {
                            ///codigo
                            FBToast.infoToast(context, "Se han seleccionado las variables:\nVelocidad angular inicial y final" +
                                    "\nAceleración angular", FBToast.LENGTH_LONG);
                            e.putExtra("p", 6);
                            AnalisisObjeto(e, posicion);
                            dialog.dismiss();
                        } else if (c1.isChecked() & c3.isChecked() & c4.isChecked()) {
                            ///codigo
                            FBToast.infoToast(context, "Se han seleccionado las variables:\nVelocidad inicial \nDesplazamiento angular" +
                                    "\nTiempo transcurrido", FBToast.LENGTH_LONG);
                            e.putExtra("p", 7);
                            AnalisisObjeto(e, posicion);
                            dialog.dismiss();
                        } else if (c1.isChecked() & c3.isChecked() & c5.isChecked()) {
                            ///codigo
                            FBToast.infoToast(context, "Se han seleccionado las variables:\nVelocidad inicial \nDesplazamiento angular" +
                                    "\nAceleración angular", FBToast.LENGTH_LONG);
                            e.putExtra("p", 8);
                            AnalisisObjeto(e, posicion);
                            dialog.dismiss();
                        } else if (c1.isChecked() & c4.isChecked() & c5.isChecked()) {
                            ///codigo
                            FBToast.infoToast(context, "Se han seleccionado las variables:\nVelocidad inicial \nTiempo transcurrido" +
                                    "\nAceleración angular", FBToast.LENGTH_SHORT);
                            e.putExtra("p", 9);
                            AnalisisObjeto(e, posicion);
                            dialog.dismiss();
                        } else if (c2.isChecked() & c3.isChecked() & c4.isChecked()) {
                            ///codigo
                            FBToast.infoToast(context, "Se han seleccionado las variables:\nVelocidad final \nDesplazamiento angular" +
                                    "\nTiempo trascurrido", FBToast.LENGTH_LONG);
                            e.putExtra("p", 10);
                            AnalisisObjeto(e, posicion);
                            dialog.dismiss();
                        } else if (c2.isChecked() & c3.isChecked() & c5.isChecked()) {
                            ///codigo
                            FBToast.infoToast(context, "Se han seleccionado las variables:\nVelocidad final \nDesplazamiento angular" +
                                    "\nAceleración angular", Toast.LENGTH_LONG);
                            e.putExtra("p", 11);
                            AnalisisObjeto(e, posicion);
                            dialog.dismiss();
                        } else if (c2.isChecked() & c4.isChecked() & c5.isChecked()) {
                            ///codigo
                            FBToast.infoToast(context, "Se han seleccionado las variables:\nVelocidad final \nTiempo transcurrido" +
                                    "\nAceleración angular", FBToast.LENGTH_LONG);
                            e.putExtra("p", 12);
                            AnalisisObjeto(e, posicion);
                            dialog.dismiss();
                        } else if (c3.isChecked() & c4.isChecked() & c5.isChecked()) {
                            ///codigo
                            ///codigo
                            FBToast.infoToast(context, "Se han seleccionado las variables:\nAceleración angular \nDesplazamiento angular" +
                                    "\nTiempo trascurrido", FBToast.LENGTH_LONG);
                            e.putExtra("p", 13);
                            AnalisisObjeto(e, posicion);
                            dialog.dismiss();
                        } else if (c1.isChecked() & c2.isChecked()) {
                            /////codigo
                            e.putExtra("p", 1);
                            AnalisisObjeto(e, posicion);
                            dialog.dismiss();
                            FBToast.infoToast(context, "Se han seleccionado las variables: \nVelocidad inicial\nVelocidad final", FBToast.LENGTH_SHORT);


                        } else if (c3.isChecked() & c4.isChecked()) {
                            ///codigo

                            FBToast.infoToast(context, "Se han seleccionado las variables:\nDesplazamiento\nTiempo.", FBToast.LENGTH_SHORT);
                            e.putExtra("p", 2);
                            AnalisisObjeto(e, posicion);
                            dialog.dismiss();
                        } else if (c4.isChecked() & c5.isChecked()) {
                            ///codigo
                            FBToast.infoToast(context, "Se han seleccionado las variables:\nTiempo\nAceleración.", FBToast.LENGTH_SHORT);

                            e.putExtra("p", 3);
                            AnalisisObjeto(e, posicion);
                            dialog.dismiss();
                        } else {
                            dialogo_alerta_IngresoDatos().show();
                        }

                    }
                });
                btnCANCELAR.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }

            public void DialogoPersonalizadoFrecuenciaPeriodo() {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                inf = LayoutInflater.from(context);
                View vista = inf.inflate(R.layout.dialogo_parametros_angulares, null);
                builder.setCancelable(false);
                builder.setView(vista);

                final AlertDialog dialog = builder.create();
                dialog.show();
                //id de los text de simbolo
                TextView ts1 = (TextView) vista.findViewById(R.id.ts1);
                ts1.setText(Html.fromHtml("T"));
                TextView ts2 = (TextView) vista.findViewById(R.id.ts2);
                ts2.setText(Html.fromHtml("f"));
                TextView ts3 = (TextView) vista.findViewById(R.id.ts3);
                ts3.setText(Html.fromHtml("ω"));
                TextView ts4 = (TextView) vista.findViewById(R.id.ts4);
                //id de los checkboxes
                final CheckBox c1 = (CheckBox) vista.findViewById(R.id.check1);
                final CheckBox c2 = (CheckBox) vista.findViewById(R.id.check2);
                final CheckBox c3 = (CheckBox) vista.findViewById(R.id.check3);
                //id de otros elementos
                Button btnOK = (Button) vista.findViewById(R.id.botonOK);
                Button btnCANCELAR = (Button) vista.findViewById(R.id.botonCancelar);
                ImageView imagen = (ImageView) vista.findViewById(R.id.grafico);
                TextView titulo = (TextView) vista.findViewById(R.id.titulo);
                //id de elementos graficos del dialogo
                imagen.setImageDrawable(icono);
                titulo.setText(texto);
                //codigo de funcionamiento del boton OK
                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (c1.isChecked() & c2.isChecked() & c3.isChecked()) {
                            dialogo_alerta_IngresoDatos2().show();
                        } else if (c1.isChecked() & c2.isChecked()) {
                            dialogo_alerta_IngresoDatos2().show();
                        } else if (c1.isChecked() & c3.isChecked()) {
                            dialogo_alerta_IngresoDatos2().show();
                        } else if (c2.isChecked() & c3.isChecked()) {
                            dialogo_alerta_IngresoDatos2().show();

                        } else if (c1.isChecked()) {
                            ///codigo
                            FBToast.infoToast(context, "Se ha seleccionado la variable:\n Periodo.", FBToast.LENGTH_SHORT);
                            e.putExtra("p", 1);
                            AnalisisObjeto(e, posicion);
                            dialog.dismiss();
                        } else if (c2.isChecked()) {
                            ///codigo
                            FBToast.infoToast(context, "Se ha seleccionado la variable:\n Frecuencia.", FBToast.LENGTH_SHORT);
                            e.putExtra("p", 2);
                            AnalisisObjeto(e, posicion);
                            dialog.dismiss();
                        } else if (c3.isChecked()) {
                            ///codigo
                            FBToast.infoToast(context, "Se ha seleccionado la variable:\n Velocidad angular.", FBToast.LENGTH_SHORT);
                            e.putExtra("p", 3);
                            AnalisisObjeto(e, posicion);
                            dialog.dismiss();
                        } else {
                            dialogo_alerta_IngresoDatos2().show();
                        }
                    }
                });
                btnCANCELAR.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        };
    }
}

