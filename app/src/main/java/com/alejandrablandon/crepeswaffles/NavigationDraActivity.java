package com.alejandrablandon.crepeswaffles;


import android.content.Intent;
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

    private String[] opciones = new String[] {"primero", "segundo", "tercero","cuarto"};
    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle drawerToggle;
    String user,contrasena,correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_dra);

        Intent intent = new Intent();
        setResult(RESULT_OK, intent);

        user = getIntent().getExtras().getString("usuario");
        contrasena = getIntent().getExtras().getString("contrasena");
        correo = getIntent().getExtras().getString("correo");

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
                Fragment fragment = null;
                switch (i){
                    case(0): fragment = new AlmuerzoFragment(); break;
                    case(1): fragment = new DesayunoFragment(); break;
                    case(2): fragment = new BebidaFragment(); break;
                    case(3):
                        Intent intento=new Intent(NavigationDraActivity.this,MiPerfilActivity.class);
                        intento.putExtra("usuario", user);
                        intento.putExtra("contrasena", contrasena);
                        intento.putExtra("correo", correo);
                        startActivity(intento);
                        finish();
                        break;
                }
                if (i != 3) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.contenedorFrame, fragment).commit();

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
            case R.id.mMiperfil:
                Intent intento=new Intent(this,MiPerfilActivity.class);
                intento.putExtra("usuario", user);
                intento.putExtra("contrasena", contrasena);
                intento.putExtra("correo", correo);
                startActivity(intento);
                finish();
                break;
            case R.id.mPrincipal:
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
                Intent intento2=new Intent(this,PromocionesActivity.class);
                intento2.putExtra("usuario", user);
                intento2.putExtra("contrasena", contrasena);
                intento2.putExtra("correo", correo);
                startActivity(intento2);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}