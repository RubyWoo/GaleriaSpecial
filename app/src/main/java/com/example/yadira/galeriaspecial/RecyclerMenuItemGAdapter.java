package com.example.yadira.galeriaspecial;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerMenuItemGAdapter extends RecyclerView.Adapter<RecyclerMenuItemGAdapter.MenuItemGViewHolder>{

    private ArrayList<Menu.MenuItemG> listaMenuItemG;
    private OnClickRecycler listener; //NUEVA VARIABLE QUE RECIBIRÁ EL CONSTRUCTOR


    //CONSTRUCTOR DEL RECYCLER-ADAPTER
    public RecyclerMenuItemGAdapter(ArrayList<Menu.MenuItemG> items, OnClickRecycler listener){

        listaMenuItemG = items;
        this.listener = listener;

    }////////////////////////////////////////////////////////////////////////////// END CONSTRUCTOR

    @NonNull
    @Override
    public MenuItemGViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_itemg,parent,false);
        return new MenuItemGViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItemGViewHolder holder, int position) {

        //------------------------------------------------------ II
        //CÓDIGO NUEVO
        holder.bind(listaMenuItemG.get(position),listener);//ENVIO ELEMENTOS CON SU POSICIÓN
        //------------------------------------------------------

    }

    @Override
    public int getItemCount() {
        return listaMenuItemG.size();
    }
    ////////////////////////////////////////////////////////////////////////// END METHODS CALL-BACK



    //--------------////////////////////////////// NUEVO CÓDIGO ---------------------------------- I
    public interface OnClickRecycler{
        void onClickItemRecycler(Menu.MenuItemG menuItemG);
    }

    //----------------------------------------------------------------------------------------------



    //::::::::::::::::::::::::::::::::::: CLASE VIEW-HOLDER::::::::::::::::::::::::::::::::::::::::::

    public static class MenuItemGViewHolder extends RecyclerView.ViewHolder{

        ImageView imagen;

        public MenuItemGViewHolder(@NonNull View itemView) {
            super(itemView);

            imagen = itemView.findViewById(R.id.imagen_galeria);


        }

        //-----------///////////////////// NUEVO CÓDIGO------------------------------------------ III
        public void bind(final Menu.MenuItemG menuItemG, final OnClickRecycler listener){

            Glide.with(imagen.getContext()).load(menuItemG.getIdImagen()).into(imagen);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickItemRecycler(menuItemG);
                }
            });


        }
        //------------------------------------------------------------------------------------------
    }
}
