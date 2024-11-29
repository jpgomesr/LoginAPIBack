package br.com.equipeWeg.ProjetoLoginCost.controller;


import br.com.equipeWeg.ProjetoLoginCost.model.CadastroProduto;
import br.com.equipeWeg.ProjetoLoginCost.repository.CadastroProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private CadastroProdutoRepository repository;

    @PostMapping
    public CadastroProduto createProduto(@RequestBody CadastroProduto produto) {
        repository.save(produto);
        System.out.println(produto);
        return produto;
    }

    @GetMapping("/{sku}")
    public CadastroProduto getProduto(@PathVariable String sku) {
        return repository.findBySku(sku);
    }

    @GetMapping
    public List<CadastroProduto> getAllProdutos() {
        return repository.findAll();
    }

    @DeleteMapping("/{sku}")
    public void deleteProduto(@PathVariable String sku) throws SQLException {
        if (repository.findBySku(sku) != null) {
            repository.delete(repository.findBySku(sku));
        } else {
            throw new SQLException();
        }
    }

}
