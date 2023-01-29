package com.bedu.tickets_sprbootv2.models.builders;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class RespuestaError {

    private final LocalDateTime timestamp = LocalDateTime.now();
    private int estatus;
    private Map<String, String> errores;
    private String ruta;

    public static RespuestaErrorBuilder builder() {
        return new RespuestaErrorBuilder();
    }
}
