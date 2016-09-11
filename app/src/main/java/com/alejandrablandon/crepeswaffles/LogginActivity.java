package com.alejandrablandon.crepeswaffles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogginActivity extends AppCompatActivity {

    EditText eName,eContraseña;
    Button bAceptar,bRegistro;
    int banderita;
    String user,contrasena;

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
                    Toast.makeText(getApplicationContext(), "Falta ingresar el correo", Toast.LENGTH_LONG).show();
                } else if ((eName.getText().toString()).equals(user)==true){
                    Toast.makeText(getApplicationContext(), "Hola", Toast.LENGTH_LONG).show();
                    Intent intento=new Intent(getApplicationContext(),MainActivity.class);
                    startActivityForResult(intento,123);
                } else{
                    Toast.makeText(getApplicationContext(), "Falta registrarse", Toast.LENGTH_LONG).show();
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
            //Log.d("user", user);
            //Log.d("contraseña", contrasena);
            Toast.makeText(this, "user: "+user+" contraseña: "+contrasena,Toast.LENGTH_SHORT).show();
        }
        if (requestCode == 1234 && resultCode == RESULT_CANCELED) {
            //Log.d("mensaje", "no se cargaron datos");
            Toast.makeText(this, "No se cargaron los datos",Toast.LENGTH_SHORT).show();
        }
    }
}
