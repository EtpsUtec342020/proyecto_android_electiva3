package com.electiva3.proyecto_android_electiva3.entities;

public class DetalleOrden {

    private String nombreServicio;
    private String estado;
    private String precio;

    public DetalleOrden(String nombreServicio, String estado, String precio) {
        this.nombreServicio = nombreServicio;
        this.estado = estado;
        this.precio = precio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
