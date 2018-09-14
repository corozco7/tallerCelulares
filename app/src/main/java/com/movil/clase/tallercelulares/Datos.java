package com.movil.clase.tallercelulares;

import java.util.ArrayList;

public class Datos {
    private static ArrayList<Celular> celulares = new ArrayList();

    public static void guardar (Celular c){
        celulares.add(c);
    }

    public static ArrayList<Celular> obtener(){
        return celulares;
    }
}
