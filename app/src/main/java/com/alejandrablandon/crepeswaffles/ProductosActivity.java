package com.alejandrablandon.crepeswaffles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class ProductosActivity extends AppCompatActivity {

    String user,contrasena,correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

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
                intento.putExtra("usuario", user);
                intento.putExtra("contrasena", contrasena);
                intento.putExtra("correo", correo);
                startActivity(intento);
                finish();
                break;
            case R.id.mPrincipal:
                break;
            case R.id.mOferta_Frag:
                Intent intento1=new Intent(this,FragmentosActivity.class);
                intento1.putExtra("usuario", user);
                intento1.putExtra("contrasena", contrasena);
                intento1.putExtra("correo", correo);
                startActivity(intento1);
                finish();
                break;
            case R.id.mPromo_Frag:
                Intent intent=new Intent(this,OfertasActivity.class);
                intent.putExtra("usuario", user);
                intent.putExtra("contrasena", contrasena);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}




