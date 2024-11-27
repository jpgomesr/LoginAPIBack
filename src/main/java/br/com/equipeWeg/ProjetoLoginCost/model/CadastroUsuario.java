package br.com.equipeWeg.ProjetoLoginCost.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro")
public class CadastroUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String nome;
    @Column
    private String sobrenome;
    @Column
    private String email;
    @Column
    private String senha;

    public CadastroUsuario() {
        super();
    }

    public CadastroUsuario(String nome, String sobrenome, String email, String senha) {
        super();
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        if(this.email.contains("@")){
            return this.email;
        }else {
            return "Email invalido";
        }

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        if(this.senha.length() >= 6){
            return this.senha;
        }
        return "Senha invalida";
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CadastroUsuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}