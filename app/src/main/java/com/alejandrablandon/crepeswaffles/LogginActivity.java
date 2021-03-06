package com.alejandrablandon.crepeswaffles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogginActivity extends AppCompatActivity {

    EditText eName,eContraseña;
    Button bAceptar,bRegistro;
    String user,contrasena,correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        eName=(EditText)findViewById(R.id.eName);
        eContraseña=(EditText)findViewById(R.id.eContraseña);
        bAceptar=(Button)findViewById(R.id.bAcepto);
        bRegistro=(Button)findViewById(R.id.bRegistro);

        bAceptar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (eName.length() == 0) {
                    eName.setText("");
                    eContraseña.setText("");
                    Toast.makeText(getApplicationContext(), "Falta ingresar el nombre", Toast.LENGTH_LONG).show();
                } else if (eContraseña.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Falta ingresar la contrasena", Toast.LENGTH_LONG).show();
                } else if ((eName.getText().toString()).equals(user)==true && (eContraseña.getText().toString()).equals(contrasena)){
                    Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_LONG).show();
                    Intent intento=new Intent(getApplicationContext(),ProductosActivity.class);
                    intento.putExtra("usuario", user);
                    intento.putExtra("contrasena", contrasena);
                    intento.putExtra("correo", correo);
                    startActivity(intento);
                } else{
                    Toast.makeText(getApplicationContext(), "Falta registrarse o datos erróneos", Toast.LENGTH_LONG).show();
                }
            }
        });
        bRegistro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intento=new Intent(getApplicationContext(),RegistroActivity.class);
                startActivityForResult(intento,1234);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1234 && resultCode == RESULT_OK) {
            user = data.getExtras().getString("usuario");
            contrasena = data.getExtras().getString("contrasena");
            correo = data.getExtras().getString("correo");
            Log.d("user", user);
            Log.d("contraseña", contrasena);
            Log.d("correo",correo);
        }
        if (requestCode == 1234 && resultCode == RESULT_CANCELED) {
            Log.d("mensaje", "no se cargaron datos");
            Toast.makeText(this, "No se cargaron los datos",Toast.LENGTH_SHORT).show();
        }
    }
}
