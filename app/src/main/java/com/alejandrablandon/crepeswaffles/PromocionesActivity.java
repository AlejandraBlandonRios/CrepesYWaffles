package com.alejandrablandon.crepeswaffles;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class PromocionesActivity extends AppCompatActivity {

    //final String[] productos = new String[]{"Hamburguesa","PErro","Chuzos","Jugos"};
    String user,contrasena,correo;
    private Productos[] productos=
            new Productos[]{
                    new Productos("Crepe de Roastbeef","Para los amantes de la carne",5000,R.drawable.almuerzo1),
                    new Productos("Bowl de Açaí","Nuevos sabores en la mañana",5000,R.drawable.desayuno1),
                    new Productos("Helado Tiramisú","La hora del helado",5000,R.drawable.helado1),
                    new Productos("Salmón Roll","Disfruta dle mar",5000,R.drawable.sal1),
                    new Productos("Waffles NUTELLA y Banano","Una dulce promoción",5000,R.drawable.dulce1),
                    new Productos("Choco NUTELLA","La hora del chocolate",5000,R.drawable.bebida1)
            };
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones);

        Intent intent = new Intent();
        setResult(RESULT_OK, intent);

        user = getIntent().getExtras().getString("usuario");
        contrasena = getIntent().getExtras().getString("contrasena");
        correo = getIntent().getExtras().getString("correo");

        //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,productos);

        Adapter adaptador=new Adapter(this, productos);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adaptador);


       /* list.setOnClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Presiono"+i, Toast.LENGTH_SHORT).show();
                String nombre=((Productos)AdapterView.getItemPosition(i)).getNombre();
            }
        });*/
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
                Intent intento=new Intent(this,MiPerfilActivity.class);
                intento.putExtra("usuario", user);
                intento.putExtra("contrasena", contrasena);
                intento.putExtra("correo", correo);
                startActivity(intento);
                finish();
                break;
            case R.id.mPrincipal:
                Intent intento2=new Intent(this,MainActivity.class);
                intento2.putExtra("usuario", user);
                intento2.putExtra("contrasena", contrasena);
                intento2.putExtra("correo", correo);
                startActivity(intento2);
                finish();
                break;
            case R.id.mOferta_Frag:
                Intent intento1=new Intent(this,MomentosActivity.class);
                intento1.putExtra("usuario", user);
                intento1.putExtra("contrasena", contrasena);
                intento1.putExtra("correo", correo);
                startActivity(intento1);
                finish();
                break;
            case R.id.mPromo_Frag:
                Intent intent=new Intent(this,SaboresActivity.class);
                intent.putExtra("usuario", user);
                intent.putExtra("contrasena", contrasena);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mPromociones_Frag:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    class Adapter extends ArrayAdapter<Productos> {
        public Adapter(Context context, Productos[] productos) {
            super(context, R.layout.layout_item1, productos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.layout_item1, null);

            ImageView imagen = (ImageView) item.findViewById(R.id.imagen1);
            imagen.setImageResource(productos[position].getIdImage());

            TextView tPrecio = (TextView) item.findViewById(R.id.precio1);
            tPrecio.setText(String.valueOf(productos[position].getPrecio()));

            TextView tNombre = (TextView) item.findViewById(R.id.nombre1);
            tNombre.setText(productos[position].getNombre());

            TextView tDescripcion = (TextView) item.findViewById(R.id.descripcion1);
            tDescripcion.setText(productos[position].getDescripcion());
            return (item);

        }
    }

}
