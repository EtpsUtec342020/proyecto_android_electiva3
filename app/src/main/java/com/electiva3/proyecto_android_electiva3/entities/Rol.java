package com.electiva3.proyecto_android_electiva3.entities;

public class Rol
{
    private String key;
    private String rol;

    public Rol() {
    }

    public Rol(String key, String rol)
    {
        this.key = key;
        this.rol = rol;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getRol()
    {
        return rol;
    }

    public void setRol(String rol)
    {
        this.rol = rol;
    }
}
