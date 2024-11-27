package br.com.equipeWeg.ProjetoLoginCost.controller;


import br.com.equipeWeg.ProjetoLoginCost.model.CadastroProduto;
import br.com.equipeWeg.ProjetoLoginCost.repository.CadastroProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private CadastroProdutoRepository repository;

    @PostMapping
    public CadastroProduto createProduto(@RequestBody CadastroProduto produto) {

        CadastroProduto produtoSave = new CadastroProduto(produto.getNome(), produto.getDescricao(), produto.getValor(),produto.getImagem(), produto.getSku());
        repository.save(produtoSave);

        System.out.println(produtoSave);
        return produto;
    }
}