package br.edu.ifpr.bsi.projetologmil.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "relatorio")
public class Relatorio extends GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_relatorio")
    private Long idRelatorio;

    @Column(name = "tipo", nullable = false)
    private String tipo; // Ex: "Estoque", "Movimentacao", "Financeiro"

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "data_geracao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataGeracao;

    // Many-to-one relationship with Oficial (who generated the report)
    @ManyToOne
    @JoinColumn(name = "id_oficial_gerador", nullable = false)
    private Oficial oficialGerador;

    // Getters and Setters
    public Long getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(Long idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(Date dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public Oficial getOficialGerador() {
        return oficialGerador;
    }

    public void setOficialGerador(Oficial oficialGerador) {
        this.oficialGerador = oficialGerador;
    }
}