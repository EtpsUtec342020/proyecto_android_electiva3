package com.electiva3.proyecto_android_electiva3.entities;

public class Vehiculo
{
    private String cliente;
    private String placa;
    private String chasis;
    private String anio;
    private String color;
    private String marca;
    private String modelo;
    private String estado;

    public Vehiculo(String cliente, String placa, String chasis, String anio, String color, String marca, String modelo, String estado) {
        this.cliente = cliente;
        this.placa = placa;
        this.chasis = chasis;
        this.anio = anio;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.estado = estado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
