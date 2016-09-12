package com.alejandrablandon.crepeswaffles;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import layout.LogoFragment;

public class MainActivity extends AppCompatActivity {

    //private ViewPager;
    String user,contrasena,correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = new Intent();
        setResult(RESULT_OK, intent);

        user=getIntent().getExtras().getString("usuario");
        contrasena=getIntent().getExtras().getString("contrasena");
        correo=getIntent().getExtras().getString("correo");
        Toast.makeText(this, "Ingreso a main pero sin perfil"+user+contrasena+correo,Toast.LENGTH_SHORT).show();


        // FragmentManager logo=new getFragmentManager();
        //LogoFragment logoFragment=new LogoFragment();
        //FragmentAdapter fragmentAdapter=new PagerAdapter(getSupportFragment);
        //PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        //mViewPager = (ViewPager) findViewById(R.id.pager);
        //mViewPager.setAdapter(pagerAdapter);
    }
        /*public class PagerAdapter extends FragmentPagerAdapter {
            public PageAdapter(android.support.v4.app.FragmentManager fm) {
                super(fm);
            }
            public Fragment getItem(int position){
                switch(position){
                    case 1:
                        return new LogoFragment();
                    case 2:
                        return new Producto1Fragment();
                    case 3:
                        break;

                }
            }
        }
*/


       /* bAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento=new Intent(getApplicationContext(),LogginActivity.class);
                startActivity(intento);
            }
        });*/



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        //FragmentManager fm=getfragmentManager();
        //FragmentTransaction ft=fm.beginTransaction();
        switch (id){
            case R.id.mMiperfil:
                //Intent intent = new Intent();
                //setResult(RESULT_OK, intent);
                //finish();
                /*Intent intent = new Intent();
                intent.putExtra("usuario", eNombre.getText().toString());
                intent.putExtra("contrasena", eContraseña1.getText().toString());
                intent.putExtra("correo",eCorreo.getText().toString());
                setResult(RESULT_OK, intent);
                finish();*/
                //setResult(RESULT_OK, intent);
                //finish();
                Toast.makeText(this, "Ingreso a mi perfil"+user,Toast.LENGTH_SHORT).show();
                Intent intento=new Intent(this,MiPerfil.class);
                //startActivity(intento);
                //startActivityForResult(intento,12345);
                intento.putExtra("usuario1", user);
                intento.putExtra("contrasena1", contrasena);
                intento.putExtra("correo1", correo);
                startActivity(intento);
                finish();
                break;
            case R.id.mPrincipal:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
