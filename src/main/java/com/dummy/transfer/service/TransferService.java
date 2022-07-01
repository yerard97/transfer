package com.dummy.transfer.service;

import com.dummy.transfer.config.TransferConfig;
import com.dummy.transfer.controller.TransferController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedIOException;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.integration.sftp.session.SftpSession;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class TransferService implements ITransferService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransferController.class);

    SftpSession session;

    @Autowired
    TransferConfig config;

    @Override
    public void enviarArchivo(){

    }

    @Override
    public void connectToSFTP(){
        
    }
    /*
        Metodo que se conecta a un servidor SFTP para relizar la descarga de un archivo
        return byte[] archivo recuperado
     */
    @Override
    public byte[] downloadFile(){
        LOGGER.info("Inicia Service descarga de archivos");
        byte[] bytes = null;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try{
            SftpSession session = sftpSessionFactory().getSession();
            LOGGER.info("Is Conected "+ session.isOpen());
            session.read("/pub/example/readme.txt", output);
            bytes = output.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
    /*
        Metodo que se encarga de crear la conexión  al servior SFTP , con los parametros dados
        return Session Factory del sftp
     */
    public DefaultSftpSessionFactory sftpSessionFactory(){
        DefaultSftpSessionFactory defaultSftpSessionFactory = new DefaultSftpSessionFactory(true);
        defaultSftpSessionFactory.setHost(config.getServidor());
        defaultSftpSessionFactory.setPort(config.getPuerto());
        defaultSftpSessionFactory.setUser(config.getUsuario());
        defaultSftpSessionFactory.setPassword(config.getPassword());
        /*
            For set rsa
            if(ruta != null && !ruta.isEmpty())
                File file = new File(Encode.forJava(ruta))
                Resource privateKey = new InputStreamResource(new FileInputStream(file))
                defaultSftpSessionFactory.setPrivateKey(privateKey)
            else
                defaultSftpSessionFactory.setPassword("");
         */
        defaultSftpSessionFactory.setAllowUnknownKeys(true);
    return defaultSftpSessionFactory;
    }
}
