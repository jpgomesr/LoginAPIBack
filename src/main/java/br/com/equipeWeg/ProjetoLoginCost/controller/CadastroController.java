package br.com.equipeWeg.ProjetoLoginCost.controller;

import br.com.equipeWeg.ProjetoLoginCost.model.CadastroUsuario;
import br.com.equipeWeg.ProjetoLoginCost.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/cadastro")
public class CadastroController {

    @Autowired
    private CadastroRepository repository;

    @PostMapping
    public CadastroUsuario salvarUsuario(@RequestBody CadastroUsuario usuario) {

        CadastroUsuario usuarioSave = new CadastroUsuario(usuario.getId(), usuario.getNome(), usuario.getSobrenome(), usuario.getEmail(), usuario.getSenha());
        repository.save(usuarioSave);

        System.out.println(usuarioSave);
        return usuario;
    }
}
