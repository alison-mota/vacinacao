package br.com.zup.vacinacao.Controller.Form;

import br.com.zup.vacinacao.Model.Usuario;
import br.com.zup.vacinacao.Model.Vacinacao;
import br.com.zup.vacinacao.Repository.UsuarioRepository;
import br.com.zup.vacinacao.Repository.VacinacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Optional;


public class VacinacaoForm {

    @NotBlank
    @Size(min = 4)
    private String nomeVacina;
    @Email
    private String emailUsuario;

    public VacinacaoForm(@NotBlank @Size(min = 4) String nomeVacina, @Email String emailUsuario) {
        this.nomeVacina = nomeVacina;
        this.emailUsuario = emailUsuario;
    }

    public ResponseEntity<Vacinacao> mudar(UsuarioRepository usuarioRepository, VacinacaoRepository vacinacaoRepository) {
        Optional<Usuario> usuario = Optional.ofNullable(usuarioRepository.findByEmail(emailUsuario));
        Usuario usuario1 = usuarioRepository.findByEmail(emailUsuario);
        if (usuario.isPresent()) {
            vacinacaoRepository.save(new Vacinacao(nomeVacina, usuario1));
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
