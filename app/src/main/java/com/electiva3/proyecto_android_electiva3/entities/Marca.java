package com.electiva3.proyecto_android_electiva3.entities;

public class Marca {

    private String key;
    private String marca;
    private String estado;


    public Marca(){

    }

    public Marca(String key , String marca ,  String estado){
        this.key =  key;
        this.marca =  marca;
        this.estado =  estado;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setEstado(String estado){
        this.estado =  estado;
    }

    public String getEstado(){
        return estado;
    }


}
