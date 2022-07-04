package com.dummy.transfer.model;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/*
    Clase con la estructura del cuerpo de las peticiones
 */
@Getter
@Setter
public class DataFile implements Serializable {

    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name is required")
    String nombre;

    @NotNull(message = "File is required")
    @NotEmpty(message = "File is required")
    String base64;

    @NotNull(message = "Ruta is required")
    @NotEmpty(message = "Ruta is required")
    String ruta;
}
