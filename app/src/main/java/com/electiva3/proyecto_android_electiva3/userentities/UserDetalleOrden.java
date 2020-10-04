package com.electiva3.proyecto_android_electiva3.userentities;

public class UserDetalleOrden {

    private String  nombreServicio;
    private String  precio;
    private String  aceptacion;

    public UserDetalleOrden(String nombreServicio, String precio, String aceptacion) {
        this.nombreServicio = nombreServicio;
        this.precio         = precio;
        this.aceptacion     = aceptacion;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getAceptacion() {
        return aceptacion;
    }

    public void setAceptacion(String aceptacion) {
        this.aceptacion = aceptacion;
    }
}
