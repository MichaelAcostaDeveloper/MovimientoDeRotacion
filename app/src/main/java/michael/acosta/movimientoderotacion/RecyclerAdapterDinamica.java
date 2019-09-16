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
import android.widget.RadioButton;
import android.widget.TextView;

import com.tfb.fbtoast.FBToast;

import michael.acosta.movimientoderotacion.ContextosDinamicos.EnergiaRotacional;
import michael.acosta.movimientoderotacion.ContextosDinamicos.InerciaRotacional;
import michael.acosta.movimientoderotacion.ContextosDinamicos.MomentoAngular;
import michael.acosta.movimientoderotacion.ContextosDinamicos.MomentoFuerza;
public class RecyclerAdapterDinamica extends RecyclerView.Adapter<RecyclerViewHolderDinamica> {
    //variables
    String[] tituloArreglo;
    Context context;
    LayoutInflater inflater;
    LayoutInflater inf;
    Drawable icono, modelo;
    String texto;
    Intent f, a, e, iner;
    int posicion;

    public RecyclerAdapterDinamica(Context context) {
        this.context = context;
        tituloArreglo = new String[]{
                context.getResources().getString(R.string.varilla_ejeExtremo),
                context.getResources().getString(R.string.anillo),
                context.getResources().getString(R.string.cilindro_solido),
                context.getResources().getString(R.string.cilindro_anular),
                context.getResources().getString(R.string.esfera_solida),
                context.getResources().getString(R.string.esfera_hueca),
                context.getResources().getString(R.string.placa_rectangular),
                context.getResources().getString(R.string.varilla_ejeCentral),
                context.getResources().getString(R.string.particula)
        };
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public RecyclerViewHolderDinamica onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.card_view_dinamica, parent, false);
        RecyclerViewHolderDinamica view = new RecyclerViewHolderDinamica(v);
        return view;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolderDinamica holder, int position) {
        switch (position) {
            case 0:
                holder.t1D.setText(context.getResources().getString(R.string.anillo));
                holder.t1D.setOnClickListener(click);
                // holder.t2.setText(descripcionArreglo[position]);
                holder.imagenD.setOnClickListener(clickInfoWiki);
                holder.imagenD.setImageResource(R.drawable.anillocilindricoinercia);
                holder.imagenD.setTag(holder);
                holder.t1D.setTag(holder);
                break;
            case 1:
                holder.t1D.setText(context.getResources().getString(R.string.cilindro_solido));
                holder.t1D.setOnClickListener(click);
                //holder.t2.setText(descripcionArreglo[position]);
                holder.imagenD.setOnClickListener(clickInfoWiki);
                holder.imagenD.setImageResource(R.drawable.cilindrosolidoinercia);
                holder.t1D.setTag(holder);
                holder.imagenD.setTag(holder);
                break;
            case 2:
                holder.t1D.setText(context.getResources().getString(R.string.cilindro_anular));
                holder.t1D.setOnClickListener(click);
                // holder.t2.setText(descripcionArreglo[position]);
                holder.imagenD.setOnClickListener(clickInfoWiki);
                holder.imagenD.setImageResource(R.drawable.cilindroanular);
                holder.imagenD.setTag(holder);
                holder.t1D.setTag(holder);
                break;
            case 3:
                holder.t1D.setText(context.getResources().getString(R.string.esfera_solida));
                holder.t1D.setOnClickListener(click);
                //holder.t2.setText(descripcionArreglo[position]);
                holder.imagenD.setOnClickListener(clickInfoWiki);
                holder.imagenD.setImageResource(R.drawable.esferainercia);
                holder.imagenD.setTag(holder);
                holder.t1D.setTag(holder);
                break;
            case 4:
                holder.t1D.setText(context.getResources().getString(R.string.esfera_hueca));
                holder.t1D.setOnClickListener(click);
                //holder.t2.setText(descripcionArreglo[position]);
                holder.imagenD.setOnClickListener(clickInfoWiki);
                holder.imagenD.setImageResource(R.drawable.cascoesferico);
                holder.t1D.setTag(holder);
                holder.imagenD.setTag(holder);
                break;
            case 5:
                holder.t1D.setText(context.getResources().getString(R.string.placa_rectangular));
                holder.t1D.setOnClickListener(click);
                //holder.t2.setText(descripcionArreglo[position]);
                holder.imagenD.setOnClickListener(clickInfoWiki);
                holder.imagenD.setImageResource(R.drawable.placa);
                holder.imagenD.setTag(holder);
                holder.t1D.setTag(holder);

                break;
            case 6:
                holder.t1D.setText(context.getResources().getString(R.string.varilla_ejeCentral));
                holder.t1D.setOnClickListener(click);
                //holder.t2.setText(descripcionArreglo[position]);
                holder.imagenD.setOnClickListener(clickInfoWiki);
                holder.imagenD.setImageResource(R.drawable.varillacentroinercia);
                holder.imagenD.setTag(holder);
                holder.t1D.setTag(holder);
                break;
            case 7:
                holder.t1D.setText(context.getResources().getString(R.string.varilla_ejeExtremo));
                holder.t1D.setOnClickListener(click);
                //holder.t2.setText(descripcionArreglo[position]);
                holder.imagenD.setOnClickListener(clickInfoWiki);
                holder.imagenD.setImageResource(R.drawable.varillaejeextremoinercia);
                holder.imagenD.setTag(holder);
                holder.t1D.setTag(holder);
                break;
            case 8:
                holder.t1D.setText(context.getResources().getString(R.string.particula));
                //holder.t2.setText(descripcionArreglo[position]);
                holder.t1D.setOnClickListener(click);
                holder.imagenD.setOnClickListener(clickInfoWiki);
                holder.imagenD.setImageResource(R.drawable.particula);
                holder.t1D.setTag(holder);
                holder.imagenD.setTag(holder);
                break;
        }
    }
    @Override
    public int getItemCount() {
        return tituloArreglo.length;
    }
    View.OnClickListener clickInfoWiki=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String MY_URL = "https://es.wikipedia.org/wiki/Momento_de_inercia";
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(MY_URL)));

        }
    };
    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            RecyclerViewHolderDinamica vh = (RecyclerViewHolderDinamica) v.getTag();
            posicion = vh.getAdapterPosition();
            switch (posicion) {
                case 0:
                    texto = "Anillo cilíndrico";
                    modelo = ContextCompat.getDrawable(context, R.drawable.anillocilindricoinercia);
                    icono = ContextCompat.getDrawable(context, R.drawable.anillo);
                    DialogoPersonalizado();
                    break;

                case 1:
                    texto = "Cilindro Sólido";
                    modelo = ContextCompat.getDrawable(context, R.drawable.cilindrosolidoinercia);
                    icono = ContextCompat.getDrawable(context, R.drawable.cilindro);
                    DialogoPersonalizado();
                    break;

                case 2:
                    texto = "Cilindro Anular";
                    modelo = ContextCompat.getDrawable(context, R.drawable.cilindroanular);
                    icono = ContextCompat.getDrawable(context, R.drawable.cilindroh);
                    DialogoPersonalizado();
                    break;

                case 3:
                    texto = "Esfera sólida";
                    modelo = ContextCompat.getDrawable(context, R.drawable.esferainercia);
                    icono = ContextCompat.getDrawable(context, R.drawable.esfera);
                    DialogoPersonalizado();
                    break;

                case 4:
                    texto = "Esfera Hueca";
                    modelo = ContextCompat.getDrawable(context, R.drawable.cascoesferico);
                    icono = ContextCompat.getDrawable(context, R.drawable.esferah);
                    DialogoPersonalizado();
                    break;

                case 5:
                    texto = "Placa con eje central";
                    modelo = ContextCompat.getDrawable(context, R.drawable.placa);
                    icono = ContextCompat.getDrawable(context, R.drawable.placarectangular);
                    DialogoPersonalizado();
                    break;

                case 6:
                    texto = "Varilla con eje central";
                    modelo = ContextCompat.getDrawable(context, R.drawable.varillacentroinercia);
                    icono = ContextCompat.getDrawable(context, R.drawable.ejecentral);
                    DialogoPersonalizado();
                    break;

                case 7:
                    texto = "Varilla con eje extremo";
                    modelo = ContextCompat.getDrawable(context, R.drawable.varillaejeextremoinercia);
                    icono = ContextCompat.getDrawable(context, R.drawable.varillaejeextremo);
                    DialogoPersonalizado();
                    break;

                case 8:
                    texto = "Partículas";
                    modelo = ContextCompat.getDrawable(context, R.drawable.particula);
                    icono = ContextCompat.getDrawable(context, R.drawable.particulas);
                    DialogoPersonalizado();
                    break;
            }
        }
        //dialogos de seleccion
        public void DialogoPersonalizado() {
            final AlertDialog.Builder builder = new AlertDialog.Builder(context);
            inf = LayoutInflater.from(context);
            View vista = inf.inflate(R.layout.dialogo_contextos_dinamicos, null);
            builder.setCancelable(false);
            builder.setView(vista);

            final AlertDialog dialog = builder.create();
            dialog.show();
            //id de los checkboxes
            final RadioButton rb1 = (RadioButton) vista.findViewById(R.id.rb1);
            final RadioButton rb2 = (RadioButton) vista.findViewById(R.id.rb2);
            final RadioButton rb3 = (RadioButton) vista.findViewById(R.id.rb3);
            final RadioButton rb4 = (RadioButton) vista.findViewById(R.id.rb4);
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
                    if (rb1.isChecked()) {
                        switch (texto) {
                            case "Cilindro Anular":
                                dialogo_inercia_rotacional_cilindro();
                                break;
                            case "Placa con eje central":
                                dialogo_inercia_rotacional_placa();
                                break;
                            default:
                                dialogo_inercia_rotacional();
                        }
                    } else if (rb2.isChecked()) {
                        dialogo_momento_fuerza();
                    } else if (rb3.isChecked()) {
                        dialogo_momento_angular();
                    } else if (rb4.isChecked()) {
                        dialogo_energia_rotacional();
                    } else {
                        dialogo_alerta_IngresoContextosDinamicos().show();
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
        public void dialogo_momento_fuerza() {
            f = new Intent(context, MomentoFuerza.class);
            final AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Dialog_Alert);
            inf = LayoutInflater.from(context);
            View vista = inf.inflate(R.layout.dialogo_momento_fuerza, null);
            builder.setCancelable(false);
            builder.setView(vista);
            final AlertDialog dialog = builder.create();
            dialog.show();
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
            imagen.setImageDrawable(modelo);
            titulo.setText(texto);
            //codigo de funcionamiento del boton OK
            btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (c1.isChecked() & c2.isChecked() & c3.isChecked() & c4.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatosMF().show();

                    } else if (c1.isChecked() & c2.isChecked() & c3.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatosMF().show();

                    } else if (c1.isChecked() & c2.isChecked() & c3.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatosMF().show();

                    } else if (c1.isChecked() & c2.isChecked() & c4.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatosMF().show();

                    } else if (c1.isChecked() & c3.isChecked() & c4.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatosMF().show();

                    } else if (c3.isChecked() & c2.isChecked() & c5.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatosMF().show();

                        ///3 checks
                    } else if (c1.isChecked() & c2.isChecked() & c3.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();

                    } else if (c1.isChecked() & c2.isChecked() & c4.isChecked()) {
                        ///codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                "\nTorque\nFuerza tangencial\nInercia rotacional", FBToast.LENGTH_LONG);
                        f.putExtra("p", 1);
                        AnalisisObjeto(f, posicion);
                        dialog.dismiss();

                    } else if (c1.isChecked() & c2.isChecked() & c5.isChecked()) {
                        ///codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                "\nTorque\nFuerza tangencial\n aceleracion angular", FBToast.LENGTH_LONG);
                        f.putExtra("p", 2);
                        AnalisisObjeto(f, posicion);
                        dialog.dismiss();

                    } else if (c1.isChecked() & c3.isChecked() & c4.isChecked()) {
                        ///codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                "\nRadio de giro\nInercia rotacional\nTorque rotacional", FBToast.LENGTH_LONG);
                        f.putExtra("p", 3);
                        AnalisisObjeto(f, posicion);
                        dialog.dismiss();

                    } else if (c1.isChecked() & c3.isChecked() & c5.isChecked()) {
                        ///codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables:\nTorque \nRadio de giro" +
                                "\naceleración angular", FBToast.LENGTH_LONG);
                        f.putExtra("p", 4);
                        AnalisisObjeto(f, posicion);
                        dialog.dismiss();

                    } else if (c1.isChecked() & c4.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();

                    } else if (c2.isChecked() & c3.isChecked() & c4.isChecked()) {
                        ///codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables:\nFuerza tangencial \nRadio de giro" +
                                "\nInercia rotacional", FBToast.LENGTH_LONG);
                        f.putExtra("p", 5);
                        AnalisisObjeto(f, posicion);
                        dialog.dismiss();

                    } else if (c2.isChecked() & c3.isChecked() & c5.isChecked()) {
                        ///codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables:\nFuerza tagencial \nAceleración angular" +
                                "\nRadio de giro", FBToast.LENGTH_LONG);
                        f.putExtra("p", 6);
                        AnalisisObjeto(f, posicion);
                        dialog.dismiss();

                    } else if (c2.isChecked() & c4.isChecked() & c5.isChecked()) {
                        ///codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables:\nInercia rotacional \nFuerza tangencial" +
                                "\n aceleración angular", FBToast.LENGTH_LONG);
                        f.putExtra("p", 7);
                        AnalisisObjeto(f, posicion);
                        dialog.dismiss();

                    } else if (c3.isChecked() & c4.isChecked() & c5.isChecked()) {
                        ///codigo
                        ///codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables:\n Aceleración angular \n Radio de giro" +
                                "\nInercia rotacional", FBToast.LENGTH_LONG);
                        f.putExtra("p", 8);
                        AnalisisObjeto(f, posicion);
                        dialog.dismiss();

                        //2checks
                    } else if (c1.isChecked() & c2.isChecked()) {
                        /////codigo
                        f.putExtra("p", 9);
                        AnalisisObjeto(f, posicion);
                        dialog.dismiss();
                        FBToast.infoToast(context, "Se han seleccionado las variables: " +
                                "Torque\nFuerza tangencial", FBToast.LENGTH_SHORT);

                    } else if (c1.isChecked() & c3.isChecked()) {
                        /////codigo
                        f.putExtra("p", 10);
                        AnalisisObjeto(f, posicion);
                        dialog.dismiss();
                        FBToast.infoToast(context, "Se han seleccionado las variables: " +
                                "Torque\nRadio de giro", FBToast.LENGTH_SHORT);

                    } else if (c1.isChecked() & c4.isChecked()) {
                        /////codigo
                        f.putExtra("p", 11);
                        AnalisisObjeto(f, posicion);
                        dialog.dismiss();
                        FBToast.infoToast(context, "Se han seleccionado las variables: " +
                                "Torque\nInercia rotacional", FBToast.LENGTH_SHORT);

                    } else if (c1.isChecked() & c5.isChecked()) {
                        /////codigo
                        f.putExtra("p", 12);
                        AnalisisObjeto(f, posicion);
                        dialog.dismiss();
                        FBToast.infoToast(context, "Se han seleccionado las variables: " +
                                "Torque\nAceleración angular", FBToast.LENGTH_SHORT);

                    } else if (c2.isChecked() & c3.isChecked()) {
                        /////codigo
                        f.putExtra("p", 13);
                        AnalisisObjeto(f, posicion);
                        dialog.dismiss();
                        FBToast.infoToast(context, "Se han seleccionado las variables: " +
                                "Radio de giro\nFuerza tangencial", FBToast.LENGTH_SHORT);

                    } else if (c2.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();

                    } else if (c2.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();

                    } else if (c3.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();

                    } else if (c3.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();

                    } else if (c4.isChecked() & c5.isChecked()) {
                        /////codigo
                        f.putExtra("p", 14);
                        AnalisisObjeto(f, posicion);
                        dialog.dismiss();
                        FBToast.infoToast(context, "Se han seleccionado las variables: " +
                                "Inercia rotacional\nAceleracion angular", FBToast.LENGTH_SHORT);
                    } else {
                        dialogo_alerta_IngresoDatosMF().show();
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
        public void dialogo_momento_angular() {
            a = new Intent(context, MomentoAngular.class);

            final AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Dialog_Alert);
            inf = LayoutInflater.from(context);
            View vista = inf.inflate(R.layout.dialogo_momento_angular, null);
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
            ts3.setText(Html.fromHtml("L<sub>o</sub>"));
            TextView ts4 = (TextView) vista.findViewById(R.id.ts4);
            ts4.setText(Html.fromHtml("L<sub>f</sub>"));
            TextView ts5 = (TextView) vista.findViewById(R.id.ts5);
            ts5.setText(Html.fromHtml("I"));
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
            imagen.setImageDrawable(modelo);
            titulo.setText(texto);
            //codigo de funcionamiento del boton OK
            btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (c1.isChecked() & c2.isChecked() & c3.isChecked() & c4.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c2.isChecked() & c3.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c2.isChecked() & c3.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c2.isChecked() & c4.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c3.isChecked() & c4.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c3.isChecked() & c2.isChecked() & c5.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c2.isChecked() & c3.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c2.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c2.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c3.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c3.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c4.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c2.isChecked() & c3.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c2.isChecked() & c3.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c2.isChecked() & c4.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c3.isChecked() & c4.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();

                    } else if (c1.isChecked() & c2.isChecked()) {
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                " \nvelocidad inicial y final.", FBToast.LENGTH_LONG);
                        a.putExtra("p", 1);
                        AnalisisObjeto(a, posicion);
                        dialog.dismiss();

                    } else if (c1.isChecked() & c3.isChecked()) {
                        //codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                " \nvelocidad inicial y el momentum inicial.", FBToast.LENGTH_LONG);
                        a.putExtra("p", 2);
                        AnalisisObjeto(a, posicion);
                        dialog.dismiss();

                    } else if (c1.isChecked() & c4.isChecked()) {
                        //codigo
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();

                    } else if (c1.isChecked() & c5.isChecked()) {
                        //codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables: " +
                                "\nvelocidad inicial e inercia .", FBToast.LENGTH_LONG);
                        a.putExtra("p", 3);
                        AnalisisObjeto(a, posicion);
                        dialog.dismiss();
                    } else if (c2.isChecked() & c3.isChecked()) {
                        //codigo
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();

                    } else if (c2.isChecked() & c4.isChecked()) {
                        //codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                " \nvelocidad final y el momentum final.", FBToast.LENGTH_LONG);
                        a.putExtra("p", 4);
                        AnalisisObjeto(a, posicion);
                        dialog.dismiss();
                    } else if (c2.isChecked() & c5.isChecked()) {
                        //codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables: " +
                                "\nvelocidad final e inercia.", FBToast.LENGTH_LONG);
                        a.putExtra("p", 5);
                        AnalisisObjeto(a, posicion);
                        dialog.dismiss();
                    } else if (c3.isChecked() & c4.isChecked()) {
                        //codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                " \nMomentum final e inicial.", FBToast.LENGTH_LONG);
                        a.putExtra("p", 6);
                        AnalisisObjeto(a, posicion);
                        dialog.dismiss();
                    } else if (c5.isChecked() & c3.isChecked()) {
                        //codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables: " +
                                "\nMomentum inicial e Inercia.", FBToast.LENGTH_LONG);
                        a.putExtra("p", 7);
                        AnalisisObjeto(a, posicion);
                        dialog.dismiss();
                    } else if (c4.isChecked() & c5.isChecked()) {
                        //codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables: " +
                                "\nMomentum final e Inercia.", FBToast.LENGTH_LONG);
                        a.putExtra("p", 8);
                        AnalisisObjeto(a, posicion);
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
        public void dialogo_energia_rotacional() {
            e = new Intent(context, EnergiaRotacional.class);
            final AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Dialog_Alert);
            inf = LayoutInflater.from(context);
            View vista = inf.inflate(R.layout.dialogo_energia_angular, null);
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
            ts3.setText(Html.fromHtml("Ec<sub>o</sub>"));
            TextView ts4 = (TextView) vista.findViewById(R.id.ts4);
            ts4.setText(Html.fromHtml("Ec<sub>f</sub>"));
            TextView ts5 = (TextView) vista.findViewById(R.id.ts5);
            ts5.setText(Html.fromHtml("I"));
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
            imagen.setImageDrawable(modelo);
            titulo.setText(texto);
            //codigo de funcionamiento del boton OK
            btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (c1.isChecked() & c2.isChecked() & c3.isChecked() & c4.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c2.isChecked() & c3.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c2.isChecked() & c3.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c2.isChecked() & c4.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c3.isChecked() & c4.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c3.isChecked() & c2.isChecked() & c5.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c2.isChecked() & c3.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c2.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c2.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c3.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c3.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c1.isChecked() & c4.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c2.isChecked() & c3.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c2.isChecked() & c3.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c2.isChecked() & c4.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();
                    } else if (c3.isChecked() & c4.isChecked() & c5.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();

                    } else if (c1.isChecked() & c2.isChecked()) {
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                " \nvelocidad inicial y final.", FBToast.LENGTH_LONG);
                        e.putExtra("p", 1);
                        AnalisisObjeto(e, posicion);
                        dialog.dismiss();

                    } else if (c1.isChecked() & c3.isChecked()) {
                        //codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                " \nvelocidad inicial y la energía inicial.", FBToast.LENGTH_LONG);
                        e.putExtra("p", 2);
                        AnalisisObjeto(e, posicion);
                        dialog.dismiss();

                    } else if (c1.isChecked() & c4.isChecked()) {
                        //codigo
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();

                    } else if (c1.isChecked() & c5.isChecked()) {
                        //codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                " \nvelocidad inicial e inercia .", FBToast.LENGTH_LONG);
                        e.putExtra("p", 3);
                        AnalisisObjeto(e, posicion);
                        dialog.dismiss();
                    } else if (c2.isChecked() & c3.isChecked()) {
                        //codigo
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();

                    } else if (c2.isChecked() & c4.isChecked()) {
                        //codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables: " +
                                "\nvelocidad final y Energía final.", FBToast.LENGTH_LONG);
                        e.putExtra("p", 4);
                        AnalisisObjeto(e, posicion);
                        dialog.dismiss();
                    } else if (c2.isChecked() & c5.isChecked()) {
                        //codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                " \nvelocidad final e inercia.", FBToast.LENGTH_LONG);
                        e.putExtra("p", 5);
                        AnalisisObjeto(e, posicion);
                        dialog.dismiss();
                    } else if (c3.isChecked() & c4.isChecked()) {
                        //codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                " \nEnergía final e inicial.", FBToast.LENGTH_LONG);
                        e.putExtra("p", 6);
                        AnalisisObjeto(e, posicion);
                        dialog.dismiss();
                    } else if (c5.isChecked() & c3.isChecked()) {
                        //codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                " \nEnergía inicial e Inercia.", FBToast.LENGTH_LONG);
                        e.putExtra("p", 7);
                        AnalisisObjeto(e, posicion);
                        dialog.dismiss();
                    } else if (c4.isChecked() & c5.isChecked()) {
                        //codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                " \nEnergía final e Inercia.", FBToast.LENGTH_LONG);
                        e.putExtra("p", 8);
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
        public void dialogo_inercia_rotacional() {
            iner = new Intent(context, InerciaRotacional.class);
            iner.putExtra("solidoRigido", 1);
            final AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Dialog_Alert);
            inf = LayoutInflater.from(context);
            View vista = inf.inflate(R.layout.dialogo_inercia_rotacional, null);
            builder.setCancelable(false);
            builder.setView(vista);

            final AlertDialog dialog = builder.create();
            dialog.show();
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
            imagen.setImageDrawable(modelo);
            titulo.setText(texto);
            //codigo de funcionamiento del boton OK
            btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (c1.isChecked() & c2.isChecked() & c3.isChecked()) {
                        dialogo_alerta_IngresoDatos2().show();

                    } else if (c1.isChecked() & c2.isChecked()) {
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                " \nmasa y radio.", FBToast.LENGTH_LONG);
                        iner.putExtra("p", 1);
                        AnalisisObjeto(iner, posicion);
                        dialog.dismiss();

                    } else if (c1.isChecked() & c3.isChecked()) {
                        //codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                " \nmasa e inercia rotacional.", FBToast.LENGTH_LONG);
                        iner.putExtra("p", 2);
                        AnalisisObjeto(iner, posicion);
                        dialog.dismiss();

                    } else if (c2.isChecked() & c3.isChecked()) {
                        //codigo
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                " \nradio e inercia rotacional.", FBToast.LENGTH_LONG);
                        iner.putExtra("p", 3);
                        AnalisisObjeto(iner, posicion);
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
        public void dialogo_inercia_rotacional_cilindro() {
            iner = new Intent(context, InerciaRotacional.class);
            iner.putExtra("solidoRigido", 2);
            final AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Dialog_Alert);
            inf = LayoutInflater.from(context);
            View vista = inf.inflate(R.layout.dialogo_inercia_rotacional_cilindro, null);
            builder.setCancelable(false);
            builder.setView(vista);

            final AlertDialog dialog = builder.create();
            dialog.show();
            //id de los text de simbolo

            TextView ts2 = (TextView) vista.findViewById(R.id.ts2);
            ts2.setText(Html.fromHtml("R<sub>1</sub>"));
            TextView ts3 = (TextView) vista.findViewById(R.id.ts3);
            ts3.setText(Html.fromHtml("R<sub>2</sub>"));
            //id de los checkboxes
            final CheckBox c1 = (CheckBox) vista.findViewById(R.id.check1);
            final CheckBox c2 = (CheckBox) vista.findViewById(R.id.check2);
            final CheckBox c3 = (CheckBox) vista.findViewById(R.id.check3);
            final CheckBox c4 = (CheckBox) vista.findViewById(R.id.check4);

            //id de otros elementos
            Button btnOK = (Button) vista.findViewById(R.id.botonOK);
            Button btnCANCELAR = (Button) vista.findViewById(R.id.botonCancelar);
            ImageView imagen = (ImageView) vista.findViewById(R.id.grafico);
            TextView titulo = (TextView) vista.findViewById(R.id.titulo);
            //id de elementos graficos del dialogo
            imagen.setImageDrawable(modelo);
            titulo.setText(texto);
            //codigo de funcionamiento del boton OK
            btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (c1.isChecked() & c2.isChecked() & c3.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
                    } else if (c1.isChecked() & c2.isChecked() & c3.isChecked()) {
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                " \nmasa\nradio mayor\nradio menor", FBToast.LENGTH_LONG);
                        iner.putExtra("p", 4);
                        AnalisisObjeto(iner, posicion);
                        dialog.dismiss();
                    } else if (c1.isChecked() & c2.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
                    } else if (c2.isChecked() & c3.isChecked() & c4.isChecked()) {
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                " \nradio mayor\nradio menor\ninercia rotacional", FBToast.LENGTH_LONG);
                        iner.putExtra("p", 5);
                        AnalisisObjeto(iner, posicion);
                        dialog.dismiss();
                    } else if (c1.isChecked() & c3.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
                    } else if (c1.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
                    } else if (c1.isChecked() & c2.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
                    } else if (c1.isChecked() & c3.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
                    } else if (c2.isChecked() & c3.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
                    } else if (c2.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
                    } else if (c4.isChecked() & c3.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
                    } else {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
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
        public void dialogo_inercia_rotacional_placa() {
            iner = new Intent(context, InerciaRotacional.class);
            iner.putExtra("solidoRigido", 3);
            final AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Dialog_Alert);
            inf = LayoutInflater.from(context);
            View vista = inf.inflate(R.layout.dialogo_inercia_rotacional_placa, null);
            builder.setCancelable(false);
            builder.setView(vista);

            final AlertDialog dialog = builder.create();
            dialog.show();

            //id de los checkboxes
            final CheckBox c1 = (CheckBox) vista.findViewById(R.id.check1);
            final CheckBox c2 = (CheckBox) vista.findViewById(R.id.check2);
            final CheckBox c3 = (CheckBox) vista.findViewById(R.id.check3);
            final CheckBox c4 = (CheckBox) vista.findViewById(R.id.check4);

            //id de otros elementos
            Button btnOK = (Button) vista.findViewById(R.id.botonOK);
            Button btnCANCELAR = (Button) vista.findViewById(R.id.botonCancelar);
            ImageView imagen = (ImageView) vista.findViewById(R.id.grafico);
            TextView titulo = (TextView) vista.findViewById(R.id.titulo);
            //id de elementos graficos del dialogo
            imagen.setImageDrawable(modelo);
            titulo.setText(texto);
            //codigo de funcionamiento del boton OK
            btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (c1.isChecked() & c2.isChecked() & c3.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
                    } else if (c1.isChecked() & c2.isChecked() & c3.isChecked()) {
                        FBToast.infoToast(context, "Se han seleccionado las variables: " +
                                "\nmasa\nlongitud\nancho", FBToast.LENGTH_LONG);
                        iner.putExtra("p", 6);
                        AnalisisObjeto(iner, posicion);
                        dialog.dismiss();
                    } else if (c1.isChecked() & c2.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
                    } else if (c2.isChecked() & c3.isChecked() & c4.isChecked()) {
                        FBToast.infoToast(context, "Se han seleccionado las variables:" +
                                " \nlongitud\nancho\ninercia rotacional", FBToast.LENGTH_LONG);

                        iner.putExtra("p", 7);
                        AnalisisObjeto(iner, posicion);
                        dialog.dismiss();
                    } else if (c1.isChecked() & c3.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
                    } else if (c1.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
                    } else if (c1.isChecked() & c2.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
                    } else if (c1.isChecked() & c3.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
                    } else if (c2.isChecked() & c3.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
                    } else if (c2.isChecked() & c4.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
                    } else if (c4.isChecked() & c3.isChecked()) {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
                    } else {
                        dialogo_alerta_IngresoDatosCasosEspeciales().show();
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





        //dialogos de alerta
        public void AnalisisObjeto(Intent e, Integer n) {
            String image = "im";
            e.putExtra("id", texto);
            e.putExtra(image, n + 1);
            context.startActivity(e);
        }

        public Dialog dialogo_alerta_IngresoDatosMF() {
            final AlertDialog builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Dialog_Alert).create();
            builder.setCanceledOnTouchOutside(false);
            builder.setCancelable(false);
            builder.setIcon(icono);
            builder.setTitle("Información");
            builder.setMessage("Seleccione como maximo 3 valores y como minimo 2 valores.");

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
            builder.setMessage("Seleccione 2 valores numéricos.");

            builder.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    builder.cancel();
                }
            });
            return builder;
        }
        public Dialog dialogo_alerta_IngresoDatosCasosEspeciales() {
            final AlertDialog builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Dialog_Alert).create();
            builder.setCanceledOnTouchOutside(false);
            builder.setCancelable(false);
            builder.setIcon(icono);
            builder.setTitle("Información");
            builder.setMessage("Los valores seleccionados no resuelven ningún problema.");

            builder.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    builder.cancel();
                }
            });
            return builder;
        }
        public Dialog dialogo_alerta_IngresoContextosDinamicos() {
            final AlertDialog builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Dialog_Alert).create();
            builder.setCanceledOnTouchOutside(false);
            builder.setCancelable(false);
            builder.setIcon(icono);
            builder.setTitle("Información");
            builder.setMessage("Seleccione el contexto dinámico a analizar.");

            builder.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    builder.cancel();
                }
            });
            return builder;
        }
    };
}
