package com.electiva3.proyecto_android_electiva3.entities;

public class Servicio
{
    private String titulo;
    private String descrpcion;
    private String categoria;
    private String costo;
    private String estado;

    public Servicio(String titulo, String descrpcion, String categoria, String costo, String estado) {
        this.titulo = titulo;
        this.descrpcion = descrpcion;
        this.categoria = categoria;
        this.costo = costo;
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescrpcion() {
        return descrpcion;
    }

    public void setDescrpcion(String descrpcion) {
        this.descrpcion = descrpcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
}
