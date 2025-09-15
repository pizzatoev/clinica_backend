package org.example.clinica_backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoEncuentro {
    CONSULTA("Consulta"),
    URGENCIA("Urgencia"),
    HOSPITALIZACION("Hospitalización");

    private final String dbValue;
    TipoEncuentro(String dbValue){ this.dbValue = dbValue; }
    public String getDbValue(){ return dbValue; }

    @JsonValue
    public String toApi() {             // respuesta API -> "CONSULTA"
        return this.name();
    }

    @JsonCreator
    public static TipoEncuentro fromApi(String value) { // acepta "CONSULTA" o "Consulta"
        if (value == null) return null;
        String v = value.trim();
        try {
            return TipoEncuentro.valueOf(v.toUpperCase().replace(" ", "_"));
        } catch (IllegalArgumentException ignored) { }
        for (TipoEncuentro t : values()) {
            if (t.dbValue.equalsIgnoreCase(v)) return t;
        }
        throw new IllegalArgumentException("TipoEncuentro inválido: " + value);
    }

    public static TipoEncuentro fromDb(String dbVal) {
        if (dbVal == null) return null;
        for (TipoEncuentro t : values()) if (t.dbValue.equals(dbVal)) return t;
        throw new IllegalArgumentException("TipoEncuentro DB inválido: " + dbVal);
    }
}
