package com.electiva3.proyecto_android_electiva3.entities;

public class Reserva {

    private String cliente;
    private String contrato;
    private String fecha;
    private String estado;

    public Reserva(String cliente, String contrato, String fecha, String estado) {
        this.cliente = cliente;
        this.contrato = contrato;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
