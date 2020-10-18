package com.electiva3.proyecto_android_electiva3.entities;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Vehiculo
{
    private String key;
    private String anio;
    private String color;
    private String fechaRegistro;
    private String marca;
    private String modelo;
    private String numChasis;
    private String placa;
    private String estado;


    public Vehiculo( String key , String placa , String  marca ,String anio  ){
        this.key = key;
        this.marca =  marca ;
        this.placa =   placa;
        this.anio =  anio;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumChasis() {
        return numChasis;
    }

    public void setNumChasis(String numChasis) {
        this.numChasis = numChasis;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
