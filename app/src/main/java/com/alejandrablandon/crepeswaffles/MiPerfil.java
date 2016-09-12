package com.alejandrablandon.crepeswaffles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MiPerfil extends AppCompatActivity {

    String usuario1,contrasena1,correo1;
    TextView tUsuario,tContrasena,tCorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil);

        Intent intent = new Intent();
        setResult(RESULT_OK, intent);

        tUsuario=(TextView)findViewById(R.id.tUsuario);
        tContrasena=(TextView)findViewById(R.id.tContrasena);
        tCorreo=(TextView)findViewById(R.id.tCorreo);

        usuario1=getIntent().getExtras().getString("usuario1");
        contrasena1=getIntent().getExtras().getString("contrasena1");
        correo1=getIntent().getExtras().getString("correo1");

        tUsuario.setText(usuario1);
        tContrasena.setText(contrasena1);
        tCorreo.setText(correo1);
        //Intent intent = new Intent();
        //setResult(RESULT_OK, intent);
        //finish();
        //Bundle extras=getIntent().getExtras();
        //resultado=(String)extras.get("nombre");
        //tName.setText(extras.getString("Nombre:"));
        //Intent intent=new Intent(this,MainActivity.class);
        //eName.setText(resultado);
        //startActivity(intent);
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
                //Intent intent = new Intent();
                //setResult(RESULT_OK, intent);
                //finish();
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
