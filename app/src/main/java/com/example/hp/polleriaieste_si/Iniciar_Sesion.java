package com.example.hp.polleriaieste_si;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Iniciar_Sesion.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Iniciar_Sesion extends Fragment {

    private OnFragmentInteractionListener mListener;
    Comunicador comunicador;
    Button enviar;

    public Iniciar_Sesion() {
        // Required empty public constructor
    }

    public interface Comunicador {
        public void enviar(String envia);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_iniciar_sesion,container, false);
        enviar = (Button) v.findViewById(R.id.enviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Perfil perfil = new Perfil();
                FragmentManager fr = getActivity().getSupportFragmentManager();
                fr.beginTransaction().replace(R.id.sesion, perfil).commit();
                /*
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.sesion, perfil);
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.addToBackStack(null);
                transaction.commit();*/
                /*
                *FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
fragmentManager.beginTransaction().replace(R.id.flGeneros, new RecyclerViewGenerosFragmentView()).commit()
                * */
            }
        });
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        comunicador = (Comunicador) context;
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
