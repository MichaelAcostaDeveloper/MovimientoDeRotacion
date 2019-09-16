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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
import com.tfb.fbtoast.FBToast;

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
import michael.acosta.movimientoderotacion.tarea.TareaProfeContent;

public class TareaProfeListActivity extends AppCompatActivity {
    private static final String PATH_TAREAS = "TAREAS";
    @BindView(R.id.item_list)
    RecyclerView recyclerView;
    @BindView(R.id.categoriaPersona)
    TextView categoriaPersona;
    @BindView(R.id.etNombreTarea)
    TextInputEditText etNombreTarea;
    @BindView(R.id.etDetalleTarea)
    TextInputEditText etDetalleTarea;
    @BindView(R.id.btnGenTarea)
    Button btnGenTarea;
    @BindView(R.id.btnGenCodec)
    Button btnGenCodec;
    @BindView(R.id.tvCodigoTarea)
    TextView tvCodigoTarea;
    @BindView(R.id.etAnio)
    EditText etAnio;
    @BindView(R.id.etParalelo)
    EditText etParalelo;
    @BindView(R.id.etNumTarea)
    EditText etNumTarea;
    @BindView(R.id.tvConsignaDetalleTarea)
    TextView tvConsignaDetalleTarea;
    //para el Toolbar
    String datos;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(), R.color.primaryColor));
        setContentView(R.layout.activity_tarea_profe_list);
        ButterKnife.bind(this);
        //Para la barra de herramientas
        //intent para traer los valores del activity Evaluacion
        Intent recibir = getIntent();
        datos = recibir.getStringExtra("s");

        final Toolbar tt = (Toolbar) findViewById(R.id.toolbarModuloEvaluacion);
        tt.setTitle(datos);
        categoriaPersona.setText(datos + ":");
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
                    Glide.with(TareaProfeListActivity.this).load(user.getPhotoUrl()).apply(options).into(imgPhotoProfile);
                    configFirebaseTareas();
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

        View recyclerView = findViewById(R.id.item_list);
        assert recyclerView != null;
        TareaProfeContent.cleanAdapter();
        setupRecyclerView();
    }


    //este codigo permite llenar el recyclerView
    private void setupRecyclerView() {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(TareaProfeContent.ITEMS));
    }


    public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {
        private final List<TareaProfeContent.TareaProfe> mValues;

        SimpleItemRecyclerViewAdapter(List<TareaProfeContent.TareaProfe> items) {
            mValues = items;
        }

        //CODIGO PARA INFLAR EL CONTENIDO DE LA TARJETA
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_tareas_content, parent, false);
            return new ViewHolder(view);
        }

        //CODIGO PARA DAR FUNCIONALIDAD A CADA ELEMENTO GRAFICO DE LA TARGETA
        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.mIdView.setText(mValues.get(position).getNombre());
            holder.mContentView.setText(mValues.get(position).getDetalle());
            holder.codec.setText(mValues.get(position).getCodigo());
            holder.itemView.setTag(mValues.get(position));
            //permite dirigirse a una nueva pantalla
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(TareaProfeListActivity.this, "Revision de tareas", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(TareaProfeListActivity.this, TareaProfeDetalleActivity.class);
                    intent.putExtra("nombreTarea", mValues.get(position).getNombre());
                    intent.putExtra("codigoTarea", mValues.get(position).getCodigo());
                    startActivity(intent);
                }
            });
            //permite eliminar tarea
            holder.btnBorrarTarea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Eliminar tarea?", Snackbar.LENGTH_LONG)
                            .setAction("SI", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                                    DatabaseReference reference = database.getReference(PATH_TAREAS);
                                    reference.child(tvNombre.getText().toString().trim()).child(mValues.get(position).getId()).removeValue();
                                }
                            }).show();
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
            final TextView mContentView;
            @BindView(R.id.btnBorrarTarea)
            ImageButton btnBorrarTarea;
            @BindView(R.id.codec)
            TextView codec;

            ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
                mIdView = (TextView) view.findViewById(R.id.id_text);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }

    //funcion del boton para generar la nueva tarea
    @OnClick(R.id.btnGenTarea)
    public void onViewClickedTarea() {
        if (etNombreTarea.getText().toString().equals("") &
                etDetalleTarea.getText().toString().equals("") &
                tvCodigoTarea.getText().toString().equals("")) {
            etNombreTarea.setError("Obligatorio!");
            etDetalleTarea.setError("Obligatorio!");
        } else if (etNombreTarea.getText().toString().equals("")) {
            etNombreTarea.setError("Obligatorio!");
        } else if (etDetalleTarea.getText().toString().equals("")) {
            etDetalleTarea.setError("Obligatorio!");
        } else if (tvCodigoTarea.getText().toString().equals("")) {
            Toast.makeText(TareaProfeListActivity.this, "Genere un código de tarea", Toast.LENGTH_SHORT).show();
        } else {
            TareaProfeContent.TareaProfe tarea = new TareaProfeContent.TareaProfe(
                    tvCodigoTarea.getText().toString().trim(),
                    etNombreTarea.getText().toString().trim(),
                    etDetalleTarea.getText().toString().trim());
            //creacion de la instancia en Firebase
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference reference = database.getReference(PATH_TAREAS).child(tvNombre.getText().toString().trim());
            //codigo para no tener duplicaciones
            TareaProfeContent.TareaProfe tareaUpdate = TareaProfeContent.getTareaProfeA(tarea.getNombre());
            if (tareaUpdate != null) {
                reference.child(tareaUpdate.getId()).setValue(tarea);
            } else {
                reference.push().setValue(tarea);
            }
            tvCodigoTarea.setText("");
            etNombreTarea.setText("");
            etDetalleTarea.setText("");
            etNumTarea.setText("");
            etParalelo.setText("");
            etAnio.setText("");
        }
    }

    @OnClick(R.id.btnGenCodec)
    public void onViewClickedCodigo() {
        if (!etAnio.getText().toString().equals("") &
                !etParalelo.getText().toString().equals("") &
                !etNumTarea.getText().toString().equals("")) {

            //elementos graficos que se visualizan
            tvConsignaDetalleTarea.setVisibility(View.VISIBLE);
            etNombreTarea.setVisibility(View.VISIBLE);
            etDetalleTarea.setVisibility(View.VISIBLE);
            btnGenTarea.setVisibility(View.VISIBLE);
            //codigo para hacer el codigo unico de la tarea
            char[] elementos = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
                    'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't',
                    'u', 'v', 'w', 'x', 'y', 'z'};
            char[] conjunto = new char[5];
            for (int i = 0; i < 5; i++) {
                int clave = (int) (Math.random() * 36);
                conjunto[i] = (char) elementos[clave];
            }
            String password = new String(conjunto);
            tvCodigoTarea.setText(etAnio.getText().toString().trim() +
                    etParalelo.getText().toString().trim() +
                    etNumTarea.getText().toString().trim() + password);


        } else {
            FBToast.errorToast(TareaProfeListActivity.this, "Existen campos vacíos en los valores del curso asignado!", FBToast.LENGTH_LONG);


        }
    }


    private void configFirebaseTareas() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference(PATH_TAREAS).child(tvNombre.getText().toString().trim());
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            //para agregar
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                TareaProfeContent.TareaProfe t = dataSnapshot.getValue(TareaProfeContent.TareaProfe.class);//para pasar el objeto
                t.setId(dataSnapshot.getKey());
                if (!TareaProfeContent.ITEMS.contains(t)) {
                    TareaProfeContent.addItem(t);
                }
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                TareaProfeContent.TareaProfe t = dataSnapshot.getValue(TareaProfeContent.TareaProfe.class);//para pasar el objeto
                t.setId(dataSnapshot.getKey());
                if (TareaProfeContent.ITEMS.contains(t)) {
                    TareaProfeContent.updateItem(t);
                }
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                TareaProfeContent.TareaProfe t = dataSnapshot.getValue(TareaProfeContent.TareaProfe.class);//para pasar el objeto
                t.setId(dataSnapshot.getKey());
                if (TareaProfeContent.ITEMS.contains(t)) {
                    TareaProfeContent.deleteItem(t);
                }
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Toast.makeText(TareaProfeListActivity.this, "Algo falló, intente más tarde.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(TareaProfeListActivity.this, "Algo falló, intente más tarde.", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Bienvenido al módulo de evaluación", Toast.LENGTH_SHORT).show();
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
                tvNombre.setText("");
                tvCorreo.setText("");
                tvFecha.setText("");
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

