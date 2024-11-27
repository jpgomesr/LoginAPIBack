package br.com.equipeWeg.ProjetoLoginCost.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_produto")
public class CadastroProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String nome;

    @Column
    private float valor;

    @Column
    private String descricao;

    @Column
    private String imagem;

    @Column
    //Codigo do Produto, para fazer uma busca
    private String sku;

    public CadastroProduto() {
        super();
    }

    public CadastroProduto(String nome, String descricao, float valor, String imagem, String sku) {
        super();
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.imagem = imagem;
        this.sku = sku;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "CadastroProduto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", Imagem='" + imagem + '\'' +
                ", sku='" + sku + '\'' +
                '}';
    }
}
