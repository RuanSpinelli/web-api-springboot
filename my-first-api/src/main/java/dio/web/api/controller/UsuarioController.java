package dio.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dio.web.api.handle.BusinessException;
import dio.web.api.model.Usuario;
import dio.web.api.repository.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.*;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuários", description = "Operações CRUD para usuários")
public class UsuarioController {

    @Autowired
    private UserRepository repository;

    // CREATE - Cadastrar usuário
    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        if (usuario.getLogin() == null) {
            throw new BusinessException("O campo de login é obrigatório");
        }

        Usuario novoUsuario = repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    // READ - Listar todos
    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }

    // READ - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // READ - Buscar por login (mantendo seu método existente)
    @GetMapping("/buscar/{login}")
    public ResponseEntity<Usuario> buscarPorLogin(@PathVariable String login) {
        return repository.findByLogin(login)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE - Atualizar usuário
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(
            @PathVariable Integer id,
            @RequestBody Usuario usuarioAtualizado) {
        
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        usuarioAtualizado.setId(id);
        Usuario usuario = repository.save(usuarioAtualizado);
        return ResponseEntity.ok(usuario);
    }

    // DELETE - Remover usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}