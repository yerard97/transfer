package com.dummy.transfer.config;

import com.dummy.transfer.model.Transfer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

/*
    Clase para las propiedades de configuración del micro
 */
@Configuration
@ConfigurationProperties(prefix="destino")
@Validated
public class TransferConfig extends Transfer {

}
