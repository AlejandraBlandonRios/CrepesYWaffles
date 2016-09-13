package com.alejandrablandon.crepeswaffles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    String user,contrasena,correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        setResult(RESULT_OK, intent);

        user = getIntent().getExtras().getString("usuario");
        contrasena = getIntent().getExtras().getString("contrasena");
        correo = getIntent().getExtras().getString("correo");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.mMiperfil:
                Intent intento=new Intent(this,MiPerfil.class);
                intento.putExtra("usuario1", user);
                intento.putExtra("contrasena1", contrasena);
                intento.putExtra("correo1", correo);
                startActivity(intento);
                finish();
                break;
            case R.id.mPrincipal:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
