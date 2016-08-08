package com.codebake.raptor.raptorcollege.adapter;

import android.app.TabActivity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import com.codebake.raptor.raptorcollege.R;
import com.codebake.raptor.raptorcollege.ui.TabFragment3;

import java.util.ArrayList;
import java.util.List;

import Modelo.Colegio;
import Modelo.ColegioTransporte;

/**
 * Created by CTN Developer on 28-07-2016.
 */
public class ColegioAdapter extends RecyclerView.Adapter<ColegioAdapter.ColegioViewHolder>{

    Context context;
    ArrayList<Colegio> colegiosList;
    ViewPager viewPager;
    ColegioTransporte colegioTransporte;


    public ColegioAdapter(Context context,ViewPager viewPager,ColegioTransporte colegioTransporte) {
        this.context = context;
        this.colegiosList = new ArrayList<>();
        this.viewPager=viewPager;
        this.colegioTransporte=colegioTransporte;

    }

    @Override
    public ColegioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //primero se infla la vista del item
        //establecer contacto con el contexto o activity
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_colegio_list,parent,false);



        return new ColegioViewHolder(itemView,viewPager,colegioTransporte);
    }



    @Override
    public void onBindViewHolder(ColegioViewHolder holder, int position) {
        //conectar view holder con los datos
        Colegio currentColegio = colegiosList.get(position);
        holder.setName(currentColegio.getName());
        holder.setAddress(currentColegio.getAddress());
    }



    @Override
    public int getItemCount() {
        return colegiosList.size();
    }

    public void addAll(@NonNull ArrayList<Colegio> colegios){
        if(colegios ==null)
            throw new NullPointerException("items no pueden ser nulos");

        this.colegiosList.addAll(colegios);
        notifyItemRangeInserted(getItemCount() - 1,colegios.size());

    }


    public class ColegioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name;
        ImageView photoCollege;
        TextView address;
        ViewPager viewPager;
        ColegioTransporte colegioTransporte;


        public ColegioViewHolder(View itemView,ViewPager viewPager,ColegioTransporte colegioTransporte) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.college_name);
            address = (TextView) itemView.findViewById(R.id.college_address);
            photoCollege = (ImageView) itemView.findViewById(R.id.colegio_img);
            this.viewPager = viewPager;
            this.colegioTransporte=colegioTransporte;
            itemView.setOnClickListener(this);


        }



        public void setAddress(String addressS) {
            address.setText(addressS);
        }

        public void setName(String nameS) {
            name.setText(nameS);
        }


        @Override
        public void onClick(View v) {
            Log.d("test", "test" + getAdapterPosition());
            Colegio colegioActivo = this.colegioTransporte.getColegioFromIndice(getAdapterPosition());
            colegioTransporte.setColegioActivo(colegioActivo);
            colegioTransporte.setHayObjetoColegioActivo(1);


            viewPager.setCurrentItem(3);
            //tab3.changeTextOnFragment("Colegio "+ getAdapterPosition());
            //TabHost host = (TabHost) getActivity().findViewById(android.R.id.tabhost);
            //host.setCurrentTab(3);

        }

    }

}
