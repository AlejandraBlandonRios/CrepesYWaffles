package com.alejandrablandon.crepeswaffles;


import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class NavigationDraActivity extends AppCompatActivity {

    private String[] opciones = new String[] {"Mi Perfil", "Momentos", "Sabores","Promociones"};
    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle drawerToggle;
    String user,contrasena,correo;
    String promo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_dra);

        Intent intent = new Intent();
        setResult(RESULT_OK, intent);

        user = getIntent().getExtras().getString("usuario");
        contrasena = getIntent().getExtras().getString("contrasena");
        correo = getIntent().getExtras().getString("correo");
        promo = getIntent().getExtras().getString("promo");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
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
                        Intent intent=new Intent(NavigationDraActivity.this,MiPerfilActivity.class);
                        intent.putExtra("usuario", user);
                        intent.putExtra("contrasena", contrasena);
                        intent.putExtra("correo", correo);
                        intent.putExtra("promo", promo);
                        startActivity(intent);
                        finish();
                        break;
                    case(1):
                        Intent intento1=new Intent(NavigationDraActivity.this,MomentosActivity.class);
                        intento1.putExtra("usuario", user);
                        intento1.putExtra("contrasena", contrasena);
                        intento1.putExtra("correo", correo);
                        intento1.putExtra("promo", promo);
                        startActivity(intento1);
                        finish();
                        break;
                    case(2):
                        Intent intento=new Intent(NavigationDraActivity.this,SaboresActivity.class);
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

        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.abierto, R.string.cerrado);

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
            case R.id.mCerrar:
                SharedPreferences preferencias= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor= preferencias.edit();
                editor.putString("cerrar", "si");
                editor.commit();
                Intent intento3=new Intent(this,LogginActivity.class);
                intento3.putExtra("usuario", user);
                intento3.putExtra("contrasena", contrasena);
                intento3.putExtra("correo", correo);
                startActivity(intento3);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}
