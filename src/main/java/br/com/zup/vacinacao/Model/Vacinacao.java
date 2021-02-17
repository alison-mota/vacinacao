package br.com.zup.vacinacao.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Vacinacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nomeVacina;
    @ManyToOne
    private Usuario usuario;
    private LocalDateTime dataVacinacao = LocalDateTime.now();

    public Vacinacao() {
    }

    public Vacinacao(String nomeDaVacina, Usuario usuario) {
        this.nomeVacina = nomeDaVacina;
        this.usuario = usuario;
    }
}