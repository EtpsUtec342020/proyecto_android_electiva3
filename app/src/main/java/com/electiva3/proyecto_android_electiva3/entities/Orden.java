package com.electiva3.proyecto_android_electiva3.entities;

public class Orden {

    private String numeroOrden;
    private String cliente;
    private String estado;
    private String fecha;


    public Orden(String numeroOrden , String cliente ,  String estado ,  String fecha){
        this.numeroOrden = numeroOrden;
        this.cliente = cliente;
        this.estado  = estado;
        this.fecha = fecha;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
