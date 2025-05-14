package dio.web.api.repository;

// Do java
import java.util.*;

import org.springframework.stereotype.Component;
// Do springboot
//import org.springframework.stereotype.Repository;

// Que eu fiz
import dio.web.api.model.Usuario;

@Component
public class UserRepository {

    /*
     * Salva o usuário.
     * 
     * Save = O usuário não existia, e agora existe no sistema
     * Update = O usuário já existia, mas agora suas informações foram atualizadas
     */
    public void save(Usuario usuario) {
        if (usuario.getId()==null)
            System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        else 
            System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
    }

    /*
     * Delete um usuário com base no id dele
     */
    public void deletById(Integer id){
        System.out.println("DELETE - Recebendo o id "+ id +" para ser excluido");
        System.out.println(id);
    }

    public List<Usuario> findAll(){
        
        System.out.println("LIST - lista os usuários");
        
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1, "usuario1", "senha123"));
        usuarios.add(new Usuario(2, "usuario2", "senha456"));
        
        return usuarios;
    }

    public Usuario findById(Integer id) {
        System.out.println("Retorna os usuários com base no ID");
        return new Usuario(2, "usuario2", "senha456");
    }

    public Usuario findByUsername(String username) {
        System.out.println("Retorna usuários com base no id");
        return new Usuario(2, "usuario2", "senha456");
    }


}
