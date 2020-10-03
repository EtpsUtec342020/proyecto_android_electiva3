package com.electiva3.proyecto_android_electiva3.entities;

import java.util.List;

public class Estado
{
    private int key;
    private String estado;
    private String uso;
    private List<String> estados;


    public Estado()
    {
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public List<String> getEstados() {
        return estados;
    }

    public void setEstados(List<String> estados) {
        this.estados = estados;
    }
}
