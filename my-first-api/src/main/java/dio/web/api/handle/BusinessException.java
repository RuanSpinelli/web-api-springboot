package dio.web.api.handle;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Exceção de regras de negócio")
public class BusinessException extends RuntimeException {

    public BusinessException(String mensagem) {
        super(mensagem);
    }

    public BusinessException(String mensagem, Object... params) {
        super(String.format(mensagem, params));
    }
}
