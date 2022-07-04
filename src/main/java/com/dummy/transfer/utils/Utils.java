package com.dummy.transfer.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;

public class Utils {
    /***
     * Convierte el archivo en base64 a un archivo inputstram
     * @param base64 file in base 64
     * @return archivo convertido
     */
    public static InputStream getInputStreamFromBase64(String base64){
        return new ByteArrayInputStream(Base64.getDecoder().decode(base64));
    }
}
