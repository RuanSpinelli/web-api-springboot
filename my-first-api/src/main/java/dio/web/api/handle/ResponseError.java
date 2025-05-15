package dio.web.api.handle;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description = "Modelo de resposta de erro")
public class ResponseError {

    @Schema(description = "Momento do erro", example = "2025-05-14T15:20:00Z")
    private Date timestamp = new Date();

    @Schema(description = "Status textual", example = "error")
    private String status = "error";

    @Schema(description = "Código HTTP", example = "400")
    private int statusCode = 400;

    @Schema(description = "Mensagem do erro", example = "Campo 'email' é obrigatório.")
    private String error;

    public ResponseError() {}

    public ResponseError(Date timestamp, String status, int statusCode, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.statusCode = statusCode;
        this.error = error;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
