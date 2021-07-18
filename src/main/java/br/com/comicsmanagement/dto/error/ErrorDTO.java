package br.com.comicsmanagement.dto.error;

public class ErrorDTO {
    private String entity;
    private String mesage;

    public ErrorDTO(String entity, String mesage) {
        this.entity = entity;
        this.mesage = mesage;
    }

    public String getEntity() {
        return entity;
    }

    public String getMesage() {
        return mesage;
    }
}
