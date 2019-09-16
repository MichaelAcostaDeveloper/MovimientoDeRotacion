package michael.acosta.movimientoderotacion;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.auth.AuthMethodPickerLayout;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import michael.acosta.movimientoderotacion.Módulos.MainActivityEvaluacion;
import michael.acosta.movimientoderotacion.estudiante.EstudianteContent;
import michael.acosta.movimientoderotacion.persona.TareaContent;

public class ItemListActivity extends AppCompatActivity {
    String clave;
    private static final String PATH_CODIGO_TAREAS = "CODIGOS DE TAREAS";
    private static final String PATH_CODIGO_ESTUDIANTES = "CODIGOS RELACION ESTUDIANTES";
    //botones de validacion y borrado del codigo
    ImageButton fab;
    @BindView(R.id.fabDelete)
    ImageButton fabDelete;
    //espacio para datos de usuarios
    @BindView(R.id.etCodigoProfe)
    EditText etCodigoProfe;
    @BindView(R.id.categoriaPersona)
    TextView categoriaPersona;
    //elementos de las preguntas enviadas
    @BindView(R.id.etNumPregunta)
    TextInputEditText etNumPregunta;
    @BindView(R.id.etResultado)
    TextInputEditText etResultado;
    @BindView(R.id.etUnidad)
    TextInputEditText etUnidad;
    @BindView(R.id.btnSubir)
    ImageButton btnSubir;
    //recyclerView y contenedores
    @BindView(R.id.item_list)
    RecyclerView recyclerView;
    @BindView(R.id.contenedorPreguntas)
    LinearLayout contenedorPreguntas;
    //consignas
    @BindView(R.id.consigna)
    TextView consigna;
    @BindView(R.id.consignaResultados)
    TextView consignaResultados;
    @BindView(R.id.consignaPreguntas)
    TextView consignaPreguntas;
    //variables para el login
    @BindView(R.id.tvNombre)
    TextView tvNombre;
    @BindView(R.id.imgPhotoProfile)
    CircleImageView imgPhotoProfile;
    @BindView(R.id.tvFecha)
    TextView tvFecha;
    @BindView(R.id.tvCorreo)
    TextView tvCorreo;
    //variables para el UI AUTHENTICATION
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private int RC_SIGN_IN = 123;
    private static final String PROVEEDOR_DESCONOCIDO = "Proveedor desconcido";
    //para el Toolbar
    String datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(), R.color.primaryColor));
        setContentView(R.layout.activity_item_list);
        ButterKnife.bind(this);//uso de la libreria BUtterKnife
        //intent para traer los valores del activity Evaluacion
        Intent recibir = getIntent();
        datos = recibir.getStringExtra("s");

        final Toolbar tt = (Toolbar) findViewById(R.id.toolbarModuloEvaluacion);
        tt.setTitle(datos);
        categoriaPersona.setText(datos + ":");
        tt.setSubtitle("Envío y registro de respuestas");
        setSupportActionBar(tt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        tt.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //codigo del UI AUTHENTICATION
        mFirebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //aqui se puede extraer info del usuario:correo, nombre,etc
                    onSetDataUser(user.getDisplayName(), user.getEmail(), user.getProviders() != null ? user.getProviders().get(0) : PROVEEDOR_DESCONOCIDO);
                    //para escribir la fecha actual de inicio de sesion
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    Date date = new Date();
                    final String fecha = dateFormat.format(date);
                    tvFecha.setText(fecha);
                    RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).centerCrop();//para extraer la imagen de usuario
                    Glide.with(ItemListActivity.this).load(user.getPhotoUrl()).apply(options).into(imgPhotoProfile);
                } else {
                    //limpiar datos y mostrar los proveedores para iniciar sesion
                    onSignedOutCleanup();
                    //Establecer el dialogo de Google
                    AuthUI.IdpConfig googleIdp = new AuthUI.IdpConfig.GoogleBuilder().build();
                    //Customizacion de la pantalla login
                    AuthMethodPickerLayout customLayout = new AuthMethodPickerLayout
                            .Builder(R.layout.view_login)
                            .setGoogleButtonId(R.id.btnGoogle)
                            .setEmailButtonId(R.id.btnEmail)
                            .setTosAndPrivacyPolicyId(R.id.tvPolicy)
                            .build();
                    //Estableciendo los proveedores de Google y Email
                    startActivityForResult(AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setIsSmartLockEnabled(false)
                            .setTosAndPrivacyPolicyUrls(
                                    "https://rotationdroidprivacypolicy.blogspot.com/2019/07/privacy-policy-michael-acosta-built_76.html",
                                    "https://rotationdroidprivacypolicy.blogspot.com/2019/07/privacy-policy-michael-acosta-built_76.html")
                            .setAvailableProviders(Arrays.asList(new AuthUI.IdpConfig.EmailBuilder().build(), googleIdp))
                            .setAuthMethodPickerLayout(customLayout).build(), RC_SIGN_IN);
                }
            }
        };
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "michael.acosta.movimientoderotacion",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
        //Elementos gráficos que se veran y no se veran al inicio del inicio de sesión
        btnSubir.setEnabled(false);//boton subir inactivo
        etNumPregunta.setEnabled(false);
        etResultado.setEnabled(false);
        etUnidad.setEnabled(false);
        contenedorPreguntas.setVisibility(View.INVISIBLE);
        etNumPregunta.setHint("");
        btnSubir.setVisibility(View.INVISIBLE);//BOTON DE SUBIR INVISIBLE
        consigna.setVisibility(View.INVISIBLE);
        consignaPreguntas.setVisibility(View.INVISIBLE);
        consignaResultados.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
        //FUNCIONAMIENTO DE LOS BOTONES DE VALIDACION DEL CODIGO DE ENVIO DEL PROFESOR
        fab = (ImageButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etCodigoProfe.getText().toString().trim().equals("")) {
                    etCodigoProfe.setError("Obligatorio!");
                } else {
                    Snackbar.make(view, "Validar el codigo de envio", Snackbar.LENGTH_LONG)
                            .setAction("SI", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    TareaContent.cleanAdapter();//borrador de items
                                    configFirebaseReference();//inicializa firebase
                                    //se mutea la caja de texto del codigo de la tarea
                                    etCodigoProfe.setEnabled(false);
                                    etNumPregunta.setEnabled(true);
                                    etResultado.setEnabled(true);
                                    etUnidad.setEnabled(true);
                                    btnSubir.setVisibility(View.VISIBLE);//boton de subir VISIBLE
                                    consigna.setVisibility(View.VISIBLE);
                                    consignaResultados.setVisibility(View.VISIBLE);
                                    contenedorPreguntas.setVisibility(View.VISIBLE);
                                    consignaPreguntas.setVisibility(View.VISIBLE);
                                    consignaPreguntas.setVisibility(View.VISIBLE);
                                    btnSubir.setEnabled(true);//boton de subir activado
                                    recyclerView.setVisibility(View.VISIBLE);
                                }
                            }).show();
                }
            }
        });
        TareaContent.cleanAdapter();//borrador de items
        fabDelete = (ImageButton) findViewById(R.id.fabDelete);
        fabDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etCodigoProfe.getText().toString().trim().equals("")) {
                    etCodigoProfe.setError("Obligatorio!");
                } else {
                    Snackbar.make(v, "Cambiar valores?", Snackbar.LENGTH_LONG)
                            .setAction("SI", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    TareaContent.cleanAdapter();//borrador de items
                                    configFirebaseReference();//inicializa firebase
                                    etCodigoProfe.setText("");//se blanquea la caja de texto
                                    etCodigoProfe.setEnabled(true);//se activa la caja de texto
                                    btnSubir.setEnabled(false);//boton subir inactivo
                                }
                            }).show();
                }
            }
        });
        TareaContent.cleanAdapter();//borrador de items
        setupRecyclerView();
    }

    //metodo de configuracion del firebase
    private void configFirebaseReference() {
        //metodos para escribir los objetos en el activity
        //se crea una instancia
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //Asignacion de los nodos
        DatabaseReference reference = database.getReference(PATH_CODIGO_TAREAS)
                .child(etCodigoProfe.getText().toString().trim())
                .child(tvNombre.getText().toString().trim());
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //PARA AÑADIR
                TareaContent.Tarea t = dataSnapshot.getValue(TareaContent.Tarea.class);
                t.setId(dataSnapshot.getKey());//uso de la llave de la base de datos de firebase
                if (!TareaContent.ITEMS.contains(t)) {
                    TareaContent.addItem(t);//ubicamos el objeto de la clase tarea con el metodo addItem
                }
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //PARA CAMBIAR
                TareaContent.Tarea t = dataSnapshot.getValue(TareaContent.Tarea.class);
                t.setId(dataSnapshot.getKey());//uso de la llave de la base de datos de firebase
                if (TareaContent.ITEMS.contains(t)) {
                    TareaContent.updateItem(t);//ubicamos el objeto de la clase tarea con el metodo updateItem
                }
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                //PARA MOVER O BORRAR
                TareaContent.Tarea t = dataSnapshot.getValue(TareaContent.Tarea.class);
                t.setId(dataSnapshot.getKey());//uso de la llave de la base de datos de firebase
                if (TareaContent.ITEMS.contains(t)) {
                    TareaContent.deleteItem(t);//eliminamos el objeto de la clase tarea con el metodo deleteItem
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

    //metodo de configuracion del firebase PARA ALUMNOS
    private void configFirebaseAlumnos() {

        final EstudianteContent.Estudiante e = new EstudianteContent.Estudiante(tvNombre.getText().toString().trim());
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference reference = database.getReference(PATH_CODIGO_ESTUDIANTES)
                .child(etCodigoProfe.getText().toString().trim());
        reference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                reference.push().setValue(e);


                for (DataSnapshot estudiantes : dataSnapshot.getChildren()) {

                    if (estudiantes.child("nombre").getValue().equals(e.getNombre())) {
                        clave = estudiantes.getKey();
                        reference.child(clave).removeValue();

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        reference.push().setValue(e);

    }

    //FUNCIONAMIENTOTO DEL BOTON SUBIR
    @OnClick(R.id.btnSubir)
    public void onViewClicked() {
        if (etNumPregunta.getText().toString().trim().equals("")) {
            etNumPregunta.setError("Obligatorio!");
        } else if (etResultado.getText().toString().trim().equals("")) {
            etResultado.setError("Obligatorio!");
        } else if (etUnidad.getText().toString().trim().equals("")) {
            etUnidad.setError("Obligatorio!");
        } else { //creacion de LOS OBJETOS
            configFirebaseAlumnos();
            TareaContent.Tarea t = new TareaContent.Tarea(
                    etNumPregunta.getText().toString().trim(),
                    etResultado.getText().toString().trim(),
                    etUnidad.getText().toString().trim());


            //ubicamos el objeto en firebase
            FirebaseDatabase databaseM = FirebaseDatabase.getInstance();
            DatabaseReference referenceM = databaseM.getReference(PATH_CODIGO_TAREAS)
                    .child(etCodigoProfe.getText().toString().trim())
                    .child(tvNombre.getText().toString().trim());

            TareaContent.Tarea tUpdate = TareaContent.getTareaA(t.getNumPregunta());
            if (tUpdate != null) {
                referenceM.child(tUpdate.getId()).setValue(t);
            } else {
                referenceM.push().setValue(t);
            }

            //blanqueamos las cajas de texto de las respuestas
            etNumPregunta.setText("");
            etResultado.setText("");
            etUnidad.setText("");

            //informamos que se envio la informacion
            Toast.makeText(this, "Información enviada con éxito", Toast.LENGTH_LONG).show();

        }
    }

    //PREPARACION DEL RECYCLERVIEW
    private void setupRecyclerView() {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(TareaContent.ITEMS));
    }

    //CONFIGURACION DEL RECYCLERVIEW
    public class SimpleItemRecyclerViewAdapter extends
            RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {
        private final List<TareaContent.Tarea> mValues;

        SimpleItemRecyclerViewAdapter(List<TareaContent.Tarea> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.mIdView.setText("Pregunta N° " + mValues.get(position).getNumPregunta());
            holder.mContentView.setText(mValues.get(position).getRespuesta());
            holder.mUniView.setText(mValues.get(position).getUnidad());
            holder.itemView.setTag(mValues.get(position));
            holder.idBtnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Desea eliminar la pregunta?", Snackbar.LENGTH_LONG).setAction("SI", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FirebaseDatabase db = FirebaseDatabase.getInstance();
                            DatabaseReference refery = db.getReference(PATH_CODIGO_TAREAS)
                                    .child(etCodigoProfe.getText().toString().trim())
                                    .child(tvNombre.getText().toString().trim());
                            refery.child(mValues.get(position).getId()).removeValue();
                        }
                    }).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;
            final TextView mContentView;
            final TextView mUniView;
            @BindView(R.id.id_btnDelete)
            ImageButton idBtnDelete;

            ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
                mIdView = (TextView) view.findViewById(R.id.id_NumeroPregunta);
                mContentView = (TextView) view.findViewById(R.id.id_ResultadoPregunta);
                mUniView = (TextView) view.findViewById(R.id.id_UnidadPregunta);
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Bienvenido...", Toast.LENGTH_SHORT).show();
            } else {
                if (IdpResponse.fromResultIntent(data) == null) {
                    onBackPressed();
                } else {
                    Toast.makeText(this, "Algo falló, intente de nuevo.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    //metodos para la AUTHENTICATION
    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAuthStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
    }

    //metodo para vaciar los datos de usuario
    private void onSignedOutCleanup() {
        onSetDataUser("", "", "");
    }

    //metodo para asignar los datos del usuario
    private void onSetDataUser(String userName, String email, String provider) {
        tvNombre.setText(userName);
        tvCorreo.setText(email);

    }

    //PARA SABER SI LA RESPUESTA ES POSITIVA O NEGATVA DEL SERVIDOR DE AUTENTICATION

    //CREACION DEL MENU DEL ITEM ACTIVITY para CERRAR SESION
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sign_out:
                etNumPregunta.setText("");
                etResultado.setText("");
                etUnidad.setText("");
                etCodigoProfe.setText("");
                etCodigoProfe.setEnabled(true);
                tvFecha.setText("");
                btnSubir.setVisibility(View.INVISIBLE);//BOTON DE SUBIR INVISIBLE
                consigna.setVisibility(View.INVISIBLE);
                consignaPreguntas.setVisibility(View.INVISIBLE);
                consignaResultados.setVisibility(View.INVISIBLE);
                contenedorPreguntas.setVisibility(View.INVISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
                AuthUI.getInstance().signOut(this);
                Intent h = new Intent(this, MainActivityEvaluacion.class);
                startActivity(h);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
