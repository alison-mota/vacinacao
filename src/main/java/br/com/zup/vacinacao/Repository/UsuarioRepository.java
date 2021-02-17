package br.com.zup.vacinacao.Repository;


import br.com.zup.vacinacao.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String emailUsuario);
    Optional<Usuario> findByCpf(String cpf);
}