package br.com.zup.vacinacao.Repository;

import br.com.zup.vacinacao.Model.Vacinacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacinacaoRepository extends JpaRepository<Vacinacao, Long> {
}
