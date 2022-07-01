package com.dummy.transfer.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
/*
    Clase con la estructura de las configuraciones del  microservicio
 */
@Getter
@Setter
public class Transfer {
    @NotNull
    private String servidor;

    @NotNull
    private int puerto;

    @NotNull
    private String usuario;

    @NotNull
    private String password;

    private String rsa;

    @Override
    public String toString(){
        return "Server [" +
                "Servidor = "+ servidor +" " +
                "Puerto = " + puerto + " " +
                "Usuario = " + usuario + " " +
                "Password = " + password + " " +
                "Rsa = " + rsa + " " +
                "] ";
    }
}
