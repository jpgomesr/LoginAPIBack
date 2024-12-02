package br.com.equipeWeg.ProjetoLoginCost.controller;

import br.com.equipeWeg.ProjetoLoginCost.model.CadastroUsuario;
import br.com.equipeWeg.ProjetoLoginCost.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private CadastroRepository repository;

    @PostMapping
    public ResponseEntity<Map<String, String>> autenticarUsuario(@RequestBody CadastroUsuario usuario) {
        Map<String, String> response = new HashMap<>();

        CadastroUsuario cadastroUsuario = repository.findByEmail(usuario.getEmail());

        if (cadastroUsuario != null && cadastroUsuario.getSenha().equals(usuario.getSenha())) {
            response.put("message", "Login Realizado com Sucesso!");
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Credenciais incorretas!");
            return ResponseEntity.status(401).body(response);
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<CadastroUsuario> buscarUsuarioPorEmail(@PathVariable String email) {
        CadastroUsuario usuario = repository.findByEmail(email);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CadastroUsuario> buscarUsuarioPorId(@PathVariable String id) {
        if (repository.existsById(id)) {
            return ResponseEntity.ok(repository.findById(id).get());
        } else {
            return ResponseEntity.status(404).build();
        }
    }

}
