package br.edu.ifpr.bsi.projetologmil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Movimentacao {

    @Id
    private Long id;

    private Long idItem;
    private Long idUnidadeOrigem;
    private Long idUnidadeDestino;
    private int quantidade;
    private Date data;

    public Movimentacao() {}

    public Movimentacao(Long id, Long idItem, Long idUnidadeOrigem, Long idUnidadeDestino, int quantidade, Date data) {
        this.id = id;
        this.idItem = idItem;
        this.idUnidadeOrigem = idUnidadeOrigem;
        this.idUnidadeDestino = idUnidadeDestino;
        this.quantidade = quantidade;
        this.data = data;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdItem() { return idItem; }
    public void setIdItem(Long idItem) { this.idItem = idItem; }

    public Long getIdUnidadeOrigem() { return idUnidadeOrigem; }
    public void setIdUnidadeOrigem(Long idUnidadeOrigem) { this.idUnidadeOrigem = idUnidadeOrigem; }

    public Long getIdUnidadeDestino() { return idUnidadeDestino; }
    public void setIdUnidadeDestino(Long idUnidadeDestino) { this.idUnidadeDestino = idUnidadeDestino; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }
}
