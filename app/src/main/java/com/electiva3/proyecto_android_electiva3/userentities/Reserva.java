package com.electiva3.proyecto_android_electiva3.userentities;

public class Reserva {

    private String reserva;
    private String fecha;

    public Reserva(String reserva, String fecha) {
        this.reserva = reserva;
        this.fecha = fecha;

    }

    public String getReserva() {
        return reserva;
    }

    public void setReserva(String reserva) {
        this.reserva = reserva;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
