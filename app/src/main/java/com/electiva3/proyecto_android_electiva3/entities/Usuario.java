package com.electiva3.proyecto_android_electiva3.entities;

import java.util.ArrayList;

public class Usuario
{
    private String keyUsuario;
    private String nombre;
    private int dui;
    private int nit;
    private int licencia;
    private String correo;
    private int telefono;
    private String direccion;
    private String rol;
    private String estadoUsuario;
    private String fechaRegistro;

    //variables de vehiculo
    private String KeyVehiculo;
    private int placa;
    private int chasis;
    private String anio;
    private String color;
    private String marca;
    private String modelo;
    private String estadoVehiculo;

    //variables de contrato
    private String keyContrato;
    private String keyPlan;
    private int duracion;
    private String fechaActivacion;
    private String fechaVencimiento;
    private int numManto;
    private String estadoContrato;
    private double CostoTotal;

    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public Usuario() {
    }

    public Usuario(String nombre, int dui, int nit, int licencia, String correo, int telefono, String direccion, String rol, String estadoUsuario) {
        this.nombre = nombre;
        this.dui = dui;
        this.nit = nit;
        this.licencia = licencia;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.rol = rol;
        this.estadoUsuario = estadoUsuario;
    }

    public String getKeyUsuario() {
        return keyUsuario;
    }

    public void setKeyUsuario(String keyUsuario) {
        this.keyUsuario = keyUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDui() {
        return dui;
    }

    public void setDui(int dui) {
        this.dui = dui;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public int getLicencia() {
        return licencia;
    }

    public void setLicencia(int licencia) {
        this.licencia = licencia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getKeyVehiculo() {
        return KeyVehiculo;
    }

    public void setKeyVehiculo(String keyVehiculo) {
        KeyVehiculo = keyVehiculo;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public int getChasis() {
        return chasis;
    }

    public void setChasis(int chasis) {
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

    public String getEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(String estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    public String getKeyContrato() {
        return keyContrato;
    }

    public void setKeyContrato(String keyContrato) {
        this.keyContrato = keyContrato;
    }

    public String getKeyPlan() {
        return keyPlan;
    }

    public void setKeyPlan(String keyPlan) {
        this.keyPlan = keyPlan;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(String fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getNumManto() {
        return numManto;
    }

    public void setNumManto(int numManto) {
        this.numManto = numManto;
    }

    public String getEstadoContrato() {
        return estadoContrato;
    }

    public void setEstadoContrato(String estadoContrato) {
        this.estadoContrato = estadoContrato;
    }

    public double getCostoTotal() {
        return CostoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        CostoTotal = costoTotal;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
