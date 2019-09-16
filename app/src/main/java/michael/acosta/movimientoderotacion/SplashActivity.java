package michael.acosta.movimientoderotacion;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;

import michael.acosta.movimientoderotacion.Módulos.MainActivityCinematica;

public class SplashActivity extends AppCompatActivity {
    protected boolean _active = true;
    protected int _splashTime = 2000;
    protected int _controlTime = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setTheme(R.style.TemaPantallaBienvenida);
        setContentView(R.layout.activity_splash);
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (_active && (waited < _splashTime)) {
                        sleep(_controlTime);
                        if (_active) {
                            waited += _controlTime;
                        }
                    }
                } catch (InterruptedException e) {
                    // Capturamos la excepción de interrupción y continuamos por finally.
                } finally {
                    startActivity(new Intent(SplashActivity.this,
                            MainActivityCinematica.class));
                    finish();
                }
            }
        };
        splashTread.start();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            _active = false;
        }
        return true;
    }
}
