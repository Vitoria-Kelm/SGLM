package br.edu.ifpr.bsi.projetologmil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UnidadeMilitar {

    @Id
    private Long id;

    private String nome;
    private String localizacao;

    public UnidadeMilitar() {}

    public UnidadeMilitar(Long id, String nome, String localizacao) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }
}
