package br.com.zup.vacinacao.Controller;

import br.com.zup.vacinacao.Controller.Form.UsuarioForm;
import br.com.zup.vacinacao.Controller.Form.VacinacaoForm;
import br.com.zup.vacinacao.Model.Usuario;
import br.com.zup.vacinacao.Model.Vacinacao;
import br.com.zup.vacinacao.Repository.UsuarioRepository;
import br.com.zup.vacinacao.Repository.VacinacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")

public class Controller {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VacinacaoRepository vacinacaoRepository;

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> cadastroUsuario(@Valid @RequestBody UsuarioForm form) {
        return form.mudar(usuarioRepository);
    }

    @PostMapping("/vacinacao")
    public ResponseEntity<Vacinacao> cadastroVacinacao(@Valid @RequestBody VacinacaoForm form) {
        return form.mudar(usuarioRepository, vacinacaoRepository);
    }
}
