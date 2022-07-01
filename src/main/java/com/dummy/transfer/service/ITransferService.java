package com.dummy.transfer.service;

public interface ITransferService {
    
    public void enviarArchivo();
    
    public void connectToSFTP();

    /*
        Metodo que se conecta a un servidor SFTP para realizar la descarga de archivos
        return archivo a descargar
     */
    public byte[] downloadFile();
}
