package br.com.zup.vacinacao.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String cpf;
    private LocalDate dataNascimento;

    public Usuario() {
    }

    //Método mudar, responsável pela validação dos dados e retorno dos status (400 e 201)

    public Usuario(String nomeUsuario, String emailUsuario, String cpf, LocalDate dataNascimento) {
        this.nome = nomeUsuario;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = emailUsuario;
    }
}