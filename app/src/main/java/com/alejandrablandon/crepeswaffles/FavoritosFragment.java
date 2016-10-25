package com.alejandrablandon.crepeswaffles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritosFragment extends Fragment {

    LinearLayout primero,segundo,tercero,cuarto,quinto,sexto;
    View myView;
    SharedPreferences preferencias;
    String preferencia1,verpreferencia;
    //Base de datos
    FavoritosSQLiteHelper Favoritos;
    SQLiteDatabase Favoritosdb;
    String producto1;

    public FavoritosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.fragment_favoritos, container, false);
        primero=(LinearLayout)myView.findViewById(R.id.primero);
        segundo=(LinearLayout)myView.findViewById(R.id.segundo);
        tercero=(LinearLayout)myView.findViewById(R.id.tercero);
        cuarto=(LinearLayout)myView.findViewById(R.id.cuarto);
        quinto=(LinearLayout)myView.findViewById(R.id.quinto);
        sexto=(LinearLayout)myView.findViewById(R.id.sexto);

        //Base de datos
        Favoritos = new FavoritosSQLiteHelper(getContext(),"FavoritosDB",null,1);
        Favoritosdb = Favoritos.getWritableDatabase();

        preferencias = PreferenceManager.getDefaultSharedPreferences(getActivity());
        preferencia1=preferencias.getString("usuario","");
        verpreferencia=preferencias.getString("verfavorito","");

        Cursor c3=Favoritosdb.query("Favoritos",null,"idUsuario='"+preferencia1+"'",null,null,null,null);
        if(c3.moveToFirst()){
            do {
                producto1 = c3.getString(c3.getColumnIndex("idProducto"));

                switch (producto1){
                    case "Crepe de Roastbeef":
                        primero.setVisibility(View.VISIBLE);
                        break;
                    case "Bowl de Açaí":
                        segundo.setVisibility(View.VISIBLE);
                        break;
                    case "Helado Tiramisú":
                        tercero.setVisibility(View.VISIBLE);
                        break;
                    case "Salmón Roll":
                        cuarto.setVisibility(View.VISIBLE);
                        break;
                    case "Waffles NUTELLA y Banano":
                        quinto.setVisibility(View.VISIBLE);
                        break;
                    case "Choco NUTELLA":
                        sexto.setVisibility(View.VISIBLE);
                        break;
                }
                c3.moveToNext();
            }while (c3.moveToNext());
        }
        // Inflate the layout for this fragment
        return myView;
    }

}

