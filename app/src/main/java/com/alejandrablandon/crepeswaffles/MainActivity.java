package com.alejandrablandon.crepeswaffles;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentContainer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends NavigationDraActivity{

    String user,contrasena,correo;
    String promo;
    private String[] opciones = new String[] {"Mi Perfil", "Momentos", "Sabores","Promociones"};
    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle drawerToggle;
    private Productos[] productos=
            new Productos[]{
                    new Productos("Crepe de Roastbeef","Para los amantes de la carne",5500,R.drawable.almuerzo2),
                    new Productos("Bowl de Açaí","Nuevos sabores en la mañana",6700,R.drawable.desayuno1),
                    new Productos("Helado Tiramisú","La hora del helado",7200,R.drawable.helado1),
                    new Productos("Salmón Roll","Disfruta dle mar",5800,R.drawable.sal1),
                    new Productos("Waffles NUTELLA y Banano","Una dulce promoción",6900,R.drawable.dulce1),
                    new Productos("Choco NUTELLA","La hora del chocolate",7100,R.drawable.bebida1)
            };
    ListView list;

    SharedPreferences preferencias;
    String preferencia1,preferencia2,preferencia3,cerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.contenedorFrame); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_main, contentFrameLayout);

        Intent intent = new Intent();
        setResult(RESULT_OK, intent);

        user = getIntent().getExtras().getString("usuario");
        contrasena = getIntent().getExtras().getString("contrasena");
        correo = getIntent().getExtras().getString("correo");
        promo = getIntent().getExtras().getString("promo");

        preferencias = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        preferencia1=preferencias.getString("usuario","");
        Toast.makeText(getApplicationContext(), preferencia1, Toast.LENGTH_LONG).show();

        drawerLayout = (DrawerLayout) findViewById(R.id.contenedorPrincipal);

        //Para el menu de la izquierda (NAvigation)
        listView = (ListView) findViewById(R.id.menuIzq);
        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(),
                android.R.layout.simple_list_item_1, opciones));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case(0):
                        Intent intent=new Intent(MainActivity.this,MiPerfilActivity.class);
                        intent.putExtra("usuario", user);
                        intent.putExtra("contrasena", contrasena);
                        intent.putExtra("correo", correo);
                        intent.putExtra("promo", promo);
                        startActivity(intent);
                        finish();
                        break;
                    case(1):
                        Intent intento1=new Intent(MainActivity.this,MomentosActivity.class);
                        intento1.putExtra("usuario", user);
                        intento1.putExtra("contrasena", contrasena);
                        intento1.putExtra("correo", correo);
                        intento1.putExtra("promo", promo);
                        startActivity(intento1);
                        finish();
                        break;
                    case(2):
                        Intent intento=new Intent(MainActivity.this,SaboresActivity.class);
                        intento.putExtra("usuario", user);
                        intento.putExtra("contrasena", contrasena);
                        intento.putExtra("correo", correo);
                        intento.putExtra("promo", promo);
                        startActivity(intento);
                        finish();
                        break;
                    case(3):
                        break;
                }
                listView.setItemChecked(i,true);
                drawerLayout.closeDrawer(listView);
            }
        });

        //Para la lista de promociones
        Adapter adaptador=new Adapter(this, productos);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case(0):
                        promo= "primero";
                        Intent intent=new Intent(MainActivity.this,PromocionesActivity.class);
                        intent.putExtra("usuario", user);
                        intent.putExtra("contrasena", contrasena);
                        intent.putExtra("correo", correo);
                        intent.putExtra("promo", promo);
                        startActivity(intent);
                        finish();
                        break;
                    case(1):
                        promo= "segundo";
                        Intent intento1=new Intent(MainActivity.this,PromocionesActivity.class);
                        intento1.putExtra("usuario", user);
                        intento1.putExtra("contrasena", contrasena);
                        intento1.putExtra("correo", correo);
                        intento1.putExtra("promo", promo);
                        startActivity(intento1);
                        finish();
                        break;
                    case(2):
                        promo= "tercero";
                        Intent intento=new Intent(MainActivity.this,PromocionesActivity.class);
                        intento.putExtra("usuario", user);
                        intento.putExtra("contrasena", contrasena);
                        intento.putExtra("correo", correo);
                        intento.putExtra("promo", promo);
                        startActivity(intento);
                        finish();
                        break;
                    case(3):
                        promo= "cuarto";
                        Intent intento2=new Intent(MainActivity.this,PromocionesActivity.class);
                        intento2.putExtra("usuario", user);
                        intento2.putExtra("contrasena", contrasena);
                        intento2.putExtra("correo", correo);
                        intento2.putExtra("promo", promo);
                        startActivity(intento2);
                        finish();
                        break;
                    case (4):
                        promo= "quinto";
                        Intent intento3=new Intent(MainActivity.this,PromocionesActivity.class);
                        intento3.putExtra("usuario", user);
                        intento3.putExtra("contrasena", contrasena);
                        intento3.putExtra("correo", correo);
                        intento3.putExtra("promo", promo);
                        startActivity(intento3);
                        finish();
                        break;
                    case (5):
                        promo= "sexto";
                        Intent intento4=new Intent(MainActivity.this,PromocionesActivity.class);
                        intento4.putExtra("usuario", user);
                        intento4.putExtra("contrasena", contrasena);
                        intento4.putExtra("correo", correo);
                        intento4.putExtra("promo", promo);
                        startActivity(intento4);
                        finish();
                        break;
                }
                listView.setItemChecked(i,true);
                drawerLayout.closeDrawer(listView);
            }
        });

        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.abierto, R.string.cerrado){
            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

        };

        drawerLayout.setDrawerListener(drawerToggle);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.contenedorPrincipal);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.LEFT);
                return true;
            case R.id.mCerrar:
                SharedPreferences preferencias= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor= preferencias.edit();
                editor.putString("cerrar", "si");
                editor.commit();
                Intent intento2=new Intent(this,LogginActivity.class);
                intento2.putExtra("usuario", user);
                intento2.putExtra("contrasena", contrasena);
                intento2.putExtra("correo", correo);
                startActivity(intento2);
                finish();
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