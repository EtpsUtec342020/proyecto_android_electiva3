package com.electiva3.proyecto_android_electiva3.entities;

import java.util.ArrayList;

public class Plan
{
    private String tipo;
    private String duracion;
    private String costo;
    private String estado;
    private ArrayList<String> servicios;

    public Plan(String tipo, String duracion, String costo, String estado, ArrayList<String> servicios) {
        this.tipo = tipo;
        this.duracion = duracion;
        this.costo = costo;
        this.estado = estado;
        this.servicios = servicios;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<String> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<String> servicios) {
        this.servicios = servicios;
    }
}
