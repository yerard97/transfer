package com.dummy.transfer.model;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/*
    Clase con la estructura del cuerpo de las peticiones
 */
@Getter
@Setter
public class DataFile implements Serializable {

    @NotNull
    String nombre;

    @NotNull
    String base64;

    @NotNull
    String ruta;
}
