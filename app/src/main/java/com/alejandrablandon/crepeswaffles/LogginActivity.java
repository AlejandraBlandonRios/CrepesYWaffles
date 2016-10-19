package com.alejandrablandon.crepeswaffles;

import android.content.ContentValues;
import android.database.Cursor;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
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
    SharedPreferences preferencias;
    String preferencia1,preferencia2,preferencia3,cerrar;

    //Base de datos
    ContactosSQLiteHelper Contactos;
    ContentValues dataBD;
    SQLiteDatabase dbContactos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        //Base de datos
        Contactos = new ContactosSQLiteHelper(this,"ContactosDB",null,1);
        dbContactos = Contactos.getWritableDatabase();

        eName=(EditText)findViewById(R.id.eName);
        eContraseña=(EditText)findViewById(R.id.eContraseña);
        bAceptar=(Button)findViewById(R.id.bAcepto);
        bRegistro=(Button)findViewById(R.id.bRegistro);

        preferencias = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        preferencia1=preferencias.getString("usuario","");
        preferencia2=preferencias.getString("contrasena","");
        preferencia3=preferencias.getString("correo","");
        cerrar=preferencias.getString("cerrar","");
        Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();

        if(preferencia1.length()==0 && cerrar=="no") {
            bAceptar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    //Base de datos
                    Cursor c=dbContactos.query("Contactos",null, "Nombre='"+eName.getText().toString()+"'", null,null,null,null);
                    if(c.moveToFirst()){
                        do {
                            preferencia1 = c.getString(c.getColumnIndex("Nombre"));
                            preferencia2 = c.getString(c.getColumnIndex("Telefono"));
                            preferencia3 = c.getString(c.getColumnIndex("Correo"));
                            user = preferencia1;
                            contrasena = preferencia2;
                            correo = preferencia3;
                            //Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();
                            c.moveToNext();
                        }while (c.moveToNext());
                    }
                    //Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();
                    if (eName.length() == 0) {
                        eName.setText("");
                        eContraseña.setText("");
                        Toast.makeText(getApplicationContext(), "Falta ingresar el nombre", Toast.LENGTH_LONG).show();
                    } else if (eContraseña.length() == 0) {
                        Toast.makeText(getApplicationContext(), "Falta ingresar la contrasena", Toast.LENGTH_LONG).show();
                    } else if ((eName.getText().toString()).equals(preferencia1) == true && (eContraseña.getText().toString()).equals(preferencia2)) {
                        SharedPreferences preferencias=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor editor= preferencias.edit();
                        editor.putString("usuario",  user);
                        editor.putString("contrasena", contrasena);
                        editor.putString("correo", correo);
                        editor.putString("cerrar","no");
                        //Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();
                        editor.commit();
                        Intent intento = new Intent(getApplicationContext(), MainActivity.class);
                        intento.putExtra("usuario", user);
                        intento.putExtra("contrasena", contrasena);
                        intento.putExtra("correo", correo);
                        startActivity(intento);
                        Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Falta registrarse o datos erróneos", Toast.LENGTH_LONG).show();
                    }
                }
            });
            bRegistro.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intento = new Intent(getApplicationContext(), RegistroActivity.class);
                    startActivityForResult(intento, 1234);
                }
            });
        } else if(preferencia1.length()!=0 && cerrar=="no"){
            //Base de datos
            Cursor c=dbContactos.query("Contactos",null, "Nombre='"+eName.getText().toString()+"'", null,null,null,null);
            //Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();
            if(c.moveToFirst()){
                preferencia1 = c.getString(c.getColumnIndex("Nombre"));
                preferencia2 = c.getString(c.getColumnIndex("Telefono"));
                preferencia3 = c.getString(c.getColumnIndex("Correo"));
                user=preferencia1;
                contrasena=preferencia2;
                correo=preferencia3;
                //Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();
                c.moveToNext();
                //correo=c.getString(3);
            }
            Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();
            Intent intento2=new Intent(this,MainActivity.class);
            intento2.putExtra("usuario", user);
            intento2.putExtra("contrasena", contrasena);
            intento2.putExtra("correo", correo);
            startActivity(intento2);
            Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();
            finish();
        } else if(preferencia1.length()!=0 && cerrar=="si"){
            bAceptar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    //Base de datos
                    Cursor c=dbContactos.query("Contactos",null, "Nombre='"+eName.getText().toString()+"'", null,null,null,null);
                    if(c.moveToFirst()){
                        do {
                            preferencia1 = c.getString(c.getColumnIndex("Nombre"));
                            preferencia2 = c.getString(c.getColumnIndex("Telefono"));
                            preferencia3 = c.getString(c.getColumnIndex("Correo"));
                            user = preferencia1;
                            contrasena = preferencia2;
                            correo = preferencia3;
                            //Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();
                            c.moveToNext();
                        }while (c.moveToNext());
                    }
                    Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();
                    if (eName.length() == 0) {
                        eName.setText("");
                        eContraseña.setText("");
                        Toast.makeText(getApplicationContext(), "Falta ingresar el nombre", Toast.LENGTH_LONG).show();
                    } else if (eContraseña.length() == 0) {
                        Toast.makeText(getApplicationContext(), "Falta ingresar la contrasena", Toast.LENGTH_LONG).show();
                    } else if ((eName.getText().toString()).equals(preferencia1) == true && (eContraseña.getText().toString()).equals(preferencia2)) {
                        SharedPreferences preferencias=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor editor= preferencias.edit();
                        editor.putString("usuario",  user);
                        editor.putString("contrasena", contrasena);
                        editor.putString("correo", correo);
                        editor.putString("cerrar","no");
                        //Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();
                        editor.commit();
                        Intent intento = new Intent(getApplicationContext(), MainActivity.class);
                        intento.putExtra("usuario", user);
                        intento.putExtra("contrasena", contrasena);
                        intento.putExtra("correo", correo);
                        startActivity(intento);
                        Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Falta registrarse o datos erróneos", Toast.LENGTH_LONG).show();
                    }
                }
            });
            bRegistro.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intento = new Intent(getApplicationContext(), RegistroActivity.class);
                    startActivityForResult(intento, 1234);
                }
            });
        }else{
            bAceptar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    //Base de datos
                    Cursor c=dbContactos.query("Contactos",null, "Nombre='"+eName.getText().toString()+"'", null,null,null,null);
                    if(c.moveToFirst()){
                        do {
                            preferencia1 = c.getString(c.getColumnIndex("Nombre"));
                            preferencia2 = c.getString(c.getColumnIndex("Telefono"));
                            preferencia3 = c.getString(c.getColumnIndex("Correo"));
                            user = preferencia1;
                            contrasena = preferencia2;
                            correo = preferencia3;
                            //Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();
                            c.moveToNext();
                        }while (c.moveToNext());
                    }
                    Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();
                    if (eName.length() == 0) {
                        eName.setText("");
                        eContraseña.setText("");
                        Toast.makeText(getApplicationContext(), "Falta ingresar el nombre", Toast.LENGTH_LONG).show();
                    } else if (eContraseña.length() == 0) {
                        Toast.makeText(getApplicationContext(), "Falta ingresar la contrasena", Toast.LENGTH_LONG).show();
                    } else if ((eName.getText().toString()).equals(preferencia1) == true && (eContraseña.getText().toString()).equals(preferencia2)) {
                        SharedPreferences preferencias=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor editor= preferencias.edit();
                        editor.putString("usuario",  user);
                        editor.putString("contrasena", contrasena);
                        editor.putString("correo", correo);
                        editor.putString("cerrar","no");
                        //Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();
                        editor.commit();

                        Intent intento = new Intent(getApplicationContext(), MainActivity.class);
                        intento.putExtra("usuario", user);
                        intento.putExtra("contrasena", contrasena);
                        intento.putExtra("correo", correo);
                        startActivity(intento);
                        Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Falta registrarse o datos erróneos", Toast.LENGTH_LONG).show();
                    }
                }
            });
            bRegistro.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intento = new Intent(getApplicationContext(), RegistroActivity.class);
                    startActivityForResult(intento, 1234);
                }
            });
        }

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
            //Base de datos
            Cursor c=dbContactos.query("Contactos",null, "Nombre='"+eName.getText().toString()+"'", null,null,null,null);
            if(c.moveToFirst()){
                do {
                    preferencia1 = c.getString(c.getColumnIndex("Nombre"));
                    preferencia2 = c.getString(c.getColumnIndex("Telefono"));
                    preferencia3 = c.getString(c.getColumnIndex("Correo"));
                    user = preferencia1;
                    contrasena = preferencia2;
                    correo = preferencia3;
                    //Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();
                    c.moveToNext();
                }while (c.moveToNext());
            }
            Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();
            SharedPreferences preferencias=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor= preferencias.edit();
            editor.putString("usuario",  user);
            editor.putString("contrasena", contrasena);
            editor.putString("correo", correo);
            editor.putString("cerrar","no");
            //Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();
            editor.commit();
            preferencias = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

            preferencia1=preferencias.getString("usuario","");
            preferencia2=preferencias.getString("contrasena","");
            preferencia3=preferencias.getString("correo","");
            cerrar=preferencias.getString("cerrar","");

        }
        if (requestCode == 1234 && resultCode == RESULT_CANCELED) {
            Log.d("mensaje", "no se cargaron datos");
            Toast.makeText(this, "No se cargaron los datos",Toast.LENGTH_SHORT).show();
        }
    }

}