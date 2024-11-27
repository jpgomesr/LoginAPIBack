package br.com.equipeWeg.ProjetoLoginCost.controller;

import br.com.equipeWeg.ProjetoLoginCost.model.CadastroUsuario;
import br.com.equipeWeg.ProjetoLoginCost.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private CadastroRepository repository;

    @PostMapping
    public ResponseEntity<String> autenticarUsuario(@RequestBody CadastroUsuario usuario) {

        CadastroUsuario cadastroUsuario = repository.findByEmail(usuario.getEmail());

        if (cadastroUsuario != null && cadastroUsuario.getSenha().equals(usuario.getSenha())) {
            return ResponseEntity.ok("Login Realizado com Sucesso!");
        }

        return ResponseEntity.status(401).body("Credenciais incorretas!");
    }
}
