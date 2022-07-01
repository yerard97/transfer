package com.dummy.transfer.controller;

import com.dummy.transfer.model.DataFile;
import com.dummy.transfer.service.ITransferService;
import org.owasp.encoder.Encode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/archivos")
public class TransferController{

    private static final Logger LOGGER = LoggerFactory.getLogger(TransferController.class);

    @Autowired
    ITransferService transferService;

    /*
        Metodo controller que se encarga de descargar un archivo
        @param dataFile cuerpo con datos del archivo
        @return Respuesta de la petición
     */
    @CrossOrigin
    @PostMapping(value= "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendFile(@Valid @RequestBody DataFile dataFile){

        LOGGER.info("Entra al controller descargar archivo {}", Encode.forJava(dataFile.toString()));
        byte[] response = transferService.downloadFile();
        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dataFile.getNombre().replace("\"", "") + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(response);
   }
}
