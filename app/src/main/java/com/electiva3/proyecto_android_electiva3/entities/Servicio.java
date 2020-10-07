package com.electiva3.proyecto_android_electiva3.entities;

public class Servicio
{
    private String key;
    private String titulo;
    private String descripcion;
    private String categoria;
    private String costo;
    private String estado;

    public Servicio() {
    }

    public Servicio(String key, String titulo, String descripcion, String categoria, String costo, String estado) {
        this.key = key;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.costo = costo;
        this.estado = estado;
    }

    public Servicio(String key, String titulo, String descripcion, String costo){
        this.key = key;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public String getKey() { return key; }

    public void setKey(String key) { this.key = key; }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descrpcion) {
        this.descripcion = descrpcion;
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
