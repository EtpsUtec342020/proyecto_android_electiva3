package com.electiva3.proyecto_android_electiva3.userentities;

public class UserOrden {

    private String numeroOrden;
    private String supervisor;

    public UserOrden(String numeroOrden , String supervisor){
        this.numeroOrden = numeroOrden;
        this.supervisor = supervisor;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }


}
