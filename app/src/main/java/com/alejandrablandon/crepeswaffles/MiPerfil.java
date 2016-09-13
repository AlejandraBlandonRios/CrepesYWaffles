package com.alejandrablandon.crepeswaffles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MiPerfil extends AppCompatActivity {

    String usuario1,contrasena1,correo1;
    TextView tUsuario,tContrasena,tCorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil);

        tUsuario=(TextView)findViewById(R.id.tUsuario);
        tContrasena=(TextView)findViewById(R.id.tContrasena);
        tCorreo=(TextView)findViewById(R.id.tCorreo);

        usuario1=getIntent().getExtras().getString("usuario1");
        contrasena1=getIntent().getExtras().getString("contrasena1");
        correo1=getIntent().getExtras().getString("correo1");

        tUsuario.setText(usuario1);
        tContrasena.setText(contrasena1);
        tCorreo.setText(correo1);
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
                Intent intent=new Intent(this,MainActivity.class);
                intent.putExtra("usuario", usuario1);
                intent.putExtra("contrasena", contrasena1);
                intent.putExtra("correo", correo1);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
