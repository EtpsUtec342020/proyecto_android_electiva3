package com.electiva3.proyecto_android_electiva3.entities;

import java.util.HashMap;
import java.util.Map;

public class Servicio
{
    private String key;
    private String titulo;
    private String descripcion;
    private String categoria;
    private String costo;
    private String estado;
    private HashMap<String, Object> servicioMap = new HashMap<>();

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

    public Servicio(String key, String titulo, String descripcion, String estado){
        this.key = key;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
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

    public HashMap<String, Object> getServicioMap() {
        return servicioMap;
    }

    public void setServicioMap(HashMap<String, Object> servicioMap) {
        this.servicioMap = servicioMap;
    }

    public void UpdateServicio()
    {
        servicioMap.put("titulo", titulo);
        servicioMap.put("categoria", categoria);
        servicioMap.put("estado", estado);
        servicioMap.put("descripcion", descripcion);
        servicioMap.put("costo", costo);
    }
}
