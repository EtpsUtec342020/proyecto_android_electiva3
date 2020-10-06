package com.electiva3.proyecto_android_electiva3.entities;

import com.google.firebase.database.Exclude;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Usuario
{
    private String key;
    private String nombre;
    private String dui;
    private String nit;
    private String licencia;
    private String correo;
    private String telefono;
    private String direccion;
    private String rol;
    private String estado;
    private String fechaRegistro;
   private Map<String, Object> usuario = new HashMap<>();

    public Usuario() {
    }

    public Usuario(String key, String nombre, String correo, String estado) {
        this.key = key;
        this.nombre = nombre;
        this.correo = correo;
        this.estado = estado;
    }

    public Usuario(String nombre, String dui, String nit, String licencia, String correo, String telefono, String direccion, String rol, String estado, String fechaRegistro)
    {
        this.nombre = nombre;
        this.dui = dui;
        this.nit = nit;
        this.licencia = licencia;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.rol = rol;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
    }

    public Map<String, Object> getUsuario() {
        return usuario;
    }

    public void setUsuario(Map<String, Object> usuario)
    {
        this.usuario = usuario;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRol() { return rol; }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
