package com.springbootmongodb.course.services.servicesException;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String id) {
        super("Não encontrado. ID " + id);
    }
}
