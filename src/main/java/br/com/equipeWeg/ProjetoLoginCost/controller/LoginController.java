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
            return ResponseEntity.ok(response); // Retorna JSON { "message": "Login Realizado com Sucesso!" }
        } else {
            response.put("error", "Credenciais incorretas!");
            return ResponseEntity.status(401).body(response); // Retorna JSON { "error": "Credenciais incorretas!" }
        }
    }
}
