package com.codebake.raptor.raptorcollege.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.codebake.raptor.raptorcollege.R;

import java.util.ArrayList;
import java.util.List;

import Modelo.Colegio;

/**
 * Created by CTN Developer on 28-07-2016.
 */
public class ColegioAdapter extends RecyclerView.Adapter<ColegioAdapter.ColegioViewHolder>{

    Context context;
    ArrayList<Colegio> colegiosList;

    public ColegioAdapter(Context context) {
        this.context = context;
        this.colegiosList = new ArrayList<>();
    }

    @Override
    public ColegioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //primero se infla la vista del item
        //establecer contacto con el contexto o activity
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_colegio_list,parent,false);



        return new ColegioViewHolder(itemView);
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


    public class ColegioViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView photoCollege;
        TextView address;


        public ColegioViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.college_name);
            address = (TextView) itemView.findViewById(R.id.college_address);
            photoCollege = (ImageView) itemView.findViewById(R.id.colegio_img);


        }

        public void setAddress(String addressS) {
            address.setText(addressS);
        }

        public void setName(String nameS) {
            name.setText(nameS);
        }

    }

}
