package br.com.equipeWeg.ProjetoLoginCost.controller;

import br.com.equipeWeg.ProjetoLoginCost.model.CadastroUsuario;
import br.com.equipeWeg.ProjetoLoginCost.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private CadastroRepository repository;

    @GetMapping
    public List<CadastroUsuario> listar() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public CadastroUsuario alterarAdminPerm(@PathVariable String id) {
        CadastroUsuario usuario = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
        usuario.setAdmin(!usuario.getAdmin());
        repository.save(usuario);
        return usuario;
    }

}
