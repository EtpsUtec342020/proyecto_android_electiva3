package com.electiva3.proyecto_android_electiva3.entities;

public class Estado
{
    private String key;
    private String estado;

    public Estado() {
    }

    public Estado(String key, String estado)
    {
        this.key = key;
        this.estado = estado;
    }

    public String getKey() { return key;
    }

    public void setKey(String key) { this.key = key;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
