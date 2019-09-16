package michael.acosta.movimientoderotacion;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import michael.acosta.movimientoderotacion.estudiante.EstudianteContent;
import michael.acosta.movimientoderotacion.persona.TareaContent;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TareaProfeDetalleActivity extends AppCompatActivity {
    @BindView(R.id.tvNombreTarea)
    TextView tvNombreTarea;
    @BindView(R.id.tvCodigoTarea)
    TextView tvCodigoTarea;
    String nombreEstudiante;
    @BindView(R.id.item_list_ejercicios)
    RecyclerView recyclerView;
    @BindView(R.id.tvNombres)
    TextView tvNombres;
    @BindView(R.id.tvEjercicios)
    TextView tvEjercicios;
    @BindView(R.id.tvFecha)
    TextView tvFecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(), R.color.primaryColor));
        setContentView(R.layout.activity_tarea_profe_detalle);
        ButterKnife.bind(this);
        final Toolbar tt = (Toolbar) findViewById(R.id.toolbarModuloEvaluacion);
        tt.setTitle("Profesor");
        tt.setSubtitle("Tareas y revisión de registros");
        setSupportActionBar(tt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        tt.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //para escribir la fecha actual de inicio de sesion
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        final String fecha = dateFormat.format(date);
        tvFecha.setText(fecha);
        tvEjercicios.setVisibility(View.INVISIBLE);

        Intent recibir = getIntent();
        String nombreTarea = recibir.getStringExtra("nombreTarea");
        String codigoTarea = recibir.getStringExtra("codigoTarea");

        tvNombreTarea.setText(nombreTarea);
        tvCodigoTarea.setText(codigoTarea);
        tvCodigoTarea.setEnabled(false);

        View recyclerViewEstudiantes = findViewById(R.id.item_list_estudiantes);

        assert recyclerViewEstudiantes != null;
        setupRecyclerViewEstudiantes((RecyclerView) recyclerViewEstudiantes);
    }
    //este codigo permite llenar el recyclerView DE ESTUDIANTES
    private void setupRecyclerViewEstudiantes(@NonNull final RecyclerView recyclerView) {
        EstudianteContent.cleanAdapter();
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapterEstudiantes(EstudianteContent.ITEMS));
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("CODIGOS RELACION ESTUDIANTES").child(tvCodigoTarea.getText().toString().trim());
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            //para agregar
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                EstudianteContent.Estudiante t = dataSnapshot.getValue(EstudianteContent.Estudiante.class);//para pasar el objeto
                t.setId(dataSnapshot.getKey());
                if (!EstudianteContent.ITEMS.contains(t)) {
                    EstudianteContent.addItem(t);
                }
                recyclerView.getAdapter().notifyDataSetChanged();
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                EstudianteContent.Estudiante t = dataSnapshot.getValue(EstudianteContent.Estudiante.class);//para pasar el objeto
                t.setId(dataSnapshot.getKey());
                if (EstudianteContent.ITEMS.contains(t)) {
                    EstudianteContent.updateItem(t);
                }
                recyclerView.getAdapter().notifyDataSetChanged();

            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                EstudianteContent.Estudiante t = dataSnapshot.getValue(EstudianteContent.Estudiante.class);//para pasar el objeto
                t.setId(dataSnapshot.getKey());
                if (EstudianteContent.ITEMS.contains(t)) {
                    EstudianteContent.deleteItem(t);
                }
                recyclerView.getAdapter().notifyDataSetChanged();
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
    public class SimpleItemRecyclerViewAdapterEstudiantes extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapterEstudiantes.ViewHolder> {
        private final List<EstudianteContent.Estudiante> mValues;
        SimpleItemRecyclerViewAdapterEstudiantes(List<EstudianteContent.Estudiante> items) {
            mValues = items;
        }
        //CODIGO PARA INFLAR EL CONTENIDO DE LA TARJETA
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_estudiantes_content, parent, false);
            return new ViewHolder(view);
        }
        //CODIGO PARA DAR FUNCIONALIDAD A CADA ELEMENTO GRAFICO DE LA TARGETA
        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.mIdView.setText(mValues.get(position).getNombre());
            holder.itemView.setTag(mValues.get(position));
            //permite dirigirse a una nueva pantalla
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nombreEstudiante = mValues.get(position).getNombre();
                    listarEjercicios();
                }
            });
        }
        //CODIGO PARA EL CONTEO DE TARJETAS QUE SE AÑADEN
        @Override
        public int getItemCount() {
            return mValues.size();
        }
        //CODIGO PARA ENLAZAR LOS ELEMENTOS GRAFICOS EL CODIGO JAVA
        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;
            ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
                mIdView = (TextView) view.findViewById(R.id.tvNombreEstudiante);
            }
        }
    }
    //METODO PARA LLENAR EL RECYCLER VIEW CON EJERCICIOS
    private void listarEjercicios() {
        tvEjercicios.setVisibility(View.VISIBLE);
        Toast.makeText(TareaProfeDetalleActivity.this, "Revisando tareas de "+nombreEstudiante, Toast.LENGTH_SHORT).show();
        tvEjercicios.setText(nombreEstudiante+" "+"envío:");
        TareaContent.cleanAdapter();//borrador de items
        configFirebaseReference();
        setupRecyclerView();
    }
    //este codigo permite llenar el recyclerView DE EJERCICIOS
    private void setupRecyclerView() {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(TareaContent.ITEMS));
    }
    public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {
        private final List<TareaContent.Tarea> mValues;

        SimpleItemRecyclerViewAdapter(List<TareaContent.Tarea> items) {
            mValues = items;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_ejercicios_content, parent, false);
            return new ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.mIdView.setText("Pregunta N° " + mValues.get(position).getNumPregunta());
            holder.mContentView.setText(mValues.get(position).getRespuesta());
            holder.mUniView.setText(mValues.get(position).getUnidad());
            holder.itemView.setTag(mValues.get(position));
        }
        @Override
        public int getItemCount() {
            return mValues.size();
        }
        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;
            final TextView mContentView;
            final TextView mUniView;
            ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
                mIdView = (TextView) view.findViewById(R.id.id_NumeroPregunta);
                mContentView = (TextView) view.findViewById(R.id.id_ResultadoPregunta);
                mUniView = (TextView) view.findViewById(R.id.id_UnidadPregunta);
            }
        }
    }
    private void configFirebaseReference() {
        //metodos para escribir los objetos en el activity
        //se crea una instancia
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("CODIGOS DE TAREAS")
                .child(tvCodigoTarea.getText().toString().trim())
                .child(nombreEstudiante);
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //PARA AÑADIR
                TareaContent.Tarea tipo = dataSnapshot.getValue(TareaContent.Tarea.class);
                tipo.setId(dataSnapshot.getKey());//uso de la llave de la base de datos de firebase
                if (!TareaContent.ITEMS.contains(tipo)) {
                    TareaContent.addItem(tipo);//ubicamos el objeto de la clase tarea con el metodo addItem
                }
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //PARA AÑADIR
                TareaContent.Tarea t = dataSnapshot.getValue(TareaContent.Tarea.class);
                t.setId(dataSnapshot.getKey());//uso de la llave de la base de datos de firebase
                if (TareaContent.ITEMS.contains(t)) {
                    TareaContent.updateItem(t);//ubicamos el objeto de la clase tarea con el metodo addItem
                }
                recyclerView.getAdapter().notifyDataSetChanged();
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                TareaContent.Tarea t = dataSnapshot.getValue(TareaContent.Tarea.class);
                t.setId(dataSnapshot.getKey());//uso de la llave de la base de datos de firebase
                if (TareaContent.ITEMS.contains(t)) {
                    TareaContent.deleteItem(t);//ubicamos el objeto de la clase tarea con el metodo addItem
                }
                recyclerView.getAdapter().notifyDataSetChanged();
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}

