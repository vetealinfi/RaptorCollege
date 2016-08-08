package com.codebake.raptor.raptorcollege.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.codebake.raptor.raptorcollege.R;

import Modelo.ColegioTransporte;

/**
 * Created by CTN Developer on 01-08-2016.
 */
public class TabFragment1 extends Fragment implements View.OnClickListener{
    //private IFragmentToActivity mCallback;
    ColegioTransporte colegioTransporte;
    ViewPager viewPager;
    Spinner spinnerTipoColegio;
    Spinner spinnerOrientacionReligiosa;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_fragment_1, container,
                false);
        spinnerTipoColegio = (Spinner) view.findViewById(R.id.spinnerTipoColegio);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.tiposColegio, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoColegio.setAdapter(adapter);

        spinnerTipoColegio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Your code here
                if(i!=0) {
                    int duration = Toast.LENGTH_SHORT;
                    String text = "elemento seleccionado -->" + i;
                    Toast toast = Toast.makeText(getContext(), text, duration);
                    toast.show();
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        spinnerOrientacionReligiosa = (Spinner) view.findViewById(R.id.spinnerOrientacionReligiosa);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.orientacionReligiosa, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOrientacionReligiosa.setAdapter(adapter2);

        Button botonBuscar = (Button) view.findViewById(R.id.btn_search);
        botonBuscar.setOnClickListener(this);



        return view;
    }

    public static final TabFragment1 newInstance(ViewPager viewPager,ColegioTransporte colegioTransporte){
        TabFragment1 f = new TabFragment1();
        Log.d("test", "creoooooooo" );
        f.viewPager=viewPager;
        f.colegioTransporte=colegioTransporte;
        return f;
    }



    @Override
    public void onClick(View view) {
        int duration = Toast.LENGTH_SHORT;
        String text = "elemento seleccionado -->"+spinnerTipoColegio.getSelectedItemId();


        Toast toast = Toast.makeText(getContext(), text, duration);
        toast.show();
        this.viewPager.setCurrentItem(1);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);




    }
}