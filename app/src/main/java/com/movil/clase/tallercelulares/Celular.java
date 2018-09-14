package com.movil.clase.tallercelulares;

public class Celular {
    private String marca;
    private String color;
    private String so;
    private int precio;


    public Celular(String marca, String color, String so, int precio) {
        this.marca = marca;
        this.color = color;
        this.so = so;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void guardar(){
        Datos.guardar(this);
    }
}
