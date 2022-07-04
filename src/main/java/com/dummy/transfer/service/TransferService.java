package com.dummy.transfer.service;

import com.dummy.transfer.config.TransferConfig;
import com.dummy.transfer.controller.TransferController;
import com.dummy.transfer.utils.Utils;
import org.apache.commons.io.IOUtils;
import org.bouncycastle.mime.encoding.Base64InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedIOException;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.integration.sftp.session.SftpSession;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class TransferService implements ITransferService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransferController.class);

    @Autowired
    TransferConfig config;

    @Override
    public void enviarArchivo() throws IOException {
        LOGGER.info("Inicia Service Enviar archivo");
        InputStream file = Utils.getInputStreamFromBase64("V2VsY29tZSB0byBteSB0ZXN0");
        try{
            SftpSession session = sftpSessionFactory().getSession();
            LOGGER.info("The Session is open:  "+ session.isOpen());

            session.write(file, "/pub/example/readme.txt");
            session.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw new IOException(e);
        }

    }
    /***
     * Método que se conecta a un servidor SFTP para realizar la descarga de un archivo
     * @return byte[] archivo recuperado
     */
    @Override
    public byte[] downloadFile() throws IOException {
        LOGGER.info("Inicia Service descarga de archivos");
        SftpSession session = null;
        byte[] bytes = null;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try{
            session = sftpSessionFactory().getSession();
            LOGGER.info("The Session is open :" + session.isOpen());
            session.read("/pub/example/readme.txt", output);
            bytes = output.toByteArray();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw new IOException(e);
        }
        session.close();
        return bytes;
    }

    /***
     * Método que se encarga de crear la conexión al servidor SFTP, con los parámetros dados
     * @return
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
