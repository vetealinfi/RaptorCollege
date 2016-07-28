package com.codebake.raptor.raptorcollege.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.codebake.raptor.raptorcollege.R;

/**
 * Created by CTN Developer on 28-07-2016.
 */
public class ColegioAdapter extends RecyclerView.Adapter<ColegioAdapter.ColegioViewHolder>{

    Context context;

    public ColegioAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ColegioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //primero se infla la vista del item
        //establecer contacto con el contexto o activity
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_colegio_list,parent,false);



        return null;
    }

    @Override
    public void onBindViewHolder(ColegioViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ColegioViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView photoCollege;
        TextView address;


        public ColegioViewHolder(View itemView) {
            super(itemView);
        }
    }

}
