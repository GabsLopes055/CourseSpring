package com.spring.WebServices.exceptions;

public class ResourceNotFoundExceptions extends RuntimeException {

    public ResourceNotFoundExceptions(Object id) {
        super("Recurso não encontrado - ID:" + id);
    }
}
