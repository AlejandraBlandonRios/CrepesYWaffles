package com.alejandrablandon.crepeswaffles;

import android.content.Intent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import layout.LogoFragment;

public class FragmentosActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    String user,contrasena,correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentos);

        user = getIntent().getExtras().getString("usuario");
        contrasena = getIntent().getExtras().getString("contrasena");
        correo = getIntent().getExtras().getString("correo");


        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pag_fragmentos);
        mViewPager.setAdapter(pagerAdapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tabListener = new ActionBar.TabListener(){
            @Override
            public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
                mViewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }
        };
        ActionBar.Tab tab = actionBar.newTab().setText(R.string.Almuerzo1).setTabListener(tabListener);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText(R.string.Desayuno1).setTabListener(tabListener);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText(R.string.Helado1).setTabListener(tabListener);
        actionBar.addTab(tab);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);
            }
        });
    }
    public class PagerAdapter extends FragmentPagerAdapter{
        public PagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new LogoFragment();
                case 1: return new Producto1Fragment();
                case 2: return new BebidasFragment();
                default: return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.mMiperfil:
                Intent intent = new Intent(this, MiPerfil.class);
                intent.putExtra("usuario", user);
                intent.putExtra("contrasena", contrasena);
                intent.putExtra("correo", correo);
                startActivity(intent);
                break;
            case R.id.mPrincipal:
                Intent intento1=new Intent(this,ProductosActivity.class);
                intento1.putExtra("usuario", user);
                intento1.putExtra("contrasena", contrasena);
                intento1.putExtra("correo", correo);
                startActivity(intento1);
                finish();
                break;
            case R.id.mOferta_Frag:
                break;
            case R.id.mPromo_Frag:
                Intent intento=new Intent(this,OfertasActivity.class);
                intento.putExtra("usuario", user);
                intento.putExtra("contrasena", contrasena);
                intento.putExtra("correo", correo);
                startActivity(intento);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}