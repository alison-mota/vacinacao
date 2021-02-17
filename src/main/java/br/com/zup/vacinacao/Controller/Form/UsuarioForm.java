package br.com.zup.vacinacao.Controller.Form;

import br.com.zup.vacinacao.Model.Usuario;
import br.com.zup.vacinacao.Repository.UsuarioRepository;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Optional;

public class UsuarioForm {

    @NotBlank
    @Size(min = 4)
    private String nomeUsuario;
    @Email
    private String emailUsuario;
    @CPF
    private String cpf;
    @NotNull
    private LocalDate dataNascimento;

    public UsuarioForm(@NotBlank @Size(min = 4) String nomeUsuario, @Email String emailUsuario, @CPF String cpf, @NotNull LocalDate dataNascimento) {
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public ResponseEntity<Usuario> mudar(UsuarioRepository usuarioRepository) {
        Optional<Usuario> usuarioCpf = usuarioRepository.findByCpf(cpf);
        Optional<Usuario> usuarioEmail = Optional.ofNullable(usuarioRepository.findByEmail(emailUsuario));
        if (usuarioCpf.isEmpty() && usuarioEmail.isEmpty()) {
            usuarioRepository.save(new Usuario(nomeUsuario, emailUsuario, cpf, dataNascimento));
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}