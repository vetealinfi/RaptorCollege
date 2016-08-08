package com.codebake.raptor.raptorcollege.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codebake.raptor.raptorcollege.R;
import com.codebake.raptor.raptorcollege.adapter.IFragmentToActivity;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import Modelo.Colegio;
import Modelo.ColegioTransporte;

/**
 * Created by CTN Developer on 01-08-2016.
 */
public class TabFragment3 extends Fragment implements OnMapReadyCallback,View.OnClickListener {

    MapView mapView;
    GoogleMap mGoogleMap;

    private TextView mTextView1;
    private TextView t2;
    private TextView t3;
    int colegioId;
    ColegioTransporte colegioTransporte;
    Colegio colegioActivo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("test", "test oncreate fragment3" );
        View v = inflater.inflate(R.layout.tab_fragment_3, container, false);
        mTextView1 = (TextView) v.findViewById(R.id.textoMapa);
        t2 =  (TextView) v.findViewById(R.id.textoMapaDireccion);
        t3 =  (TextView) v.findViewById(R.id.textoMapaTelefono);

        Button botonLlamar = (Button) v.findViewById(R.id.btn_call_phone);
        botonLlamar.setOnClickListener(this);

        colegioTransporte.setmTextView1(mTextView1);
        colegioTransporte.setHayCampoMapa(1);
        colegioTransporte.setMtextoMapaDireccion(t2);
        colegioTransporte.setMtextoMapaTelefono(t3);

        mapView = (MapView) v.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this); //this is important
        return v;
    }

    public static final TabFragment3 newInstance(ColegioTransporte colegioTransporte){
        TabFragment3 f = new TabFragment3();
        f.colegioTransporte=colegioTransporte;
        //Log.d("test", "creoooooooo" );
        return f;
    }

    @Override
    public void onClick(View view) {


        String phone = t3.getText().toString();
        /*changeTextOnFragment(phone);*/
//        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
//        startActivity(intent);

        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+Uri.encode(phone.trim())));
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(callIntent);
    }

    public void changeTextOnFragment(String texto){
        mTextView1.setText(texto);

    }

    public void fragmentCommunication() {
        mTextView1.setText("Hello from Tab Fragment 1");
    }









    public int getColegioId() {
        return colegioId;
    }

    public void setColegioId(int colegioId) {
        this.colegioId = colegioId;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
        Log.d("test", "hizo un onResume ");
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }


/*
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        FragmentManager fm = getChildFragmentManager();
        fragment = (SupportMapFragment) fm.findFragmentById(R.id.map);


        FragmentManager fm = getChildFragmentManager();
        fragment = (SupportMapFragment) fm.findFragmentById(R.id.map);
        if (fragment == null) {
            fragment = SupportMapFragment.newInstance();
            fm.beginTransaction().replace(R.id.map, fragment).commit();

            fragment.getMapAsync(this);
        }






    }
        */

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mGoogleMap = googleMap;
        mGoogleMap.getUiSettings().setZoomControlsEnabled(true);
        if(colegioTransporte.getHayObjetoColegioActivo()==1){
            mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(colegioTransporte.getColegioActivo().getLatitude(), colegioTransporte.getColegioActivo().getLongitude())).title(colegioTransporte.getColegioActivo().getName()));
            mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(colegioTransporte.getColegioActivo().getLatitude(), colegioTransporte.getColegioActivo().getLongitude()), 3));
        }else{
            mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(-34, 151)).title("Marker default"));
            mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-34, 151), 3));
        }

        colegioTransporte.setmGoogleMap(mGoogleMap);
        colegioTransporte.setHayGoogleMap(1);






        /*map.addMarker(new MarkerOptions()
                .position(new LatLng(-34, 151))
                .title("Marker"));*/
    }


}