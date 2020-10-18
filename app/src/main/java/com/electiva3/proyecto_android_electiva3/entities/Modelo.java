package com.electiva3.proyecto_android_electiva3.entities;

public class Modelo {


    private String key;
    private String modelo;
    private String estado;
    private String keyMarca;

    public  Modelo(String key , String modelo , String estado , String keyMarca){
        this.key =  key;
        this.modelo =  modelo;
        this.estado = estado;
        this.keyMarca =  keyMarca;
    }

    public void setKey(String key){
        this.key =  key;
    }

    public String getKey(){
        return key;
    }

    public void setModelo(String modelo){
        this.modelo =  modelo;
    }

    public String getModelo(){
        return modelo;
    }

    public void setEstado(String estado){
        this.estado =  estado;
    }

    public String getEstado(){
        return estado;
    }

    public void setKeyMarca(String keyMarca){
        this.keyMarca =  keyMarca;
    }

    public String getKeyMarca(){
        return keyMarca;
    }

}
