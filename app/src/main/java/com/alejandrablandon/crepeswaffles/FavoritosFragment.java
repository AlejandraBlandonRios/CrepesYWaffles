package com.alejandrablandon.crepeswaffles;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritosFragment extends Fragment {

    LinearLayout primero,segundo,tercero,cuarto,quinto,sexto;
    View myView;

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

        primero.setVisibility(View.VISIBLE);
        segundo.setVisibility(View.GONE);
        tercero.setVisibility(View.GONE);
        cuarto.setVisibility(View.GONE);
        quinto.setVisibility(View.GONE);
        sexto.setVisibility(View.VISIBLE);

        // Inflate the layout for this fragment
        return myView;
    }

}

