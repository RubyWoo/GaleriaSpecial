package com.example.yadira.galeriaspecial;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    //*OPCIONAL PARA ESTA VERSIÓN
    //public static List<MenuItemG> ITEMS;
    //*OPCIONAL PARA ESTA VERSIÓN

    public static class MenuItemG{

        private int idImagen;
        private String titulo;

        public MenuItemG(){

        }

        public MenuItemG(int idImagen, String titulo) {
            this.idImagen = idImagen;
            this.titulo = titulo;
        }

        public int getIdImagen() {
            return idImagen;
        }

        public void setIdImagen(int idImagen) {
            this.idImagen = idImagen;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public ArrayList<MenuItemG> listaMenuItem(){

            MenuItemG menuItemG;
            ArrayList<MenuItemG> lista = new ArrayList<MenuItemG>();

            Integer[] idImagenes = new Integer[]{
                    R.drawable.coffeeartt,R.drawable.coffeeart,R.drawable.edificiog,R.drawable.edificiot,R.drawable.imagecoffees2};
            String[] titulos = new String[]{"Cafe 1","Cafe 2","Cafe 3","Cafe","Cafe 5"};

            for(int i =0; i<idImagenes.length;  i++){
                menuItemG = new MenuItemG(idImagenes[i],titulos[i]);
                lista.add(menuItemG);
            }

            return  lista;

        }
    }
}
