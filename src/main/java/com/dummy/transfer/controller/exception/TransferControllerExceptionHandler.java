package com.dummy.transfer.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//@ControllerAdvice
public class TransferControllerExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransferControllerExceptionHandler.class);

    /**
     * Metodo que maneja las excepciones al validar los argumentos de entrada
     * @param exception Excepcion de validación de argumantos de entrada
     * @return Respuesta con el error
     */
 /*   @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<?> argumentNotValidException(MethodArgumentNotValidException exception){
        LOGGER.error("Arguments not valid: {}", Encode.forJava(exception.toString()));
        return new ResponseEntity(exception.toString(), HttpStatus.BAD_REQUEST);
    }*/

    /**
     * Metodo que maneja las excepciones de formato de numeros
     * @param exception Excepsion de validación de argumantos de entrada
     * @return Respuesta con el error
     */
/*    @ExceptionHandler(value = {NumberFormatException.class})
    public ResponseEntity<?> numerFormatException(NumberFormatException exception){
        LOGGER.error("Format Number not valid: {}", Encode.forJava(exception.toString()));
        return new ResponseEntity(exception.toString(), HttpStatus.BAD_REQUEST);
    }*/

    /**
     * Metodo que maneja las excepciones de formato de numeros
     * @param exception Excepsion de validación de argumantos de entrada
     * @return Respuesta con el error
     */
/*    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<?> argumentNotValidException(Exception exception){
        LOGGER.error("Error : {}", Encode.forJava(exception.toString()));
        return new ResponseEntity(exception.toString(), HttpStatus.BAD_REQUEST);
    }*/
}
