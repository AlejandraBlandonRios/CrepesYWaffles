package com.alejandrablandon.crepeswaffles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MiPerfil extends AppCompatActivity {

    String usuario,contrasena,correo;
    TextView tUsuario,tContrasena,tCorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil);

        tUsuario=(TextView)findViewById(R.id.tUsuario);
        tContrasena=(TextView)findViewById(R.id.tContrasena);
        tCorreo=(TextView)findViewById(R.id.tCorreo);

        usuario=getIntent().getExtras().getString("usuario");
        contrasena=getIntent().getExtras().getString("contrasena");
        correo=getIntent().getExtras().getString("correo");

        tUsuario.setText(usuario);
        tContrasena.setText(contrasena);
        tCorreo.setText(correo);
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

                break;
            case R.id.mPrincipal:
                Intent intent=new Intent(this,ProductosActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("contrasena", contrasena);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mOferta_Frag:
                Intent intento1=new Intent(this,FragmentosActivity.class);
                intento1.putExtra("usuario", usuario);
                intento1.putExtra("contrasena", contrasena);
                intento1.putExtra("correo", correo);
                startActivity(intento1);
                finish();
                break;
            case R.id.mPromo_Frag:
                Intent intento=new Intent(this,OfertasActivity.class);
                intento.putExtra("usuario", usuario);
                intento.putExtra("contrasena", contrasena);
                intento.putExtra("correo", correo);
                startActivity(intento);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}