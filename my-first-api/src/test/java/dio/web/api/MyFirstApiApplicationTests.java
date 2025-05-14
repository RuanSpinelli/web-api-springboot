package dio.web.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "spring.main.web-application-type=none") // Desativa carregamento web desnecessário
class MyFirstApiApplicationTests {
    @Test
    void contextLoads() {
        // Teste vazio apenas para verificar carga do contexto
    }
}