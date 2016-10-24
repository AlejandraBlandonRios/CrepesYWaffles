package com.alejandrablandon.crepeswaffles;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MiPerfilFragment extends Fragment {
    TextView tUsuario,tContrasena,tCorreo;
    SharedPreferences preferencias;
    String preferencia1,preferencia2,preferencia3;

    public MiPerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_mi_perfil, container, false);
        tUsuario = (TextView)myView.findViewById(R.id.tUsuario);
        tContrasena=(TextView)myView.findViewById(R.id.tContrasena);
        tCorreo=(TextView)myView.findViewById(R.id.tCorreo);

        //preferencias = this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);

        preferencias = PreferenceManager.getDefaultSharedPreferences(getActivity());
        preferencia1=preferencias.getString("usuario","");
        preferencia2=preferencias.getString("contrasena","");
        preferencia3=preferencias.getString("correo","");
        Toast.makeText(getContext(), preferencia3, Toast.LENGTH_LONG).show();

        tUsuario.setText(preferencia1);
        tContrasena.setText(preferencia2);
        tCorreo.setText(preferencia3);
        // Inflate the layout for this fragment
        return myView;
    }

}
