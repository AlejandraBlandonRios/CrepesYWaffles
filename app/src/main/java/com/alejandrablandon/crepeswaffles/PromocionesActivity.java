package com.alejandrablandon.crepeswaffles;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

public class PromocionesActivity extends NavigationDraActivity {

    String user,contrasena,correo;
    String promo;
    ImageView imagen1,imagen2,imagen3,imagen4,imagen5,imagen6;
    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] opciones = new String[] {"Mi Perfil", "Momentos", "Sabores","Promociones"};

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.contenedorPrincipal);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intento = new Intent(PromocionesActivity.this, MainActivity.class);
            intento.putExtra("usuario", user);
            intento.putExtra("contrasena", contrasena);
            intento.putExtra("correo", correo);
            intento.putExtra("promo", promo);
            startActivity(intento);
            finish();
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.contenedorFrame); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_promociones, contentFrameLayout);

        imagen1=(ImageView)findViewById(R.id.iprimera);
        imagen2=(ImageView)findViewById(R.id.isegunda);
        imagen3=(ImageView)findViewById(R.id.itercera);
        imagen4=(ImageView)findViewById(R.id.icuarta);
        imagen5=(ImageView)findViewById(R.id.iquinta);
        imagen6=(ImageView)findViewById(R.id.isexta);

        Intent intent = new Intent();
        setResult(RESULT_OK, intent);

        user = getIntent().getExtras().getString("usuario");
        contrasena = getIntent().getExtras().getString("contrasena");
        correo = getIntent().getExtras().getString("correo");
        promo = getIntent().getExtras().getString("promo");

        drawerLayout = (DrawerLayout) findViewById(R.id.contenedorPrincipal);
        switch (promo){
            case "primero":
                imagen1.setVisibility(View.VISIBLE);
                imagen2.setVisibility(View.GONE);
                imagen3.setVisibility(View.GONE);
                imagen4.setVisibility(View.GONE);
                imagen5.setVisibility(View.GONE);
                imagen6.setVisibility(View.GONE);
                break;
            case "segundo":
                imagen1.setVisibility(View.GONE);
                imagen2.setVisibility(View.VISIBLE);
                imagen3.setVisibility(View.GONE);
                imagen4.setVisibility(View.GONE);
                imagen5.setVisibility(View.GONE);
                imagen6.setVisibility(View.GONE);
                break;
            case "tercero":
                imagen1.setVisibility(View.GONE);
                imagen2.setVisibility(View.GONE);
                imagen3.setVisibility(View.VISIBLE);
                imagen4.setVisibility(View.GONE);
                imagen5.setVisibility(View.GONE);
                imagen6.setVisibility(View.GONE);
                break;
            case "cuarto":
                imagen1.setVisibility(View.GONE);
                imagen2.setVisibility(View.GONE);
                imagen3.setVisibility(View.GONE);
                imagen4.setVisibility(View.VISIBLE);
                imagen5.setVisibility(View.GONE);
                imagen6.setVisibility(View.GONE);
                break;
            case "quinto":
                imagen1.setVisibility(View.GONE);
                imagen2.setVisibility(View.GONE);
                imagen3.setVisibility(View.GONE);
                imagen4.setVisibility(View.GONE);
                imagen5.setVisibility(View.VISIBLE);
                imagen6.setVisibility(View.GONE);
                break;
            case "sexto":
                imagen1.setVisibility(View.GONE);
                imagen2.setVisibility(View.GONE);
                imagen3.setVisibility(View.GONE);
                imagen4.setVisibility(View.GONE);
                imagen5.setVisibility(View.GONE);
                imagen6.setVisibility(View.VISIBLE);
                break;
        }


        drawerLayout = (DrawerLayout) findViewById(R.id.contenedorPrincipal);
        listView = (ListView) findViewById(R.id.menuIzq);

        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(),
                android.R.layout.simple_list_item_1, opciones));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case(0):
                        Intent intent=new Intent(PromocionesActivity.this,MiPerfilActivity.class);
                        intent.putExtra("usuario", user);
                        intent.putExtra("contrasena", contrasena);
                        intent.putExtra("correo", correo);
                        intent.putExtra("promo", promo);
                        startActivity(intent);
                        finish();
                        break;
                    case(1):
                        Intent intento1=new Intent(PromocionesActivity.this,MomentosActivity.class);
                        intento1.putExtra("usuario", user);
                        intento1.putExtra("contrasena", contrasena);
                        intento1.putExtra("correo", correo);
                        intento1.putExtra("promo", promo);
                        startActivity(intento1);
                        finish();
                        break;
                    case(2):
                        Intent intento=new Intent(PromocionesActivity.this,SaboresActivity.class);
                        intento.putExtra("usuario", user);
                        intento.putExtra("contrasena", contrasena);
                        intento.putExtra("correo", correo);
                        intento.putExtra("promo", promo);
                        startActivity(intento);
                        finish();
                        break;
                    case(3):
                        Intent intento2=new Intent(PromocionesActivity.this,SaboresActivity.class);
                        intento2.putExtra("usuario", user);
                        intento2.putExtra("contrasena", contrasena);
                        intento2.putExtra("correo", correo);
                        intento2.putExtra("promo", promo);
                        startActivity(intento2);
                        finish();
                        break;
                }
                listView.setItemChecked(i,true);
                drawerLayout.closeDrawer(listView);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.LEFT);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
