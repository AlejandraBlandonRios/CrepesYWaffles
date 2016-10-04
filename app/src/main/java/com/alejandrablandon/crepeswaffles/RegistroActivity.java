package com.alejandrablandon.crepeswaffles;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    EditText eNombre, eContraseña1, eContraseña2, eCorreo;
    Button bAceptar,bCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eNombre=(EditText)findViewById(R.id.eNombre);
        eContraseña1=(EditText)findViewById(R.id.eContraseña1);
        eContraseña2=(EditText)findViewById(R.id.eContraseña2);
        eCorreo=(EditText)findViewById(R.id.eCorreo);
        bAceptar=(Button)findViewById(R.id.bAceptar);
        bCancelar=(Button)findViewById(R.id.bCancelar);

        bAceptar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(eNombre.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Falta ingresar el nombre", Toast.LENGTH_LONG).show();
                } else if(eContraseña1.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Falta ingresar la contraseña", Toast.LENGTH_LONG).show();
                } else if(eContraseña2.length() == 0){
                    Toast.makeText(getApplicationContext(), "Falta confirmar la contraseña", Toast.LENGTH_LONG).show();
                }else if((eContraseña1.getText().toString()).equals(eContraseña2.getText().toString())!=true){
                    Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("usuario", eNombre.getText().toString());
                    intent.putExtra("contrasena", eContraseña1.getText().toString());
                    intent.putExtra("correo",eCorreo.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

}
