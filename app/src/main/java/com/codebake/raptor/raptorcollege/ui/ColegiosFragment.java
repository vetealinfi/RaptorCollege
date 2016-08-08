package com.codebake.raptor.raptorcollege.ui;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.TabLayout;

import com.codebake.raptor.raptorcollege.R;
import com.codebake.raptor.raptorcollege.adapter.ColegioAdapter;
import com.codebake.raptor.raptorcollege.adapter.IFragmentToActivity;

import java.util.ArrayList;

import Modelo.Colegio;
import Modelo.ColegioTransporte;

/**
 * Created by CTN Developer on 28-07-2016.
 */
public class ColegiosFragment extends Fragment{
    public static final String LOG_TAG = ColegiosFragment.class.getName();
    public final static int NUM_COLS=1;
    private RecyclerView mResultadoColegiosList;
    private ColegioAdapter colegioAdapter;
    ViewPager viewPager;
    ArrayList<Colegio> colegios = new ArrayList<>();
    private IFragmentToActivity mCallback;
    ColegioTransporte colegioTransporte;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        colegioAdapter = new ColegioAdapter(getActivity(),viewPager,colegioTransporte);
    }


    public static final ColegiosFragment newInstance(ViewPager viewPager,ColegioTransporte colegioTransporte){
        ColegiosFragment f = new ColegiosFragment();
        f.viewPager = viewPager;
        f.colegioTransporte = colegioTransporte;
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_colegios,container,false);

        mResultadoColegiosList = (RecyclerView) root.findViewById(R.id.colegio_list);

        setUpColegiosList();
        setDummyContent();


        return root;
    }




    private void setUpColegiosList(){

        mResultadoColegiosList.setLayoutManager(new GridLayoutManager(getActivity(),NUM_COLS));
        mResultadoColegiosList.setAdapter(colegioAdapter);
        mResultadoColegiosList.addItemDecoration(new ItemOffsetDecoration(getActivity(),R.integer.offset_grid));

    }

    private void setDummyContent( ){
        colegioAdapter.addAll(this.colegioTransporte.getColegios());
    }



}
