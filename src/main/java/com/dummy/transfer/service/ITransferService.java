package com.dummy.transfer.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ITransferService {
    
    public void enviarArchivo() throws IOException;

    /***
     *    Método que se conecta a un servidor SFTP para realizar la descarga de archivos
     * @return Archivo descargado
     */
    public byte[] downloadFile() throws IOException;
}
