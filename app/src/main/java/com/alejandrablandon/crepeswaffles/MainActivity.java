package com.alejandrablandon.crepeswaffles;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
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

public class MainActivity extends AppCompatActivity {

    //final String[] productos = new String[]{"Hamburguesa","PErro","Chuzos","Jugos"};

    private Productos[] productos=
            new Productos[]{
                    new Productos("","",100,R.drawable.cono1),
                    //new Productos("","",100,R.drawable.desayuno1),
                    new Productos("","",100,R.drawable.desayuno2),
                    new Productos("","",100,R.drawable.desayuno3)
            };
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    class Adapter extends ArrayAdapter<Productos>{
        public Adapter(Context context, Productos[] productos) {
            super(context, R.layout.layout_item1,productos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater= LayoutInflater.from(getContext());
            View item=inflater.inflate(R.layout.layout_item1, null);

            ImageView imagen=(ImageView)item.findViewById(R.id.imagen1);
            imagen.setImageResource(productos[position].getIdImage());

            TextView tPrecio=(TextView)item.findViewById(R.id.precio1);
            tPrecio.setText(String.valueOf(productos[position].getPrecio()));

            TextView tNombre=(TextView)item.findViewById(R.id.nombre1);
            tNombre.setText(productos[position].getNombre());

            TextView tDescripcion=(TextView)item.findViewById(R.id.descripcion1);
            tDescripcion.setText(productos[position].getDescripcion());

            return (item);

        }
    }

}
