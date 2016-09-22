package com.alejandrablandon.crepeswaffles;

/**
 * Created by USUARIO on 20/09/2016.
 */
public class Productos {
    private int idImage,precio;
    private String nombre, descripcion;

    public Productos(String nombre, String descripcion, int precio, int idImage) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.idImage = idImage;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
