package dio.web.api.handle;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Hidden // Oculta da documentação se quiser
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ResponseError> handleBusinessException(BusinessException ex) {
        ResponseError error = new ResponseError(
            new Date(), "error", HttpStatus.BAD_REQUEST.value(), ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        String formatted = "Erro de validação: " + errors;

        ResponseError error = new ResponseError(
            new Date(), "error", HttpStatus.BAD_REQUEST.value(), formatted
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseError> handleJsonParseError(HttpMessageNotReadableException ex) {
        ResponseError error = new ResponseError(
            new Date(), "error", HttpStatus.BAD_REQUEST.value(), "JSON mal formatado: " + ex.getMostSpecificCause().getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> handleGeneralException(Exception ex) {
        ResponseError error = new ResponseError(
            new Date(), "error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro interno: " + ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
