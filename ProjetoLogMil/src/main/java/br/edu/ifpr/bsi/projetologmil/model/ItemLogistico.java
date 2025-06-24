package br.edu.ifpr.bsi.projetologmil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ItemLogistico {

    @Id
    private Long id;

    private String nome;
    private String tipo;
    private int quantidade;
    private String descricao;

    public ItemLogistico() {}

    public ItemLogistico(Long id, String nome, String tipo, int quantidade, String descricao) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
