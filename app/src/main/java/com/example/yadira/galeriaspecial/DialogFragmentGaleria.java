package com.example.yadira.galeriaspecial;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DialogFragmentGaleria extends DialogFragment {

    View view;
    TextView tituloImagen ;
    ImageView imagenGaleria  ;
    RecyclerView recyclerViewGaleria;
    RecyclerMenuItemGAdapter recyclerMenuItemGAdapter;
    ArrayList<Menu.MenuItemG> listita;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_dialog_fragment_galeria, container, false);
       tituloImagen = view.findViewById(R.id.titlePhotoGallery);
       imagenGaleria= view.findViewById(R.id.photoImageGallery);
       recyclerViewGaleria = view.findViewById(R.id.galeriaListaRecycler);
       recyclerViewGaleria.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
       listita = new Menu.MenuItemG().listaMenuItem();

       imagenGaleria.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               //----------------------------------
               getDialog().dismiss();//CÓDIGO NUEVO, SI PULSO LA IMAGEN EL FRAGMENT SE DESECHA
               //----------------------------------

           }
       });

       //-------------------////////////// CÓDIGO NUEVO ---------------------------------------------
       recyclerMenuItemGAdapter = new RecyclerMenuItemGAdapter(listita,new RecyclerMenuItemGAdapter.OnClickRecycler(){

           @Override
           public void onClickItemRecycler(Menu.MenuItemG menuItemG) {

               Glide.with(getContext()).load(menuItemG.getIdImagen()).into(imagenGaleria);
               tituloImagen.setText(menuItemG.getTitulo());

           }
       });
       //--------------------------------------------------------------------------------------------

       recyclerViewGaleria.setAdapter(recyclerMenuItemGAdapter);


       return view;////////SIEMPRE TENEMOS QUE RETORNAR UNA VISTA PARA onCreateView()
    }//////////////////////////////////////////////////////////////////////////// END onCreateView()
}
