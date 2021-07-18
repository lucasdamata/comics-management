package br.com.comicsmanagement.client.dto;


public class ResponseApiDTO {
    private Long code;
    private String status;
    private DataResponse data;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataResponse getData() {
        return data;
    }

    public void setData(DataResponse data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "ResponseApiDTO{" +
                "code=" + code +
                ", status='" + status + '\'' +
                ", data=" + data.getResults() +
                '}';
    }
}
