package com.alejandrablandon.crepeswaffles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MiPerfil extends AppCompatActivity {

    String resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
        Bundle extras=getIntent().getExtras();
        resultado=(String)extras.get("nombre");
        //tName.setText(extras.getString("Nombre:"));
        //Intent intent=new Intent(this,MainActivity.class);
        //eName.setText(resultado);
        //startActivity(intent);
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

                break;
            case R.id.mPrincipal:
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
